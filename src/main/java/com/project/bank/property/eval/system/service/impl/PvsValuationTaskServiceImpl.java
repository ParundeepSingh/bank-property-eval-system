package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.dao.PVSValuationRequestDao;
import com.project.bank.property.eval.system.model.PvsValuationTask;
import com.project.bank.property.eval.system.repository.PVSValuationRequestRepository;
import com.project.bank.property.eval.system.service.PvsValuationTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PvsValuationTaskServiceImpl implements PvsValuationTaskService {

    @Autowired
    private PVSValuationRequestRepository pvsValuationRequestRepository;

    @Override
    public PvsValuationTask createNewPvsValuationTask(int userId) {
        PVSValuationRequestDao pvsValuationRequestDao = pvsValuationRequestRepository.save(
                new PVSValuationRequestDao()
                        .setReceivedDateTime(LocalDateTime.now())
                        .setCreatedDateTime(LocalDateTime.now())
                        .setModifiedDateTime(LocalDateTime.now())
                        .setUserId(userId)
                        .setIsActive(1)
                        .setStatus(1)
        );


        return PvsValuationTask.builder()
                .createdDateTime(pvsValuationRequestDao.getCreatedDateTime())
                .modifiedDateTime(pvsValuationRequestDao.getModifiedDateTime())
                .receivedDateTime(pvsValuationRequestDao.getReceivedDateTime())
                .reqId(pvsValuationRequestDao.getRequestId())
                .isActive(pvsValuationRequestDao.getIsActive() == 1)
                .status(pvsValuationRequestDao.getStatus())
                .build();
    }


    public List<PvsValuationTask> getAllPvsValuationTask(int userId) {
        List<PVSValuationRequestDao> pvsValuationRequestDaos = pvsValuationRequestRepository.findByUserId(userId);

        return pvsValuationRequestDaos.stream().map(item -> mapPvsValuationTaskDaoToModel(item)).collect(Collectors.toList());
    }

    private PvsValuationTask mapPvsValuationTaskDaoToModel(PVSValuationRequestDao pvsValuationRequestDao) {
        return PvsValuationTask.builder()
                .reqId(pvsValuationRequestDao.getRequestId())
                .receivedDateTime(pvsValuationRequestDao.getReceivedDateTime())
                .createdDateTime(pvsValuationRequestDao.getCreatedDateTime())
                .modifiedDateTime(pvsValuationRequestDao.getModifiedDateTime())
                .status(pvsValuationRequestDao.getStatus())
                .isActive(pvsValuationRequestDao.getIsActive() == 1)
                .build();
    }
}
