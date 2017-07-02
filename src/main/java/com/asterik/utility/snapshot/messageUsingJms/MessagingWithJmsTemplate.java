package com.asterik.utility.snapshot.messageUsingJms;

import com.asterik.utility.snapshot.configuration.ApplicationConfiguration;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import javax.jms.JMSException;

/**
 * Created by shilpa on 02/07/2017.
 */
public class MessagingWithJmsTemplate {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(ApplicationConfiguration.class);
        ctx.refresh();

        try {
            SpringJmsProducer springJmsProducer = (SpringJmsProducer) ctx
                    .getBean("springJmsProducer");
            springJmsProducer.sendMessage("SomeTask");

            SpringJmsConsumer springJmsConsumer = (SpringJmsConsumer) ctx
                    .getBean("springJmsConsumer");
            System.out.println("Consumer receives " + springJmsConsumer.receiveMessage());
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            ctx.close();
        }
    }

}

