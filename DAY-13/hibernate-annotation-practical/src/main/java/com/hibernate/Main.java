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
        // 1. Initialize Configuration and SessionFactory
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");

        try (SessionFactory factory = cfg.buildSessionFactory()) {

            // --- CREATE (Insert) ---
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                Student st1 = new Student("Anuj Gupta", "Indore");
                session.persist(st1); // Modern JPA way
                tx.commit();
                System.out.println("CREATE: Student saved with ID: " + st1.getId());
            }

            // --- READ (Fetch) ---
            int studentId;
            try (Session session = factory.openSession()) {
                // find() is the modern JPA standard; returns null if not found
                Student fetchedStudent = session.find(Student.class, 1);
                studentId = fetchedStudent.getId();
                System.out.println("READ: Fetched Student Name: " + fetchedStudent.getName());
            }
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                Student studentToUpdate = session.find(Student.class, studentId);

                if (studentToUpdate != null) {
                    studentToUpdate.setCity("Pune"); // Change state
                    session.merge(studentToUpdate); // Sync changes safely
                    tx.commit();
                    System.out.println("UPDATE: Student city changed to Pune.");
                }
            }

            // --- DELETE (Remove) ---
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                Student studentToDelete = session.find(Student.class, studentId);
                if (studentToDelete != null) {
                    session.remove(studentToDelete); // Deletes record
                    tx.commit();
                    System.out.println("DELETE: Student record removed.");
                }
            }

        } catch (Exception e) {
            System.err.println("Error during Hibernate operations:");
            e.printStackTrace();
        }
    }
}
