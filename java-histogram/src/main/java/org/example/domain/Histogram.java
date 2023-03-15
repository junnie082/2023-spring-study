package org.example.domain;

import java.util.*;

/**
 * 히스토그램 도메인 클래스
 */
public class Histogram {

    public static List<String> histogram = new ArrayList<>();
    public static List<String> nameOfData = new ArrayList<>();
    public static List<Integer> numbers = new ArrayList<>();
    public static List<Integer> dataType = new ArrayList<>();

    public static double ave = 0;

    public void addBarsInHistogram() {
        String bar = "";
        for (int i = 0; i < numbers.size(); i++) {
            int index = i;
            bar = "";
            for (int j = 0; j < numbers.get(index); j++) {
                bar += "=";
            }
            histogram.add(bar);
        }
    }

    public void calAverage() {
        for (int i = 0; i < numbers.size(); i++) {
            ave += numbers.get(i);
        }
        ave /= numbers.size();
    }

}
