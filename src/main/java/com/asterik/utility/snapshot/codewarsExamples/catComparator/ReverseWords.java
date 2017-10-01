package com.asterik.utility.snapshot.codewarsExamples.catComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class ReverseWords {


    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        List<String> newList = new ArrayList<>();
        List<String> list = Arrays.asList(s.split("\\s+"));
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        newList.stream().forEach(s1 -> sb.append(s1).append(" "));

        return sb.deleteCharAt(sb.length()-1).toString();



    }
}
