package com.project.bank.property.eval.system.model.upload.types;

import lombok.Getter;

@Getter
public enum DocumentType {
    TITLE_DEED("Title Deed"),
    NATIONAL_IDENTITY_CARD("National Identity Card"),
    BUILDING_PERMITS("Building Permits"),
    BIRTH_CERTIFICATE("Birth Certificate"),
    MARRIAGE_CERTIFICATE("Marriage Certificate"),
    QUOTATION("Quotation"),
    LETTER_OF_INTENT("Letter of Intent");

    private String documentType;


    DocumentType(String documentType) {
        this.documentType = documentType;
    }
}
