package xml;

import domain.Chars;
import domain.Plane;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

public class PlaneXMLWriter {
    public void write(List<Plane> planes, String fileName) throws FileNotFoundException, XMLStreamException {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("planes");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xmlns", "http://www.example.org/planes");
            writer.writeAttribute("xsi:schemaLocation", "http://www.example.org/planes planes.xsd");
            for (Plane plane : planes) {
                writer.writeStartElement("plane");
                writer.writeAttribute("id", plane.getId());
                writer.writeEndElement();
                writer.writeStartElement("model");
                writer.writeCharacters(plane.getModel());
                writer.writeEndElement();
                writer.writeStartElement("origin");
                writer.writeCharacters(plane.getOrigin());
                writer.writeEndElement();
                writer.writeStartElement("chars");
                for (Chars chars : plane.getChars()) {
                    writer.writeStartElement(chars.getElement());
                    writer.writeCharacters(chars.getValue());
                    writer.writeEndElement();
                }
                writer.writeEndElement();
                writer.writeStartElement("parameters");
                writer.writeStartElement("length");
                writer.writeCharacters(plane.getLength().toString());
                writer.writeEndElement();
                writer.writeStartElement("width");
                writer.writeCharacters(plane.getWidth().toString());
                writer.writeEndElement();
                writer.writeStartElement("height");
                writer.writeCharacters(plane.getHeight().toString());
                writer.writeEndElement();
                writer.writeEndElement();
                writer.writeStartElement("price");
                writer.writeCharacters(plane.getPrice().toString());
                writer.writeEndElement();
            }
            writer.writeEndElement();
            writer.writeEndDocument();
        } finally {
            try {
                writer.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
