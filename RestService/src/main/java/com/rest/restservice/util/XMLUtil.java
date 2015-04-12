package com.rest.restservice.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Naveen Kumar
 */
public class XMLUtil {

    public static String convertToXml(Object source, Class... type) {
        String result;
        StringWriter sw = new StringWriter();
        try {
            JAXBContext context = JAXBContext.newInstance(type);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(source, sw);
            result = sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static Object convertToPojoUsingString(String xml, Class... type) {
        Object result;
        try {
            JAXBContext context = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InputStream stream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
            result = unmarshaller.unmarshal(stream);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    
    public static Object convertToPojoUsingFile(String fileName, Class... type) {
        Object result;
        try {
            JAXBContext context = JAXBContext.newInstance(type);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            result = unmarshaller.unmarshal(new File(fileName));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
