package org.example.domain;

import java.util.*;

/**
 * 히스토그램 도메인 클래스
 */
public class Histogram {

    private static List<String> histogram = new ArrayList<>();
    private static List<String> nameOfData = new ArrayList<>();
    private static List<Integer> numbers = new ArrayList<>();
    private static List<Integer> dataType = new ArrayList<>();

    private static double ave = 0;

    public void setHistogram(String name, int number, int codeType) {
        this.nameOfData.add(name); 
        this.numbers.add(number);
        this.dataType.add(codeType); 
    }

    public void createHistogram() {
        for (int index = 0; index < numbers.size(); index++) {
            addBarToList(index);
        }
    }

    public void addBarToList(int index) {
        String bar = "";
        for (int i = 0; i < numbers.get(index); i++) bar += "=";
        histogram.add(bar);
    }

    public void calAverage() {
        for (int i = 0; i < numbers.size(); i++) {
            ave += numbers.get(i);
        }
        ave /= numbers.size();
    }

    public List<String> getHistogram() {
        return this.histogram;
    }

    public List<String> getNameOfData() {
        return this.nameOfData;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<Integer> getDataType() {
        return this.dataType;
    }

    public double getAve() {
        return this.ave;
    }

}
