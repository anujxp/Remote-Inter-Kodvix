package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();

        try (SessionFactory factory = cfg.buildSessionFactory();
             Session session = factory.openSession()) {

            Transaction tx = session.beginTransaction();

            Student st = new Student("Anuj Gupta", "Indore");
            session.persist(st);

            tx.commit();
            System.out.println("Student saved successfully using Annotations!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
}