package com.asterik.utility.snapshot;

import com.asterik.utility.snapshot.email.Email;
import com.asterik.utility.snapshot.email.MessageSender;
import com.asterik.utility.snapshot.helperUtils.PersonMessageConvertor;
import com.asterik.utility.snapshot.messageUsingJms.SpringJmsPersonProducer;
import com.asterik.utility.snapshot.messageUsingJms.SpringJmsProducer;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@EnableJms
public class SnapshotApplication {

	@Bean
	public MessageSender messageSender(){
		MessageSender messageSender = new MessageSender();
		messageSender.setJmsTemplate(jmsTemplate());
		return messageSender;
	}

	@Bean
	public JmsTemplate jmsTemplate(){
		JmsTemplate jmsT = new JmsTemplate();
		jmsT.setConnectionFactory(connectionFactory());
		jmsT.setReceiveTimeout(10000);
		jmsT.setConnectionFactory(connectionFactory());
		jmsT.setMessageConverter(personMessageConvertor());
		return jmsT;
	}

	@Bean
	public PersonMessageConvertor personMessageConvertor(){
		PersonMessageConvertor personMessageConvertor = new PersonMessageConvertor();
		return personMessageConvertor;
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
	public SpringJmsProducer jmsProducerTemplate(){
		SpringJmsProducer springJmsProducer = new SpringJmsProducer();
		springJmsProducer.setDestination(destination());
		springJmsProducer.setJmsTemplate(jmsTemplate());
		return  springJmsProducer;
	}




//	@Bean
//	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
//													DefaultJmsListenerContainerFactoryConfigurer configurer) {
//		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
//		// This provides all boot's default to this factory, including the message converter
//		configurer.configure(factory, connectionFactory);
//		// You could still override some of Boot's default if necessary.
//		return factory;
//	}

//	@Bean // Serialize message content to json using TextMessage
//	public MessageConverter jacksonJmsMessageConverter() {
//		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//		converter.setTargetType(MessageType.TEXT);
//		converter.setTypeIdPropertyName("_type");
//		return converter;
//	}


	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SnapshotApplication.class, args);

		JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsTemplate");

		SpringJmsPersonProducer springJmsPersonProducer = (SpringJmsPersonProducer) context.getBean("springJmsPersonProducer");
		springJmsPersonProducer.setJmsTemplate(jmsTemplate);

		// Send a message with a POJO - the template reuse the message converter
		System.out.println("Sending an email message.");
	//	Email email = new Email("info@example.com", "HelloWorld");

		//jmsTemplate.convertAndSend("mailbox", "shilpa");
	}


}

