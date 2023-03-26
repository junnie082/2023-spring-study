package org.example;

import java.util.*;
import org.example.view.InputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(); 
        
        while (true) {
            inputView.inputStart();
            inputView.askContinue();
        }
    }
}