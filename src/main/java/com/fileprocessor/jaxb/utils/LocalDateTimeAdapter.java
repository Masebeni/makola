package com.fileprocessor.jaxb.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateTimeAdapter {
    private static final Logger logger = LoggerFactory.getLogger(LocalDateTimeAdapter.class);

    protected LocalDateTimeAdapter() {
        // checkstyle fix
    }

    public static LocalDateTime unmarshal(final String source) {
        try {
            if (StringUtils.isNotBlank(source)) {
                LocalDateTime result = LocalDateTime.parse(source, DateTimeFormatter.ISO_DATE_TIME);
                return result;
            }
            return null;
        } catch (DateTimeParseException ex) {
            logger.error("Could not parse date" + source, ex);
            return null;
        }
    }

    public static String marshal(final LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
