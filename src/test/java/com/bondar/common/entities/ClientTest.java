package com.bondar.common.entities;

import com.bondar.persistence.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.*;

public class ClientTest {
    private Integer clientInn = 1234567890;
    private String clientFirstName = "Ivan";
    private String clientLastName = "Ivanoff";
    private String clientmiddleName = "Ivanoff";

    @Test
    public void insertClientToDbTest()  {
        //TODO will mock the db connection
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();
            Client expectedClient = new Client();

            expectedClient.setInn(clientInn);
            expectedClient.setFirstName(clientFirstName);
            expectedClient.setLastName(clientLastName);
            expectedClient.setMiddleName(clientmiddleName);

            session.save(expectedClient);
            session.getTransaction().commit();

            session.beginTransaction();

            Client actualClient =  (Client) session.get(Client.class, clientInn);
            Assert.assertEquals(expectedClient, actualClient);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

}