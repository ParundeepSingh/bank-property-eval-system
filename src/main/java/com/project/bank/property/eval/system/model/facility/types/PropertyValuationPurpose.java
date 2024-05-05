package com.project.bank.property.eval.system.model.facility.types;

import lombok.Getter;

@Getter
public enum PropertyValuationPurpose {
    REPARATION("1 - Reparation"),
    INHERITANCE("2 - Inheritance"),
    CONSTRUCTION("3 - Construction");

    private String purpose;


    PropertyValuationPurpose(String purpose) {
        this.purpose = purpose;
    }
}
