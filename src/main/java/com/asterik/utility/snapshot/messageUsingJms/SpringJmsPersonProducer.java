package com.asterik.utility.snapshot.messageUsingJms;


import com.asterik.utility.snapshot.dto.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

@Data
public class SpringJmsPersonProducer {

    @Autowired
    private Person person;
    @Autowired
    private JmsTemplate jmsTemplate;
    private Destination destination;


    public void sendMessage(Person person){
        System.out.println("Sending message to Q "+getDestination().toString());
        jmsTemplate.convertAndSend(getDestination(),person);
    }



}
