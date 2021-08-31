package xml;

import domain.Plane;
import domain.Type;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class PlaneHandler extends DefaultHandler {
    private Set<Plane> planes;
    private Plane currentPlane;
    private PlaneXmlTag currentXmlTag;
    private EnumSet<Type> types;
    private EnumSet<PlaneXmlTag> withText;
    private static final String ELEMENT_PLANE = "plane";
    private static final String ELEMENT_GUN = "caliber";

    public PlaneHandler() {
        planes = new HashSet<Plane>();
        withText = EnumSet.range(PlaneXmlTag.MODEL, PlaneXmlTag.PRICE);
        types = EnumSet.range(Type.SUPPORT, Type.SCOUT);
    }

    public Set<Plane> getPlanes() {
        return planes;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        if (ELEMENT_PLANE.equals(qName)) {
            currentPlane = new Plane();
            currentPlane.setId(attributes.getValue(0));
        /*} else if (ELEMENT_GUN.equals(localName)) {
            currentPlane.getChars().setCaliber(attributes.getValue("wef","caliber"));*/

        }else {
            PlaneXmlTag temp = PlaneXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)){
                currentXmlTag = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        if (ELEMENT_PLANE.equals(qName)){
            planes.add(currentPlane);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length){
        String data = new String(ch, start, length).trim();

            if (currentXmlTag != null) {
                switch (currentXmlTag) {
                    case MODEL:
                        currentPlane.setModel(data);
                        break;
                    case ORIGIN:
                        currentPlane.setOrigin(data);
                        break;
                    case TYPE:
                        currentPlane.getChars().setType(Type.valueOf(data.toUpperCase()));
                        break;
                    case SITS:
                        currentPlane.getChars().setSits(Byte.parseByte(data));
                        break;
                    case GUN:
                        currentPlane.getChars().setCaliber(data);
                        break;
                    case AIRTOAIRMISSILES:
                        currentPlane.getChars().setAir_to_air_missiles(Byte.parseByte(data));
                        break;
                    case AIRTOGROUNDMISSILES:
                        currentPlane.getChars().setAir_to_ground_missiles(Byte.parseByte(data));
                        break;
                    case RADAR:
                        currentPlane.getChars().setRadar(Boolean.parseBoolean(data));
                        break;
                    case LENGTH:
                        currentPlane.getParameters().setLength(Long.parseLong(data));
                        break;
                    case WIDTH:
                        currentPlane.getParameters().setWidth(Long.parseLong(data));
                        break;
                    case HEIGHT:
                        currentPlane.getParameters().setHeight(Long.parseLong(data));
                        break;
                    case PRICE:
                        currentPlane.setPrice(Long.parseLong(data));
                        break;
                /*default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());*/
                }
            }
        currentXmlTag = null;
    }
}
