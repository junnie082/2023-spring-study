package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        LocalDate localDate = LocalDate.of(1999, 4, 4);
        LocalDate localDate1 = LocalDate.now().minusYears(localDate.getYear());
        System.out.println("localDate1.getYear() = " + localDate1.getYear());
    }
}