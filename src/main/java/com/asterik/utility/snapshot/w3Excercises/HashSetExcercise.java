package com.asterik.utility.snapshot.w3Excercises;

import java.util.HashSet;

public class HashSetExcercise {


    public static void main(String[] args) {
        HashSet<Object> hset = new HashSet<Object>();


        hset.add("Apple");
        hset.add("Mango");
        hset.add("Grapes");
        hset.add("Orange");
        hset.add("Fig");
        //Addition of duplicate elements
        hset.add("Apple");
        hset.add("Mango");
        //Addition of null values
        hset.add(null);
        hset.add(null);

        System.out.println(hset);

        System.out.println(hset.size());

    }


}
