package com.project.bank.property.eval.system.model.upload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadSectionDetails {

    List<UploadedItem> uploadedDocuments;
}
