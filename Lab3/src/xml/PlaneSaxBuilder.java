package xml;

import domain.Plane;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class PlaneSaxBuilder {
    private Set<Plane> planes;
    private PlaneHandler handler = new PlaneHandler();
    private XMLReader reader;

    public PlaneSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        reader.setErrorHandler(new PlaneErrorHandler());
        reader.setContentHandler(handler);
    }

    public Set<Plane> getPlanes() {
        return planes;
    }

    public void buildSetPlanes(String fileName) {
        try {
            reader.parse(fileName);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }

        planes = handler.getPlanes();
    }
}
