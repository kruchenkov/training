package simpleValidate;

import org.xml.sax.SAXException;
import xml.PlaneErrorHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class BaseValidatorMain {
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = System.getProperty("user.dir") + "/Lab3/planes.xml";
        String schemaName = System.getProperty("user.dir") + "/Lab3/planes.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {

            Schema schema = factory.newSchema(schemaLocation);

            Validator validator = schema.newValidator();
            Source source = new StreamSource(fileName);

            validator.setErrorHandler(new PlaneErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.err.println(fileName + " is not correct or valid");
            e.printStackTrace();
        }
    }
}
