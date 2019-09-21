package com.fileprocessor.jaxb.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class OffsetDateTimeAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LocalDateTimeAdapter.class);

    protected OffsetDateTimeAdapter() {
        // checkstyle fix
    }

    public static OffsetDateTime unmarshal(final String source) {
        try {
            if (StringUtils.isNotBlank(source)) {
                OffsetDateTime result = OffsetDateTime.parse(source, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
                return result;
            }
            return null;
        } catch (DateTimeParseException ex) {
            try { // try to handle zoneless xml dateTime
                LocalDateTime localDateTime = LocalDateTime.parse(source, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                ZoneOffset offset = ZoneId.systemDefault().getRules().getOffset(localDateTime);
                return OffsetDateTime.of(localDateTime.toLocalDate(), localDateTime.toLocalTime(), offset);
            } catch (Exception fallbackTryException) {
                throw ex;
            }
        }
    }

    public static String marshal(final OffsetDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
