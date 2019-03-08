package com.kali.kali.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.File;

public class StoreData {
    public static void main(String[] args) {
        //Create typesafe ServiceRegistry object
        Configuration configuration = new Configuration()
                .configure(new File("D:/Mahankaleswararao-301710/firstJava/src/main/java/com/kali/hibernate/resources/hibernate.cfg.xml"));
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        Employee emp=new Employee();
        emp.setId(103);
        emp.setFirstName("abc");
        emp.setLastName("xyz");

        session.save(emp);
        transaction.rollback();
        transaction.commit();

        System.out.println("successfully saved");
        sessionFactory.close();
        session.close();
    }
}
//SessionFactory sessionFactory = new Configuration().configure("D:/Mahankaleswararao-301710/firstJava/src/main/java/com/kali/hibernate/hibernate.cfg.xml").buildSessionFactory();
        /*StandardServiceRegistry ssr = new StandardServiceRegistryBuilder()
                .configure("D:/Mahankaleswararao-301710/firstJava/src/main/java/com/kali/hibernate/resources/hibernate.cfg.xml")
                .build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();*/