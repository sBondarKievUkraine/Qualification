package com.bondar.common.handlers;

import com.bondar.common.entities.Client;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class ClientHandlerTest {
    private Integer clientInn = 1234567890;
    private String clientFirstName = "Ivan";
    private String clientLastName = "Ivanoff";
    private String clientmiddleName = "Ivanoff";

    @Test
    public void parseClientTest() throws ParserConfigurationException, SAXException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File xmlClientFile = new File(classLoader.getResource("client.xml").getFile());
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ClientHandler clientHandler = new ClientHandler();
        parser.parse(xmlClientFile, clientHandler);
        Client client = clientHandler.getClient();
        Assert.assertEquals(clientInn,client.getInn());
        Assert.assertEquals(clientFirstName,client.getFirstName());
        Assert.assertEquals(clientLastName,client.getLastName());
        Assert.assertEquals(clientmiddleName,client.getMiddleName());

    }

}