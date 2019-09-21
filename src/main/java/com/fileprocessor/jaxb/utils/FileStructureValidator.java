package com.fileprocessor.jaxb.utils;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public final class FileStructureValidator {

    private static final Logger log = LoggerFactory.getLogger(FileStructureValidator.class);
    public static final String PAIN001_01_05 = "pain.001.001.05.xsd";
    public static final String PAIN002_01_08 = "pain.002.001.08.xsd";
    public static final String PAIN007_01_07 = "pain.007.001.07.xsd";
    public static final String PAIN008_01_07 = "pain.008.001.07.xsd";
    public static final String PAIN009_01_05 = "pain.009.001.05.xsd";

    private FileStructureValidator() {
    }

    public static SchemaValidationResult validate(final File fileAbsolutePath, final String fileType) {
        return validateXMLAgainstSchema(new StreamSource(fileAbsolutePath), fileType);
    }

    public static SchemaValidationResult validate(final String xml, final String fileType) {
        return validateXMLAgainstSchema(new StreamSource(new StringReader(xml)), fileType);

    }

    private static SchemaValidationResult validateXMLAgainstSchema(final StreamSource stream, final String fileType) {

        try {
            final Schema schema = generateXMLSchemaObject(fileType);

            final Validator validator = schema.newValidator();
            validator.validate(stream);
            return new SchemaValidationResult(true, null);

        } catch (IOException | SAXException e) {
            log.warn(String.format("Not a valid file : %s", e.getMessage()), e);
            return new SchemaValidationResult(false, e.getMessage());

        }

    }

    private static Schema generateXMLSchemaObject(final String fileType) throws SAXException {
        final SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        return factory.newSchema(FileStructureValidator.class.getClassLoader().getResource("xsd/pain/" + fileType));

    }
}
