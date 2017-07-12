package com.asterik.utility.snapshot.variableTypes;

import org.springframework.cglib.core.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 This is to demonstrate final class variable. An uninitialised final variable has to be initialised in the constructor

 */
public class FinalClassVariableExample {

        private final List foo;

        public FinalClassVariableExample(List foo) {
            this.foo = foo;
        }

        public List getFoo() {
            return foo;

    }


}


