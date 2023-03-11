package org.example.view;

import org.example.Main;
import org.example.domain.Histogram;

import java.util.*;
/**
 * 입력을 담당하는 클래스
 */
public class InputView {

    ArrayList<Integer> numbers = new ArrayList();
    
    // 여기에 System.out.println(""); 를 했더니 오류가 났다.
    // 이건 왜 그럴까?
    // System.out.print(""); 
    public static Scanner input = new Scanner(System.in); 
    public static int n;

    public void numberOfData() {
        System.out.println("데이터의 개수를 입력해주세요."); 
        while (true) {
            try {
                Exception e = new IllegalArgumentException(); 
                n = input.nextInt(); 
                if (n < 0) throw e;
                break;
            } catch (Exception e) {
                System.out.println("[ERROR] 데이터의 개수는 음수일 수 없습니다.");
            }
        }
    }

    public void eachNumber() {
        System.out.println("각 데이터의 양을 입력해주세요.");
        int number;
        for (int i = 0; i < n; i++) {
            try {
                Exception e = new IllegalArgumentException();
                number = input.nextInt();
                if (number < 0) throw e; 
                numbers.add(number);
            } catch (Exception e) {
                System.out.println("[ERROR] 데이터의 값은 음수일 수 없습니다. 처음부터 다시 입력하세요."); 
                i = -1; 
                numbers.clear();
            }
        }
        Histogram histogram = new Histogram();
        histogram.drawHistogram(numbers);
    }
}
