package com.asterik.utility.snapshot.messageUsingJms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.net.URISyntaxException;

/**
 * Created by shilpa on 02/07/2017.
 */
public class JmsProducer {
    public static void main(String[] args) throws URISyntaxException, Exception {
        Connection connection = null;
        try {
            // Producer
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    "tcp://localhost:61616");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue("customerQueue");
            MessageProducer producer = session.createProducer(queue);
            String payload = "Sending Message 2";
            Message msg = session.createTextMessage(payload);
            System.out.println("Sending text '" + payload + "'");
            producer.send(msg);
            session.close();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

}
