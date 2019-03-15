package com.bondar;

import com.bondar.persistence.HibernateUtil;
import org.hibernate.Session;

public class App {
    public static void main( String[] args )
    {
        System.out.println("Qualification task is running.");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();



        session.getTransaction().commit();
    }
}
