package com.asterik.utility.snapshot.w3Excercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ArrayListExcercise {

    public static void main(String[] args) {

        List<Object> list = new ArrayList<Object>(){
            {
            add(1);
            add(4);
            add(11);
            add(8);
            add(2);
            add(11);
             }
        };

        List<Object> list2 = new ArrayList<Object>(){
            {
                add("Green");
                add("Red");
                add("blue");
                add(1);
                add("grey");
            }
        };


        InsertElementOnFirstPosition insertElementOnFirstPosition = new InsertElementOnFirstPosition(list);
        InsertElementOnFirstPosition insertElementOnSecondList = new InsertElementOnFirstPosition(list2);
        insertElementOnFirstPosition.addElement(3);
        insertElementOnSecondList.addElement("purple");


        RemoveOddElements removeOddElements= new RemoveOddElements(list);
        RemoveOddElements removeOddElementslist= new RemoveOddElements(list2);
        removeOddElements.removeMethod();
        removeOddElementslist.removeMethod();



    }

    private static class InsertElementOnFirstPosition {

        List<Object> initialList= new ArrayList<>();

        public InsertElementOnFirstPosition(List<Object> initialList) {
            this.initialList = initialList;
        }

        public void addElement(Object a){
            initialList.add(0,a);
            System.out.printf("The new list is "+ initialList.toString());
        }



    }


    private static class RemoveOddElements{

        List<Object> initialList= new ArrayList<>();
        public RemoveOddElements(List<Object> list) {

            this.initialList = list;
        }

        void removeMethod(){

            List<Object> listx = initialList.stream().
                    filter(value -> value instanceof Integer).
                    collect(Collectors.toList());
            System.out.println(listx);

        }
    }

}
