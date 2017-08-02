package com.asterik.utility.snapshot.variableTypes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CollectionFramework {

    static int i = 0;
    public static void main(String[] args) {


        List<Integer> list = new LinkedList<>();
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(3,4);

        while (list.iterator().hasNext()){
            System.out.println(list.get(2));

        }


    }

}
