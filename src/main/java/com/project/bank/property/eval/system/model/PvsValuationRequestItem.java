package com.project.bank.property.eval.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PvsValuationRequestItem {

    @JsonIgnore
    private Long pvsValReqId;

    private String referenceNum;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime receivedDatetime;

    String borrowerName;

    String fosRef;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdDatetime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime modifiedDatetime;
}
