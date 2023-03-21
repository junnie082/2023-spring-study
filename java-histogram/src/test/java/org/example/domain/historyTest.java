package org.example.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.*;
import org.junit.jupiter.api.Test;

public class historyTest {

    Histogram histogram = new Histogram();
    private static List<Integer> numbers = new ArrayList<>();

    @Test
    public void testAddBarToList() {
        String bar = "";
        for (int i = 0; i < 4; i++) bar += "=";

        assertEquals("====", bar);
    }

    @Test
    public void testCalAverage() {
        numbers.add(1);
        numbers.add(3);
        numbers.add(4);
        numbers.add(6);
        numbers.add(2); 
        double ave = 0;
        for (int i = 0; i < numbers.size(); i++) {
            ave += numbers.get(i);
        }
        ave /= numbers.size();

        assertEquals(ave, 3.2);
    }

}
