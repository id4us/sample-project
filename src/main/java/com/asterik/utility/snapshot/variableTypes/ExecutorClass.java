package com.asterik.utility.snapshot.variableTypes;

import java.util.Arrays;
import java.util.List;

public class ExecutorClass {

    public static void main(String[] args) {

        List<String> supplierNames = Arrays.asList("sup1", "sup2", "sup3");
        FinalClassVariableExample finalClassVariableExample = new FinalClassVariableExample(supplierNames);

        System.out.println(finalClassVariableExample.getFoo());

    }
}
