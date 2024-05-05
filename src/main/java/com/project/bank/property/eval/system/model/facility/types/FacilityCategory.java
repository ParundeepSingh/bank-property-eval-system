package com.project.bank.property.eval.system.model.facility.types;

import lombok.Getter;

@Getter
public enum FacilityCategory {

    APARTMENT("25000 - Apartment"),

    PBWM_HOUSING("25010 – PBWM Housing");

    private String category;

    FacilityCategory(String category) {
        this.category = category;
    }
}
