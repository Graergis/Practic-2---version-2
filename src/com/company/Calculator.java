package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {

    static StringBuffer EXAMPLE = new StringBuffer();
    static StringBuffer BRACKET = new StringBuffer();
    static double RESULT;

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            EXAMPLE.delete(0, EXAMPLE.length());
            BRACKET.delete(0, BRACKET.length());
            String line2 = scanner.nextLine();
            Section section = new Section(line2);
            Rasschet rasschet = new Rasschet(EXAMPLE);
            RESULT = new BigDecimal(RESULT).setScale(1, RoundingMode.HALF_UP).doubleValue();
            System.out.println("Результат = " + RESULT);
        }
    }
}