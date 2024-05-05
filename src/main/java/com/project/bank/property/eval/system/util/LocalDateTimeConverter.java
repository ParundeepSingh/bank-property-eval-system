package com.project.bank.property.eval.system.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.time.LocalDateTime;
import java.sql.Timestamp;

/**
 * Utility class to convert LocalDateTime to Timestamp and vice-versa.
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    /**
     * Method converts the LocalDateTime to Timestamp
     * @param locDateTime
     * @return
     */
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime locDateTime) {
        return locDateTime == null ? null : Timestamp.valueOf(locDateTime);
    }

    /**
     * Method converts the Timestamp to LocalDateTime
     * @param sqlTimestamp
     * @return
     */
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp sqlTimestamp) {
        return sqlTimestamp == null ? null : sqlTimestamp.toLocalDateTime();
    }
}
