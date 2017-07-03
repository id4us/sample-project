package com.asterik.utility.snapshot.controller;

import com.asterik.utility.snapshot.dto.Person;
import com.asterik.utility.snapshot.messageUsingJms.SpringJmsPersonProducer;
import com.asterik.utility.snapshot.messageUsingJms.SpringJmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    Person person;

    @Autowired
    SpringJmsPersonProducer springJmsPersonProducer;

    @RequestMapping(value = "/name/{name}/age/{age}",method = RequestMethod.GET)
    public Person PersonCal(@PathVariable String name, @PathVariable int age) {

        person.setName(name);
        person.setAge(age);

//        springJmsPersonProducer.setPerson(person);
        springJmsPersonProducer.sendMessage(person);

        return person;

    }
}
