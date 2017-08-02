package com.asterik.utility.snapshot.GenericsDataType;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

public class MathGenericOperation<T> {

    protected T num1;
    protected T num2;

    List<T> tList = new ArrayList<>();

    T Sum(T a, T b) {

        try {
            if (a instanceof Integer && b instanceof Integer) {
                return (T) (Integer) ((Integer) a + (Integer) b);
            } else if (a instanceof String && b instanceof Integer) {
                return (T) (String) ((String) ((String) a).concat((String) b));
            } else if (a instanceof Float && b instanceof Float) {
                return (T) (Float) ((Float) a + (Float) b);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        return null;
    }


    public static void main(String[] args) {

        MathGenericOperation<Integer> integerMathGenericOperation = new MathGenericOperation<Integer>();
        System.out.println("The sum of integers is "+ integerMathGenericOperation.Sum(4,7));

        MathGenericOperation<String> stringMathGenericOperation = new MathGenericOperation<>();
        System.out.println("The sum of strings is "+ stringMathGenericOperation.Sum("fred","perry"));
    }

}


