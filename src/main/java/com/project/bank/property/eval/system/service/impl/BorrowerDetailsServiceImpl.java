package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.dao.BorrowerDetailsDao;
import com.project.bank.property.eval.system.dao.CustomerDetailsDao;
import com.project.bank.property.eval.system.model.borrower.Borrower;
import com.project.bank.property.eval.system.model.borrower.BorrowerDetails;
import com.project.bank.property.eval.system.repository.BorrowerDetailsRepository;
import com.project.bank.property.eval.system.repository.CustomerDetailsRepository;
import com.project.bank.property.eval.system.service.BorrowerDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BorrowerDetailsServiceImpl implements BorrowerDetailsService {

    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;

    @Autowired
    private BorrowerDetailsRepository borrowerDetailsRepository;

    @Override
    public BorrowerDetails save(BorrowerDetails borrowerDetails, long pvsValReqId) {

        CustomerDetailsDao customerDetailsDao =
                customerDetailsRepository.save(constructCustomerDetailsDao(borrowerDetails.getMainBorrower()));
        long mainBorrowerCustomerId = customerDetailsDao.getId();

        borrowerDetailsRepository.save(constructBorrowerDetailsDao(mainBorrowerCustomerId,pvsValReqId, true));


        for(Borrower jointBorrower: borrowerDetails.getJointBorrowers()){
            CustomerDetailsDao borrowerCustomerDetailsDao = constructCustomerDetailsDao(jointBorrower);
            borrowerCustomerDetailsDao = customerDetailsRepository.save(borrowerCustomerDetailsDao);

            BorrowerDetailsDao borrowerDetailsDao = constructBorrowerDetailsDao(borrowerCustomerDetailsDao.getId(), pvsValReqId, false);
            borrowerDetailsRepository.save(borrowerDetailsDao);
        }


        return borrowerDetails;
    }

    @Override
    public List<Borrower> getBorrowerDetails(List<Long> pvsValReqIds) {

        List<BorrowerDetailsDao> borrowerDetailsDaoList = borrowerDetailsRepository.findAllMainBorrowersByPvsReqId(pvsValReqIds);

        List<Long> customerIds = borrowerDetailsDaoList.stream().map(BorrowerDetailsDao::getCustomerId).collect(Collectors.toList());

        List<CustomerDetailsDao> customerDetailsDaoList =  customerDetailsRepository.findAllById(customerIds);


        Map<Long, CustomerDetailsDao> customerIdMapping = customerDetailsDaoList.stream().collect(Collectors.toMap(CustomerDetailsDao::getId, c -> c));

        List<Borrower> borrowers = new ArrayList<>();

        for(BorrowerDetailsDao borrowerDetailsDao: borrowerDetailsDaoList){
            Borrower borrower = new Borrower();
            borrower.setPvsValReqId(borrowerDetailsDao.getPvsReqId());
            CustomerDetailsDao customerDetailsDao1 = customerIdMapping.get(borrowerDetailsDao.getCustomerId());
            borrower.setAddress(customerDetailsDao1.getAddress());
            borrower.setContactNum(customerDetailsDao1.getNumber());
            borrower.setCustomerName(customerDetailsDao1.getName());
            borrower.setEmail(customerDetailsDao1.getEmail());

            borrowers.add(borrower);
        }


        return borrowers;
    }

    private Borrower mapBorrowerDetailsDaoToBorrowerModel(BorrowerDetailsDao borrowerDetailsDao){
        return Borrower.builder()
                .build();
    }

    private BorrowerDetailsDao constructBorrowerDetailsDao(long customerId, long pvsValReqId, boolean isMainBorrower){
        return new BorrowerDetailsDao()
                .setCustomerId(customerId)
                .setPvsReqId(pvsValReqId)
                .setIsMainBorrower(isMainBorrower ? 1 : 0);
    }


    private CustomerDetailsDao constructCustomerDetailsDao(Borrower borrower){
        return new CustomerDetailsDao()
                .setName(borrower.getCustomerName())
                .setEmail(borrower.getEmail())
                .setNumber(borrower.getContactNum())
                .setAddress(borrower.getAddress());
    }
    
    
}
