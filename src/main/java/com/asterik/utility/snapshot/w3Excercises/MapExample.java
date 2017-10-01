package com.asterik.utility.snapshot.w3Excercises;

import java.util.*;
import java.util.stream.Collectors;

public class MapExample {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap<>();
        map.put(1, "Green");
        map.put(2,"Red");
        map.put(3,"BLUE");
        map.put(4,"Red");
        map.put(5,"Red");

//        System.out.println(map.containsKey(1));
//        System.out.println(map.values());
//
//        System.out.println(map.size());
//
//        map.keySet().stream().
//                filter(s->s.equals(1)).forEach(System.out::println);
//
//
//        System.out.println(map.values());
//        System.out.println(map.values().stream().filter(s->s.equals("Green"))
//                .map(s->s.concat("color")).collect(Collectors.toList()));

        System.out.println(filterOddNumber(Arrays.asList(1,3,2,4,6,1)));

        }

    public static List<Integer> filterOddNumber(List<Integer> listOfNumbers)
    {
        for (int i = 0; i < listOfNumbers.size(); i++)
        {
            if (listOfNumbers.get(i)%2 == 0)
            {
                System.out.println(listOfNumbers.get(i));
                listOfNumbers.remove(i);

            }
        }
        return listOfNumbers;
    }




}
