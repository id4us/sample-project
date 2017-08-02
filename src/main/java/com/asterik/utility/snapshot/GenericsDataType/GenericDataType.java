package com.asterik.utility.snapshot.GenericsDataType;

import java.util.Arrays;

class GenericDataType<T> {

    protected T[] stack = (T[]) new Object[100];

    int ptr = -1;

    void push(T data) {
        ptr++;
        stack[ptr] = data;
    }

    T pop() {
        return (T) stack[ptr--];
    }

    @Override
    public String toString() {
        return "GenericDataType{" +
                "stack=" + Arrays.toString(stack) +
                '}';
    }

    public static void main(String[] args) {

        GenericDataType<String> stringGenericDataType = new GenericDataType<String>();
        stringGenericDataType.push("shilpa");
        stringGenericDataType.push("ora");
        stringGenericDataType.push("oral");
        stringGenericDataType.push("oralb");
        stringGenericDataType.push("oralb");

        stringGenericDataType.pop();

        System.out.println(stringGenericDataType);
    }

}
