package com.project.bank.property.eval.system.controller;

import com.project.bank.property.eval.system.model.PvsValuationRequestItem;
import com.project.bank.property.eval.system.model.borrower.Borrower;
import com.project.bank.property.eval.system.model.borrower.BorrowerDetails;
import com.project.bank.property.eval.system.model.comment.Comment;
import com.project.bank.property.eval.system.model.facility.FacilityDetails;
import com.project.bank.property.eval.system.model.facility.types.CCY;
import com.project.bank.property.eval.system.model.facility.types.FacilityCategory;
import com.project.bank.property.eval.system.model.facility.types.FacilityType;
import com.project.bank.property.eval.system.model.facility.types.PropertyValuationPurpose;
import com.project.bank.property.eval.system.model.property.PropertyValuationDetails;
import com.project.bank.property.eval.system.model.property.valuation.types.ValuationType;
import com.project.bank.property.eval.system.model.pvs.val.request.PvsValRequestDetails;
import com.project.bank.property.eval.system.model.upload.UploadedItem;
import com.project.bank.property.eval.system.model.upload.types.DocumentType;
import com.project.bank.property.eval.system.service.PvsValRequestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/pvs-val-request")
public class PvsValRequestsController {

    @Autowired
    private PvsValRequestService pvsValRequestService;

    @PostMapping("/submit")
    public ResponseEntity<?> submitPvsValRequest(@RequestBody PvsValRequestDetails pvsValRequestDetails) {
        pvsValRequestService.submitPvsValRequest(pvsValRequestDetails, 2);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<?> handleOtherException(Exception ex) {
        ErrorResponse errorResponse = ErrorResponse.builder(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage()).build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/tasks")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<?> getPvsValuationTasks() {

        List<PvsValuationRequestItem> pvsValuationRequestItems = new ArrayList<>();

        pvsValuationRequestItems = pvsValRequestService.getAllPvsValuationRequestItem(2);
        return new ResponseEntity<>(pvsValuationRequestItems, HttpStatus.OK);
    }

    private PvsValRequestDetails getDummy() {
        return PvsValRequestDetails.builder()
                .facilityDetails(FacilityDetails.builder()
                        .type(FacilityType.NON_REVOLVING)
                        .category(FacilityCategory.PBWM_HOUSING.getCategory())
                        .purpose(PropertyValuationPurpose.CONSTRUCTION.getPurpose())
                        .term(300l)
                        .ccy(CCY.MUR)
                        .isHousingLoan(true)
                        .build())
                .propertyValuationDetails(
                        PropertyValuationDetails.builder()
                                .isFOSRef(true)
                                .valuationType(ValuationType.NEW)
                                .fosRefNum("2003/12/123")
                                .build())
                .borrowerDetails(
                        BorrowerDetails.builder()
                                .mainBorrower(Borrower.builder()
                                        .email("amanda2@yahoo.com")
                                        .address("Address Sample Text")
                                        .customerName("Sample Text")
                                        .contactNum("Amanda Smith")
                                        .build())
                                .jointBorrowers(
                                        List.of(Borrower.builder()
                                                .email("amanda2@yahoo.com")
                                                .address("Address Sample Text")
                                                .customerName("Sample Text")
                                                .contactNum("Amanda Smith")
                                                .build()))
                                .build()
                )
                .commentDetails(List.of(
                        Comment.builder()
                                .createdDateTime(LocalDateTime.now())
                                .body("This is a first user comment")
                                .username("USER001")
                                .build(),
                        Comment.builder()
                                .createdDateTime(LocalDateTime.now())
                                .body("This is a another user comment")
                                .username("USER001")
                                .build()
                ))
                .uploadedDocuments(List.of(
                        UploadedItem.builder()
                                .docType(DocumentType.BIRTH_CERTIFICATE.getDocumentType())
                                .fileName("my first file.pdf")
                                .fileSize(2000)
                                .uploadedBy("USER001")
                                .uploadedDatetime(LocalDateTime.now())
                                .build(),
                        UploadedItem.builder()
                                .docType(DocumentType.TITLE_DEED.getDocumentType())
                                .fileName("my first file.xlsx")
                                .fileSize(150000)
                                .uploadedBy("USER001")
                                .uploadedDatetime(LocalDateTime.now())
                                .build()
                ))
                .build();
    }
}
