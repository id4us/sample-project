package com.asterik.utility.snapshot.messageUsingJms;

import com.asterik.utility.snapshot.configuration.ApplicationConfiguration;
import com.asterik.utility.snapshot.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URISyntaxException;


public class PersonJmsMessageConvertor {

    public static void main(String[] args) throws URISyntaxException, Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(ApplicationConfiguration.class);
        context.refresh();


        try {
            SpringJmsPersonProducer springJmsProducer = (SpringJmsPersonProducer) context
                    .getBean("springJmsPersonProducer");
            Person joe = new Person("Joe", 37);
            System.out.println("Sending person " + joe);
            springJmsProducer.sendMessage(joe);

            SpringJmsPersonConsumer springJmsConsumer = (SpringJmsPersonConsumer) context
                    .getBean("getSpringJmsPersonConsumer");
            System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
        } finally {
            context.close();
        }
    }
    
}
