package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.model.PvsValuationRequestItem;
import com.project.bank.property.eval.system.model.PvsValuationTask;
import com.project.bank.property.eval.system.model.borrower.Borrower;
import com.project.bank.property.eval.system.model.property.PropertyValuationDetails;
import com.project.bank.property.eval.system.model.pvs.val.request.PvsValRequestDetails;
import com.project.bank.property.eval.system.service.*;
import com.project.bank.property.eval.system.util.ReferenceNumUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


@Slf4j
@Service
public class PvsValRequestServiceImpl implements PvsValRequestService {

    @Autowired
    private PvsValuationTaskService pvsValuationTaskService;

    @Autowired
    private FacilityDetailsService facilityDetailsService;

    @Autowired
    private PropertyValDetailsServiceImpl propertyValDetailsService;

    @Autowired
    private BorrowerDetailsService borrowerDetailsService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UploadedDocumentService uploadedDocumentService;

    @Override
    public boolean submitPvsValRequest(PvsValRequestDetails pvsValRequestDetails, int userId) {

        // Creating a New PVS Valuation Request Task which will give us pvsValReqId.
        PvsValuationTask pvsValuationTask = pvsValuationTaskService.createNewPvsValuationTask(userId);
        long pvsValReqId = pvsValuationTask.getReqId();

        // Saving the facility Details
        facilityDetailsService.save(
                pvsValRequestDetails.getFacilityDetails(),
                pvsValReqId
        );

        // Saving the Property Val Details FosRef and valuation Type
        propertyValDetailsService.save(
                pvsValRequestDetails.getPropertyValuationDetails(),
                pvsValReqId
        );

        borrowerDetailsService.save(pvsValRequestDetails.getBorrowerDetails(),
                pvsValReqId);


        // Saving the Comment Details
        commentService.save(pvsValRequestDetails.getCommentDetails(), pvsValReqId);


        // Saving the uploaded document Details
        uploadedDocumentService.save(pvsValRequestDetails.getUploadedDocuments(), pvsValReqId);

        log.info("[PvsValRequestServiceImpl][submitPvsValRequest]: pvsValuationRequest: {}", pvsValuationTask);
        return true;
    }


    public List<PvsValuationRequestItem> getAllPvsValuationRequestItem(int userId){

        List<PvsValuationRequestItem> pvsValuationRequestItems = new ArrayList<>();

        List<PvsValuationTask> pvsValuationTasks = pvsValuationTaskService.getAllPvsValuationTask(userId);

        pvsValuationRequestItems = pvsValuationTasks.stream().map(item -> mapPvsValuationTaskToPvsValuationRequestItem(item)).collect(Collectors.toList());

        List<Long> pvsValReqIds = pvsValuationTasks.stream().map(PvsValuationTask::getReqId).collect(Collectors.toList());

        List<Borrower> borrowers = borrowerDetailsService.getBorrowerDetails(pvsValReqIds);

        updateBorrowerName(pvsValuationRequestItems, borrowers);

        List<PropertyValuationDetails> propertyValuationDetails = propertyValDetailsService.getAllByPvsReqIds(pvsValReqIds);

        updateFosReferenceNumber(pvsValuationRequestItems, propertyValuationDetails);

        return pvsValuationRequestItems;
    }

    private void updateBorrowerName(List<PvsValuationRequestItem> pvsValuationRequestItems, List<Borrower> borrowers){

        Map<Long, Borrower> borrowerPvsReqIdMap = borrowers.stream().collect(Collectors.toMap(Borrower::getPvsValReqId, c -> c));

        for(PvsValuationRequestItem pvsValuationRequestItem: pvsValuationRequestItems){
            Borrower borrower = borrowerPvsReqIdMap.get(pvsValuationRequestItem.getPvsValReqId());
            if(Objects.nonNull(borrower)){
                pvsValuationRequestItem.setBorrowerName(borrower.getCustomerName());
            }
        }
    }


    private void updateFosReferenceNumber(List<PvsValuationRequestItem> pvsValuationRequestItems ,List<PropertyValuationDetails> propertyValuationDetails){
        Map<Long, PropertyValuationDetails> propertyValuationDetailsPvsReqIdMap = propertyValuationDetails.stream().collect(Collectors.toMap(PropertyValuationDetails::getPvsValReqId, c -> c));

        for(PvsValuationRequestItem pvsValuationRequestItem: pvsValuationRequestItems){
            PropertyValuationDetails propertyValuationDetailsItem = propertyValuationDetailsPvsReqIdMap.get(pvsValuationRequestItem.getPvsValReqId());
            if(Objects.nonNull(propertyValuationDetailsItem)){
                pvsValuationRequestItem.setFosRef(propertyValuationDetailsItem.getFosRefNum());
            }
        }
    }


    private PvsValuationRequestItem mapPvsValuationTaskToPvsValuationRequestItem(PvsValuationTask pvsValuationTask){
        String referenceNum = ReferenceNumUtility.constructReferenceNum(pvsValuationTask.getReqId(), pvsValuationTask.getReceivedDateTime());
        return PvsValuationRequestItem.builder()
                .pvsValReqId(pvsValuationTask.getReqId())
                .receivedDataTime(pvsValuationTask.getReceivedDateTime())
                .createdDatetime(pvsValuationTask.getCreatedDateTime())
                .modifiedDatetime(pvsValuationTask.getModifiedDateTime())
                .referenceNum(referenceNum)
                .build();
    }

}
