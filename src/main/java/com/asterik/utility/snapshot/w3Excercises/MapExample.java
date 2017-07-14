package com.asterik.utility.snapshot.w3Excercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();
        map.put(1, "Green");
        map.put(2,"Red");
        map.put(3,"BLUE");
        map.put(4,"Red");
        map.put(5,"Red");

        System.out.println(map.containsKey(1));
        System.out.println(map.values());

        System.out.println(map.size());

        map.keySet().stream().
                filter(s->s.equals(1)).forEach(System.out::println);


        System.out.println(map.values());
        System.out.println(map.values().stream().filter(s->s.equals("Green"))
                .map(s->s.concat("color")).collect(Collectors.toList()));


    }



}
