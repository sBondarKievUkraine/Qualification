package com.bondar.common.handlers;

import com.bondar.common.entities.Transaction;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.List;


public class TransactionHandler extends DefaultHandler {

    private List<Transaction> transactionList = null;
    private Transaction transaction = null;
    private StringBuilder data = null;

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    private boolean bCard = false;
    private boolean bAmount = false;
    private boolean bClient = false;
    private boolean bCurrency = false;
    private boolean bPlace = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("transaction")) {
            // create a new com.bondar.common.entities.Transaction and put it in Map
            String card = attributes.getValue("card");
            // initialize com.bondar.common.entities.Transaction object and set card attribute
            transaction = new Transaction();
            transaction.setCard(card);
            // initialize list
            if (transactionList == null)
                transactionList = new LinkedList<Transaction>();
        } else if (qName.equalsIgnoreCase("card")) {
            bCard = true;
        } else if (qName.equalsIgnoreCase("client")) {
            bClient = true;
        } else if (qName.equalsIgnoreCase("amount")) {
            bAmount = true;
        } else if (qName.equalsIgnoreCase("currency")) {
            bCurrency = true;
        } else if (qName.equalsIgnoreCase("place")) {
            bPlace = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (bCard) {
            transaction.setCard(data.toString());
            bCard = false;
        }
        if (bAmount) {
            transaction.setAmount(Float.parseFloat(data.toString()));
            bAmount = false;
        } else if (bClient) {
//            transaction.setClient(data.toString());
            bClient = false;
        } else if (bPlace) {
            transaction.setPlace(data.toString());
            bPlace = false;
        } else if (bCurrency) {
            transaction.setCurrency(data.toString());
            bCurrency = false;
        }

        if (qName.equalsIgnoreCase("transaction")) {
            transactionList.add(transaction);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        data.append(new String(ch, start, length));
    }
}
