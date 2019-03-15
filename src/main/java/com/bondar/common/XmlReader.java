package com.bondar.common;

import com.bondar.common.entities.Transaction;
import com.bondar.common.handlers.TransactionHandler;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class XmlReader {
    private File xmlFile;

    public XmlReader() {
        ClassLoader classLoader = getClass().getClassLoader();
        this.xmlFile = new File(classLoader.getResource("test.xml").getFile());
    }

    public List<Transaction> getTransactionList(Document document){
        List transactionList = new LinkedList();
        document.normalizeDocument();

        return transactionList;
    }

    public Document readDocFromFile() throws IOException , SAXException , ParserConfigurationException {
        Document document = null;

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        document = docBuilder.parse(xmlFile);
        return document;
    }

    public List getListFromFile() throws ParserConfigurationException , SAXException , IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        TransactionHandler handler = new TransactionHandler();
        saxParser.parse(xmlFile, handler);
        List<Transaction> trList = handler.getTransactionList();
        return trList;

    }
}
