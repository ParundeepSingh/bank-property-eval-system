package com.project.bank.property.eval.system.util;

import java.time.LocalDateTime;

/**
 * Utility class which helps in generating different reference numbers.
 */
public class ReferenceNumUtility {

    /**
     * Method constructs the Reference Number for PVS Valuation Requests.
     * @param pvsReqId
     * @param receivedDateTime
     * @return
     */
    public static String constructReferenceNum(long pvsReqId, LocalDateTime receivedDateTime){
        StringBuilder referenceNum = new StringBuilder("PV");

        referenceNum.append(receivedDateTime.getYear());
        String month = String.valueOf(receivedDateTime.getMonth().getValue());
        referenceNum.append(month.length() == 2 ? month : "0" + month);

        String date = String.valueOf(receivedDateTime.getDayOfMonth());
        referenceNum.append(date.length() == 2 ? date : "0" + date);

        String sequenceNum = String.valueOf(pvsReqId);

        int lenOfSequenceNum = sequenceNum.length();
        int diff = 4 - lenOfSequenceNum;

        StringBuilder sequenceNumSubStr = new StringBuilder();
        while(diff-- > 0) sequenceNumSubStr.append("0");

        referenceNum.append(sequenceNumSubStr + sequenceNum);

        return referenceNum.toString();
    }

    /**
     * Method constructs the FOS Reference Number for Property Valuation Details.
     * @param applicationDatetime
     * @param sequenceNum
     * @return
     */
    public static String constructFosReferenceNumber(LocalDateTime applicationDatetime, long sequenceNum){
        StringBuilder fosReferenceNum = new StringBuilder("");

        fosReferenceNum.append(applicationDatetime.getYear());
        String month = String.valueOf(applicationDatetime.getMonth().getValue());
        fosReferenceNum.append(month.length() == 2 ? month : "0" + month);

        String sequenceNumStr = String.valueOf(sequenceNum);

        int lenOfSequenceNum = sequenceNumStr.length();
        int diff = 4 - lenOfSequenceNum;

        StringBuilder sequenceNumSubStr = new StringBuilder();
        while(diff-- > 0) sequenceNumSubStr.append("0");

        fosReferenceNum.append(sequenceNumSubStr + sequenceNumStr);

        return fosReferenceNum.toString();
    }
}
