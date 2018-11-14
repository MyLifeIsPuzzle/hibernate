package com.tretinnikov;

import com.tretinnikov.entity.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class main {

    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.save(new Message("First message"));
            Message message = session.find(Message.class, 1L);
            Message otherMessage = (Message) session.createQuery("SELECT m FROM Message m WHERE m.id = 2").getSingleResult();
            System.out.println(message);
            System.out.println(otherMessage);
        }
    }
}
