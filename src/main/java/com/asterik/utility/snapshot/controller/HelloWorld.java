package com.asterik.utility.snapshot.controller;

import com.asterik.utility.snapshot.email.Email;
import com.asterik.utility.snapshot.email.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @Autowired
    MessageSender messageSender;



    @RequestMapping("")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/email/{id}/message/{mes}",method = RequestMethod.GET)
    public String email(@PathVariable String id, @PathVariable String mes) {

        Email email = new Email(id,mes);
    messageSender.send(email);
        return "OK";

    }


}
