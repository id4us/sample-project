package com.asterik.utility.snapshot.configuration;

import com.asterik.utility.snapshot.messageUsingJms.SpringJmsConsumer;
import com.asterik.utility.snapshot.messageUsingJms.SpringJmsProducer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsT = new JmsTemplate();
        jmsT.setConnectionFactory(connectionFactory());
        jmsT.setReceiveTimeout(10000);
        jmsT.setConnectionFactory(connectionFactory());
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
        springJmsProducer.setJmsTemplate(jmsTemplate());
        return  springJmsProducer;
    }
    @Bean
    public SpringJmsConsumer springJmsConsumer(){
        SpringJmsConsumer springJmsConsumer= new SpringJmsConsumer();
        springJmsConsumer.setDestination(destination());
        springJmsConsumer.setJmsTemplate(jmsTemplate());
        return springJmsConsumer;
    }

}
