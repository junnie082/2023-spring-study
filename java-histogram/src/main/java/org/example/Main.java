package org.example;

// InputView 클래스를 가져오려면 아래처럼 package 를 import 해 와야 함. 
import org.example.view.InputView;
import org.example.view.OutputView; 
import org.example.domain.Histogram;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(); 
        inputView.numberOfData();
        inputView.eachNumber();
        
        OutputView outputView = new OutputView();
        outputView.printHistogram();

    }
}