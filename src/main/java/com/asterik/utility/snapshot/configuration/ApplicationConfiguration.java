package com.asterik.utility.snapshot.configuration;

import com.asterik.utility.snapshot.dto.Person;
import com.asterik.utility.snapshot.helperUtils.PersonMessageConvertor;

import com.asterik.utility.snapshot.messageUsingJms.SpringJmsConsumer;
import com.asterik.utility.snapshot.messageUsingJms.SpringJmsPersonConsumer;
import com.asterik.utility.snapshot.messageUsingJms.SpringJmsPersonProducer;
import com.asterik.utility.snapshot.messageUsingJms.SpringJmsProducer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public JmsTemplate getJmsTemplate(){
        JmsTemplate jmsT = new JmsTemplate();
        jmsT.setConnectionFactory(connectionFactory());
        jmsT.setReceiveTimeout(10000);
        jmsT.setMessageConverter(personMessageConvertor());
        return jmsT;
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        return activeMQConnectionFactory;
    }

    @Bean
    public ActiveMQQueue destination(){
        ActiveMQQueue activeMQQueue= new ActiveMQQueue("jmsTemplateQ");
        return  activeMQQueue;
    }
    @Bean
    public SpringJmsProducer springJmsProducer(){
        SpringJmsProducer springJmsProducer = new SpringJmsProducer();
        springJmsProducer.setDestination(destination());
        springJmsProducer.setJmsTemplate(getJmsTemplate());
        return  springJmsProducer;
    }
    @Bean
    public SpringJmsConsumer springJmsConsumer(){
        SpringJmsConsumer springJmsConsumer= new SpringJmsConsumer();
        springJmsConsumer.setDestination(destination());
        springJmsConsumer.setJmsTemplate(getJmsTemplate());
        return springJmsConsumer;
    }

    @Bean
    public PersonMessageConvertor personMessageConvertor(){
        PersonMessageConvertor personMessageConvertor = new PersonMessageConvertor();
    return personMessageConvertor;
    }

    @Bean
    public SpringJmsPersonProducer springJmsPersonProducer(){
        SpringJmsPersonProducer springJmsPersonProducer = new SpringJmsPersonProducer();
        springJmsPersonProducer.setJmsTemplate(getJmsTemplate());
        springJmsPersonProducer.setDestination(destination());
        return springJmsPersonProducer;
    }

    @Bean
    public Person person() {
        Person person = new Person();
        return person;
    }

    @Bean
    public SpringJmsPersonConsumer getSpringJmsPersonConsumer(){

        SpringJmsPersonConsumer springJmsPersonConsumer = new SpringJmsPersonConsumer();
        springJmsPersonConsumer.setDestination(destination());
        springJmsPersonConsumer.setJmsTemplate(getJmsTemplate());

        return springJmsPersonConsumer;
    }


}
