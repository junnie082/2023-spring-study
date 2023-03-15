package org.example;

import org.example.view.InputView;
import org.example.view.OutputView;
import org.example.domain.Histogram;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.setNumberOfData();
        inputView.setData();

        Histogram histogram = new Histogram();
        histogram.addBarsInHistogram();
        System.out.println();

        OutputView outputView = new OutputView();
        outputView.printData();
        System.out.println();
        outputView.printAverage();
    }
}