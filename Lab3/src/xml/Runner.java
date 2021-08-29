package xml;

import domain.Plane;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) throws IOException, XMLStreamException {
        PlaneXMLValidator validator = new PlaneXMLValidator("planes.xml");
        if (validator.validate()) {
            PlaneXMLReader reader = new PlaneXMLReader();
            List<Plane> planes = reader.read("planes.xml");
//            Collections.sort(vauchers);
            Collections.sort(planes, new Comparator<Plane>() {
                @Override
                public int compare(Plane o1, Plane o2) {
                    return o2.getPrice().compareTo(o1.getPrice());
                }
            });
            for (Plane plane : planes) {
                System.out.println(plane);
            }
            PlaneXMLWriter writer = new PlaneXMLWriter();
            writer.write(planes, "planes-new.xml");
            System.out.println("OK");
        } else {
            System.out.println(validator.getError());
        }
    }
}
