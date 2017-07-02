package com.asterik.utility.snapshot.email;

import org.springframework.jms.core.JmsTemplate;

/**
 * Created by shilpa on 12/06/2017.
 */
public class MessageSender {

    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(final Object Object) {
        jmsTemplate.convertAndSend(Object);
    }

}
