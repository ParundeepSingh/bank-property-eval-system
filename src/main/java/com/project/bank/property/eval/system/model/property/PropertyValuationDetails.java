package com.project.bank.property.eval.system.model.property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.project.bank.property.eval.system.model.property.valuation.types.ValuationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PropertyValuationDetails {

    @JsonIgnore
    private Long pvsValReqId;

    private boolean isFOSRef;

    LocalDateTime applicationDatetime;

    ValuationType valuationType;

    String fosRefNum;
}
