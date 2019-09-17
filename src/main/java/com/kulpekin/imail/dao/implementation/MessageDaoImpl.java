package com.kulpekin.imail.dao.implementation;

import com.kulpekin.imail.dao.interfaces.MessageDaoInterface;
import com.kulpekin.imail.models.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDaoImpl implements MessageDaoInterface {

    private final SessionFactory sessionFactory;

    @Autowired
    public MessageDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void sentAndSaveMessage(Message message) {
        Session session = sessionFactory.getCurrentSession();
        session.save(message);
    }

    @Override
    public void deleteMessage(int id) {
        Session session = sessionFactory.getCurrentSession();
        Message message = session.get(Message.class,id);

        if(message!=null){
            session.delete(message);
        }
    }
}
