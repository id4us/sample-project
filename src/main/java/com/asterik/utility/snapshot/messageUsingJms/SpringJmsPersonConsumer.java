package com.asterik.utility.snapshot.messageUsingJms;


import com.asterik.utility.snapshot.dto.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;
@Data
public class SpringJmsPersonConsumer {

    private JmsTemplate jmsTemplate;
    private Destination destination;

    public Person receiveMessage(){

        Person person = (Person) getJmsTemplate().receiveAndConvert(destination);
        return person;


    }



}
