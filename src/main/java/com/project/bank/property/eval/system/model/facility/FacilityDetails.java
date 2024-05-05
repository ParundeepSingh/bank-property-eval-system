package com.project.bank.property.eval.system.model.facility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.project.bank.property.eval.system.model.facility.types.CCY;
import com.project.bank.property.eval.system.model.facility.types.FacilityCategory;
import com.project.bank.property.eval.system.model.facility.types.FacilityType;
import com.project.bank.property.eval.system.model.facility.types.PropertyValuationPurpose;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FacilityDetails {

    @JsonIgnore
    private Long pvsValReqId;

    private FacilityType type;

    private String category;

    private String purpose;

    private long term;

    private CCY ccy;

    private long amount;

    private boolean isHousingLoan;
}
