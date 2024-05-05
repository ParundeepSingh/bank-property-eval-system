package com.project.bank.property.eval.system.service.impl;

import com.project.bank.property.eval.system.dao.CommentsDao;
import com.project.bank.property.eval.system.dao.DocumentDetailsDao;
import com.project.bank.property.eval.system.model.comment.Comment;
import com.project.bank.property.eval.system.model.upload.UploadedItem;
import com.project.bank.property.eval.system.repository.DocumentDetailsRepository;
import com.project.bank.property.eval.system.service.UploadedDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UploadedDocumentServiceImpl implements UploadedDocumentService {

    @Autowired
    private DocumentDetailsRepository documentDetailsRepository;

    @Override
    public List<UploadedItem> save(List<UploadedItem> uploadedDocuments, long pvsValReqId) {

        List<DocumentDetailsDao> documentDetailsDaos = new ArrayList<>();
        for(UploadedItem uploadedItem : uploadedDocuments){
            documentDetailsDaos.add(constructCommentDaoFromModel(uploadedItem,pvsValReqId));
        }

        documentDetailsRepository.saveAll(documentDetailsDaos);
        return uploadedDocuments;
    }

    private DocumentDetailsDao constructCommentDaoFromModel(UploadedItem uploadedItem, long pvsValReqId){
        return new DocumentDetailsDao()
                .setUploadedBy(Integer.valueOf(uploadedItem.getUploadedBy()))
                .setPvsReqId(pvsValReqId)
                .setSize(uploadedItem.getFileSize())
                .setFilename(uploadedItem.getFileName())
                .setStoragePath(uploadedItem.getStoragePath())
                .setType(uploadedItem.getDocType())
                .setUploadedDatetime(LocalDateTime.now());

    }
}
