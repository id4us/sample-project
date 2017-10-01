package com.asterik.utility.snapshot.codewarsExamples.catComparator;

import java.util.Comparator;

public class Cat implements Comparable<Cat> {

    public String name;
    public double weight;

    CatWeightComparator catWeightComparator = new CatWeightComparator();

    public Cat(String name, double weight){
        this.name= name;
        this.weight=weight;
    }

    @Override
    public int compareTo(Cat c) {
       return catWeightComparator.compare(this,c);
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

}
