package com.asterik.utility.snapshot.codewarsExamples;

import org.junit.Test;

import static org.junit.Assert.*;

public class MostDigitsTest {


    @Test
    public void exampleTest1()
    {
        assertEquals(80000, MostDigits.findLongest(new int[] {80000, 8, 90000}));
    }

    @Test
    public void exampleTest2()
    {
        assertEquals(9000, MostDigits.findLongest(new int[] {9000, 8, 9000}));
    }

    @Test
    public void exampleTest3()
    {
        assertEquals(1962444966, MostDigits.findLongest(new int[] {1962444966,-1662243274, 8, 7000,9000,100001}));
    }


}