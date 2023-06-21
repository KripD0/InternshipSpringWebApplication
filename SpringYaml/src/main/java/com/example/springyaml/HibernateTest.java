package com.example.springyaml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateTest {
    private SessionFactory sessionFactory;

    public HibernateTest(){
        Configuration configuration = new Configuration().configure();
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public void outputAllPerson(){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            List<Person> people = session.createQuery("FROM Person").getResultList();
            for (Person person: people){
                System.out.println(person.getFullName());
            }
            session.getTransaction().commit();
        }
    }

    public void updateAllBanksName(){
        try (Session session = sessionFactory.getCurrentSession()){
            session.beginTransaction();
            session.createQuery("UPDATE Bank SET name='Test'").executeUpdate();
            session.getTransaction().commit();
        }
    }
}
