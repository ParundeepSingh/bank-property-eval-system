package com.project.bank.property.eval.system.model.pvs.val.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.project.bank.property.eval.system.model.borrower.BorrowerDetails;
import com.project.bank.property.eval.system.model.comment.Comment;
import com.project.bank.property.eval.system.model.facility.FacilityDetails;
import com.project.bank.property.eval.system.model.property.PropertyValuationDetails;
import com.project.bank.property.eval.system.model.upload.UploadedItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PvsValRequestDetails {

    FacilityDetails facilityDetails;

    PropertyValuationDetails propertyValuationDetails;

    BorrowerDetails borrowerDetails;

    List<Comment> commentDetails;

    List<UploadedItem> uploadedDocuments;
}
