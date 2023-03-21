package org.example.view;

import java.util.*;
import org.example.domain.Histogram;
import org.example.view.InputView;
import org.example.domain.DataType;
/**
 * 결과 출력을 담당하는 클래스
 */
public class OutputView {

    Histogram histogramObj = new Histogram();

    public void printData() {
        OutputView outputView = new OutputView();

        System.out.println("히스토그램 결과입니다. ");
        for (int i = 0; i < histogramObj.getHistogram().size(); i++) {  //The static field Histogram.histogram should be accessed in a static way 이게 무슨 말일까?
            outputView.printNameOfData(i);
            System.out.print("(");
            outputView.printDataType(i);
            System.out.print("): ");
            outputView.printBars(i);
        }
    }

    public void printNameOfData(int i) {
        System.out.print(histogramObj.getNameOfData().get(i));
    }

    public void printDataType(int i) {
        System.out.print(DataType.convertCodeToType(histogramObj.getDataType().get(i)));
    }

    public void printBars(int i) {
        System.out.println(histogramObj.getHistogram().get(i));
    }


    public void printAverage() {
        System.out.println("데이터 양에 대한 평균입니다.");
        System.out.print("평균: ");

        histogramObj.calAverage();
        System.out.println(histogramObj.getAve());
    }

}
