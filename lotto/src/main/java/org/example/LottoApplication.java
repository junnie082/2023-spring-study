package org.example;

import java.util.Scanner;

import org.w3c.dom.css.CSS2Properties;

import java.nio.charset.IllegalCharsetNameException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

// 추상화를 적절하게 사용한다. 라는 말이 무엇인지 모르겠습니다. 
// MVC 패턴과 도메인을 적절하게 사용하여 구현하라는 말이 무엇인지 모르겠습니다. 

public class LottoApplication {

    int [][] randomNumbers; 
    int[] winNumbers = new int[7];
    Integer paid; 

    static double value = 0; 

    public int getKindOfLotto() {
        Scanner input = new Scanner(System.in); 
        int kindLotto;

        while (true) {
            try {
                Exception e = new IllegalArgumentException();
                kindLotto = input.nextInt();
                if (kindLotto < 1 || kindLotto > 3) {
                    throw e; 
                }
                break;
            } catch (Exception e) {
                System.out.println("[ERROR] 로또의 종류는 작은 로또(1), 중간 로또(2), 큰 로또(3) 세 가지 뿐입니다. 다시 입력해 주세요:");
            }
        }

        return kindLotto;
    }

    public int getPaid() {       // 로또를 구매하기 위해 지불할 돈을 입력 받는다. 한 장에 1000원 이므로 반드시 금액은 1000으로 나누어 떨어져야 한다. 
        Scanner input = new Scanner(System.in); 
        int paid; 
        while (true) {
            paid = input.nextInt(); 
            try {
                Exception e = new IllegalArgumentException();
                if (paid % 1000 != 0) throw e; 
                return paid;
            } catch (Exception e) {
                System.out.println("[ERROR] 로또 한 장은 1,000원이므로, 지불 금액은 반드시 1000의 배수여야 합니다. 다시 입력 하세요: ");
            }
        }
    }

    public Boolean[] countBonus(int index) {       // 보너스 로또 번호를 따로 입력 받는다.
        Boolean[] bonus = new Boolean[index];
        int i = 0; 
        for (int [] list: randomNumbers) {
            if (Arrays.asList(list).contains(winNumbers[6]))
                bonus[i++] = true; 
        }
        return bonus;
    }

    public void createRandomNumbers(int paid) {      // 로또 번호들을 랜덤하게 생성하여 int 형 배열에 저장한다. 
        randomNumbers = new int[paid/1000][6];       // flag 라는 변수를 사용하면 안될 것 같은데...
        int[] arr = new int[6]; 
        Random random = new Random(); 
        int flag; 
        for (int i = 0; i < paid/1000; i++) {
            for (int j = 0; j < 6; j++) {
                flag = 0; 
                int num = random.nextInt(45) + 1; 
                for (int k = 0; k < j; k++) {
                    if (num == arr[k]) {
                        j--; flag = 1;
                    }
                }
                if (flag == 1) continue;
                arr[j] = num; 
            }
            Arrays.sort(arr); 
            randomNumbers[i] = arr.clone();
        }
    }

    public void showRandomNumbers(int paid) {      // 생성된 로또 번호들을 출력하는 메서드다.  
        for (int i = 0; i < paid/1000; i++) {
            System.out.print("[");
            for (int j = 0; j < 6; j++) {
                System.out.print(Integer.toString(randomNumbers[i][j]));
                if (j != 5) System.out.print(", ");
            }
            System.out.println("]");
        }
    }

    public void getWinNumbers() {      // 당첨 번호를 입력 받는다. 번호는 반드시 1~45 사이여야 한다. 
        Scanner input = new Scanner(System.in); 
        String[] winNumber = input.nextLine().split(",");; 
        for (int i = 0; i < 6; i++) {
            try {
                Exception e = new IllegalArgumentException();
                if (Integer.parseInt(winNumber[i]) < 1 || Integer.parseInt(winNumber[i]) > 45 || winNumber.length < 1 || winNumber.length > 6) {
                    throw e;
                }
            } catch (Exception e) {
                System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 6개의 숫자여야 합니다.");
                winNumber = input.nextLine().split(",");
                i = 0; continue; 
            } 
            winNumbers[i] = Integer.parseInt(winNumber[i]); 
        }
    }

    public void getBonusNumber() {      // 보너스 번호를 따로 입력 받는다. '5개 일치 + 보너스 일치' 라는 조건 때문에 따로 저장한다. 
        Scanner input = new Scanner(System.in); 
        int bonus;
        while (true) {
            try {
                Exception e = new IllegalArgumentException();
                bonus = input.nextInt(); 
                if (bonus < 1 || bonus > 45) throw e;
                break;
            } catch (Exception e) {
                System.out.println("[Error] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        winNumbers[6] = bonus; 
    }

    public int[] howManyWins(int index) {      // 당첨 번호의 개수를 세는 메서드다. 
        int howMany; 
        int[] result = new int[index]; 
        int i = 0; 
        for (int[] list: randomNumbers) {
            howMany = 0; 
            for (int number: list) {
                for (int j = 0; j < 7; j++) {
                    if (winNumbers[j] == number) {
                        howMany++; 
                    }
                }
            }
            result[i++] = howMany; 
        }
        return result;
    }

    public String[] moneyEachPrize(int kindLotto) {      // 작은 로또, 중간 로또, 큰 로또에 따라 달라지는 당첨액을 표현하는 메서드다. 
        String[] money = new String[5];
        switch (kindLotto) {
            case 1: 
                money[0] = "2,000,000"; money[1] = "30,000"; money[2] = "1,500"; 
                money[3] = "500"; money[4] = "100"; 
                break;
            case 2: 
                money[0] = "50,000,000"; money[1] = "3,000,000"; money[2] = "150,000"; 
                money[3] = "50,000"; money[4] = "5,000"; 
                break;
            case 3:
                money[0] = "2,147,000,000"; money[1] = "850,000"; money[2] = "10,000"; 
                money[3] = "0"; money[4] = "0"; 
                break;
        }

        return money; 
    }

   
    public String toString(String[] moneyPrize, int[] result, Boolean[] hasBonus) {     // 당첨 결과를 출력하는 toString 메서드다. 왜 @override 메서드를 사용하지 않아도 될까?
        int first=0, second=0, third=0, fourth=0, fifth=0;
    
        for (int i = 0; i < result.length; i++) {
            if (result[i] == 3) first++; 
            if (result[i] == 4) second++;
            if (result[i] == 5) {
                if (hasBonus[i] == true) fourth++;  
                else third++; 
            }
            if (result[i] == 6) fifth++;
        }

        value = first * Integer.parseInt(moneyPrize[4].replace(",", ""))      // 수익률을 여기서 계산한다. 
        + second * Integer.parseInt(moneyPrize[3].replace(",", ""))
        + third * Integer.parseInt(moneyPrize[2].replace(",", ""))
        + fourth * Integer.parseInt(moneyPrize[1].replace(",", ""))
        + fifth * Integer.parseInt(moneyPrize[0].replace(",", ""));

        return "3개 일치 (" + moneyPrize[4] + "원) - " + Integer.toString(first) + "개\n"
        + "4개 일치 (" + moneyPrize[3] + "원) - " + Integer.toString(second) + "개\n"
        + "5개 일치 (" + moneyPrize[2] + "원) - " + Integer.toString(third) + "개\n"
        + "5개 일치, 보너스 볼 일치 (" + moneyPrize[1] + "원) - " + Integer.toString(fourth) + "개\n"
        + "6개 일치 (" + moneyPrize[0] + "원) - " + Integer.toString(fifth) + "개\n";
    }
    
    // 구현할 기능
    // 1. 숫자를 랜덤 생성할 때 중복된 수들이 없어야 함.  ==> 해결됨. (더욱 멋진 코드로 바꾸는 작업이 필요할 듯)
    // 2. 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다. => 해결됨. 
    // ** 가능한 예외 상황:
    //  - 로또 번호를 1~45 사이의 정수가 아닌 수를 입력 받았을 때. ==> 해결됨. 
    //  - 낸 돈이 1000으로 나누어 떨어지지 않을 때. ==> 해결됨. 
    //  - 입력된 당첨 번호의 개수가 1보다 작거나 6보다 클 때. ==> 해결됨. 
    //  - 로또 종류를 입력 받을 때 1, 2, 3 가 아닌 다른 수를 입력 받을 때. ==> 해결됨. 
    // 3. Java Enum을 적용한다. 
    //  - Enum 자료구조에 대한 공부가 더 필요할 듯... 어떻게 사용해야 하지. 어떤 기능에 적용해야 할까?


    public static void main(String[] args) {   // main 함수에서 static 을 없애도 되나? 이걸 없애야 main 밖에 있는 변수들을 가져다 쓸 수 있는디. 
        
        java.util.Scanner input = new Scanner(System.in);
        LottoApplication lottoApplication = new LottoApplication(); 

        System.out.println("구입할 로또 종류를 선택해주세요. (작은 로또: 1, 중간 로또: 2, 큰 로또: 3)");
        int kindLotto = lottoApplication.getKindOfLotto(); 

        System.out.println("구입금액을 입력해 주세요."); 
        int paid = lottoApplication.getPaid(); 

        System.out.println(Integer.toString(paid/1000) + "개를 구매했습니다.");
        lottoApplication.createRandomNumbers(paid);
        lottoApplication.showRandomNumbers(paid);

        System.out.println("당첨 번호를 입력해 주세요:");
        lottoApplication.getWinNumbers();

        System.out.println("보너스 번호를 입력해 주세요:");
        // winNumbers[6] = bonus;        // 이거 왜 안되는 거지?   
        lottoApplication.getBonusNumber(); 

        int[] result = lottoApplication.howManyWins(paid/1000).clone();
        Boolean[] hasBonus = lottoApplication.countBonus(paid/1000).clone(); 
        String[] moneyPrize = lottoApplication.moneyEachPrize(kindLotto).clone(); 

        System.out.println("당첨 통계\n---");
        System.out.println(lottoApplication.toString(moneyPrize, result, hasBonus)); 

        double percentage = value / paid * 100; 
        System.out.println("총 수익률은 " + String.format("%.1f", percentage) + "%입니다. ");
    }
}