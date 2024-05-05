package com.project.bank.property.eval.system.model;

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
public class PvsValuationTask {

    long reqId;

    LocalDateTime receivedDateTime;

    LocalDateTime createdDateTime;

    LocalDateTime modifiedDateTime;

    boolean isActive;

    int status;
}
