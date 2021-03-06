package com.asterik.utility.snapshot.messageUsingJms;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@Data
public class SpringJmsConsumer {


    @Autowired
    private JmsTemplate jmsTemplate;
    private Destination destination;

    public String receiveMessage() throws JMSException {
        TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination);
        return textMessage.getText();
    }
}
