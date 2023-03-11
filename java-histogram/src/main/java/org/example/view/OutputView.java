package org.example.view;

import java.util.*;
import org.example.domain.Histogram;;
/**
 * 결과 출력을 담당하는 클래스
 */
public class OutputView {

    public void printHistogram() {
        Histogram histogram = new Histogram();
        ArrayList histogram2 = histogram.getHistogram();

        for (int i = 0; i < histogram2.size(); i++) {
            System.out.println(histogram2.get(i));
        }
    }
}
