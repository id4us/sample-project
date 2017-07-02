package com.asterik.utility.snapshot.messageUsingJms;


import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class BrokerLauncher {
        public static void main(String[] args) throws URISyntaxException, Exception {
            BrokerService broker = BrokerFactory.createBroker(new URI(
                    "broker:(tcp://localhost:61616)"));
            File dir = new File("foo");
            dir.mkdir();


            broker.start();
        }
}
