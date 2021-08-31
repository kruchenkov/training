package simpleValidate;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ConsolePlaneHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("Parsing started");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes){
        StringBuilder tagData = new StringBuilder(qName + " ");
        for (int i = 0; i < attributes.getLength(); i++){
            tagData.append(" ").append(attributes.getQName(i)).append("=").append(attributes.getValue(i));
        }
        System.out.print(tagData);
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName){
        System.out.print(" " + qName);
    }

    @Override
    public void endDocument(){
        System.out.println("\nParsing ended");
    }
}
