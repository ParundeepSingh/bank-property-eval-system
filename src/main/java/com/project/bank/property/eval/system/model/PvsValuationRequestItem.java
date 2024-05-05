package com.project.bank.property.eval.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
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
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PvsValuationRequestItem {

    @JsonIgnore
    private Long pvsValReqId;

    private String referenceNum;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    LocalDateTime receivedDataTime;

    String borrowerName;

    String fosRef;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    LocalDateTime createdDatetime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    LocalDateTime modifiedDatetime;
}
