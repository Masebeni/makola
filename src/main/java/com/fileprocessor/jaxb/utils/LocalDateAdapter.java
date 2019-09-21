package com.fileprocessor.jaxb.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateAdapter {
    private static final Logger logger = LoggerFactory.getLogger(LocalDateAdapter.class);

    protected LocalDateAdapter() {
        // checkstyle fix
    }

    public static LocalDate unmarshal(final String source) {
        try {
            if (StringUtils.isNotBlank(source)) {
                LocalDate result = LocalDate.parse(source, DateTimeFormatter.ISO_DATE);
                return result;
            }
            return null;
        } catch (DateTimeParseException ex) {
            logger.error("Could not parse date" + source, ex);
            return null;
        }
    }

    public static String marshal(final LocalDate dateTime) {
        return dateTime.format(DateTimeFormatter.ISO_DATE);
    }

}
