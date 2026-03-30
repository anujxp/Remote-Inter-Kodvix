package com.hibernate;

import com.hibernate.entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        Transaction tx = null;
        try (SessionFactory factory = cfg.buildSessionFactory()) {
            try (Session session = factory.openSession()) {
                tx = session.beginTransaction();
                Student st = new Student();
                st.setName("Anuj Gupta");
                st.setCity("Indore");
                session.persist(st);
                tx.commit();
                System.out.println("Success: Student saved using XML config!");

            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();

        }
    }
}