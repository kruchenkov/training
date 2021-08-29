package xml;

import domain.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PlaneXMLReader {
    public List<Plane> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        List<Plane> planes = new ArrayList<>();
        try {

            Plane plane = null;
            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants
                            .START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("plane".equals(tagName)) {
                            plane = new Plane();
                            plane.setId(reader.getAttributeValue(null, "id"));
                        } else if ("model".equals(tagName)) {
                            plane.setModel(reader.getElementText());
                        } else if ("origin".equals(tagName)) {
                            plane.setOrigin(reader.getElementText());
                        } else if ("type".equals(tagName)) {
                            PlaneType planeType = new PlaneType();
                            planeType.setElement(tagName);
                            planeType.setValue(reader.getElementText());
                            plane.getChars().add(planeType);
                        } else if ("sits".equals(tagName)) {
                            Sits sits = new Sits();
                            sits.setElement(tagName);
                            sits.setValue(reader.getElementText());
                            plane.getChars().add(sits);
                        } else if ("gun".equals(tagName)) {
                            Gun gun = new Gun();
                            gun.setElement(tagName);
                            gun.setValue(reader.getAttributeValue(null, "id"));
                            plane.getChars().add(gun);
                        } else if ("air-to-air-missiles".equals(tagName)) {
                            AirToAirMissiles airToAirMissiles = new AirToAirMissiles();
                            airToAirMissiles.setElement(tagName);
                            airToAirMissiles.setValue(reader.getElementText());
                            plane.getChars().add(airToAirMissiles);
                        } else if ("air-to-ground-missiles".equals(tagName)) {
                            AirToGroundMissiles airToGroundMissiles = new AirToGroundMissiles();
                            airToGroundMissiles.setElement(tagName);
                            airToGroundMissiles.setValue(reader.getElementText());
                            plane.getChars().add(airToGroundMissiles);
                        } else if ("radar".equals(tagName)) {
                            isRadar radar = new isRadar();
                            radar.setElement(tagName);
                            radar.setValue(reader.getElementText());
                            plane.getChars().add(radar);
                        } else if ("length".equals(tagName)) {
                            plane.setLength(Long.parseLong(reader.getElementText()));
                        } else if ("width".equals(tagName)) {
                            plane.setWidth(Long.parseLong(reader.getElementText()));
                        } else if ("height".equals(tagName)) {
                            plane.setHeight(Long.parseLong(reader.getElementText()));
                        } else if ("price".equals(tagName)) {
                            plane.setPrice(Long.parseLong(reader.getElementText()));
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("plane".equals(tagName)) {
                            planes.add(plane);
                        }
                        break;
                    }
                }
            }
            return planes;
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
