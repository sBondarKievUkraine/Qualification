package com.bondar.common.handlers;

import com.bondar.common.entities.Client;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class ClientHandler extends DefaultHandler {

    Client client = new Client();
    String thisElement = "";

    public Client getClient(){
        return client;
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("inn")) {
            client.setInn(new Integer(new String(ch, start, length)));
        }
        if (thisElement.equals("firstName")) {
            client.setFirstName(new String(ch, start, length));
        }
        if (thisElement.equals("lastName")) {
            client.setLastName(new String(ch, start, length));
        }
        if (thisElement.equals("middleName")) {
            client.setMiddleName(new String(ch, start, length));
        }
    }

}
