package com.asterik.utility.snapshot.helperUtils;

import com.asterik.utility.snapshot.dto.Person;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;


public class PersonMessageConvertor implements MessageConverter{

    @Override
    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        Person person = (Person) o;
        MapMessage message = session.createMapMessage();
        message.setString("name", person.getName());
        message.setInt("age", person.getAge());
        return message;
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {

        MapMessage mapMessage = (MapMessage) message;
        Person person;
        person = new Person(((MapMessage) message).getString("name"),((MapMessage) message).getInt("age"));
        return person;
    }
}
