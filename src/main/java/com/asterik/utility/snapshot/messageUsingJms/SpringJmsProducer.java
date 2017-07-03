package com.asterik.utility.snapshot.messageUsingJms;

import lombok.Data;
import javax.jms.Message;
import javax.jms.Destination;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Session;


@Data
public class SpringJmsProducer {
    private JmsTemplate jmsTemplate;
    private Destination destination;


    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void sendMessage(final String msg) {
        System.out.println("Producer sends " + msg);
        jmsTemplate.send(destination, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }});
    }
}
