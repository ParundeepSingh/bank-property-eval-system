package com.project.bank.property.eval.system.service;

import com.project.bank.property.eval.system.model.upload.UploadedItem;

import java.util.List;

/**
 * Service Interface to perform operations related to Uploaded Document Details.
 */
public interface UploadedDocumentService {

    List<UploadedItem> save(List<UploadedItem> uploadedDocuments, long pvsValReqId);
}
