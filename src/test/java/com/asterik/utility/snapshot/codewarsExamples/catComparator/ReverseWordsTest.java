package com.asterik.utility.snapshot.codewarsExamples.catComparator;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsTest {

    @Test
    public void test1(){

        assertEquals(ReverseWords.reverseWords("I like eating"), "eating like I");
        assertEquals(ReverseWords.reverseWords("I like flying"), "flying like I");
        assertEquals(ReverseWords.reverseWords("The world is nice"), "nice is world The");

    }

}