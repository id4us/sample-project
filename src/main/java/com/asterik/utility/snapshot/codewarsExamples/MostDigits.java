package com.asterik.utility.snapshot.codewarsExamples;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MostDigits {

    public static int findLongest(int[] ints) {

        Map<Integer, Integer> list = new HashMap<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] < 0) {
                list.putIfAbsent(String.valueOf(-ints[i]).length(), ints[i]);
            } else {
                list.putIfAbsent(Integer.toString(ints[i]).length(), ints[i]);
            }
        }


        return list.get(list.keySet().stream().max(Comparator.comparingInt(Integer::shortValue)).get().intValue());

    }
}
