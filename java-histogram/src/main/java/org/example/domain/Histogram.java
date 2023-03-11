package org.example.domain;

import java.util.ArrayList;

/**
 * 히스토그램 도메인 클래스
 */
public class Histogram {
    static ArrayList histogram = new ArrayList(); 

    public void drawHistogram(ArrayList<Integer> numbers) {
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

    public ArrayList getHistogram() {
        return this.histogram;
    }
}
