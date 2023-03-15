package org.example.view;

import org.example.domain.Histogram;

import java.util.*;
/**
 * 입력을 담당하는 클래스
 */

public class InputView {

    public static Scanner input = new Scanner(System.in);
    public static int n;

    public void setNumberOfData() {
        System.out.println("데이터의 개수를 입력해주세요.");
        try {
            n = inputN();
            validateN(n);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);   // 에러 메세지 출력 후, 프로그램을 종료시키려면 어떻게 해야 할까? 라는 질문에 gpt 가 추가하라고 알려준 코드.
        }

    }

    public int inputN() {
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {  // 예외 발생시 프로그램이 종료되게는 못하는 건가????
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }


    public void setData() {
        Histogram histogram = new Histogram();
        System.out.println("각 데이터의 양을 입력해주세요.");
        String str;
        for (int i = 0; i < n; i++) {
            str = input.nextLine();
            try {
                validateLength(str);
                validateN(Integer.parseInt(str.split(",")[1]));
                validateN(Integer.parseInt(str.split(",")[2]));
                histogram.nameOfData.add(str.split(",")[0]);
                histogram.numbers.add(Integer.parseInt(str.split(",")[1]));
                histogram.dataType.add(Integer.parseInt(str.split(",")[2]));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[ERROR] 데이터 이름, 데이터 양, 데이터 타입을 쉼표로 구분하여 알맞게 입력해주세요. ");
                throw new RuntimeException(e);
            }
        }
    }

    public void validateLength(String str) {
        int count = 0; 
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ',') {
                count++;
            }
        }
        if (count > 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void validateN(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("[ERROR] 0 이하일 수 없습니다.");
        }
    }
}
