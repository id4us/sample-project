package com.asterik.utility.snapshot.services;

import com.asterik.utility.snapshot.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by shilpa on 02/07/2017.
 */
public class PersonService implements PersonServiceImpl {

    @Autowired
    private Person person;


    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public int getAge() {
        return person.getAge();
    }
}
