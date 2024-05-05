package com.project.bank.property.eval.system.model.upload;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.project.bank.property.eval.system.model.upload.types.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UploadedItem {

    private String docType;

    private String fileName;

    private long fileSize;

    private String storagePath;

    private String uploadedBy;

    private LocalDateTime uploadedDatetime;
}
