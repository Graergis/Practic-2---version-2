package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Calculator {

    public static StringBuffer EXAMPLE = new StringBuffer();
    public static StringBuffer BRACKET = new StringBuffer();
    public static double RESULT;

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        boolean bool2;
        while (true) {
            int cs = 0;
            int end = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.print(">");
            EXAMPLE.delete(0, EXAMPLE.length());
            BRACKET.delete(0, BRACKET.length());
            String line2 = scanner.nextLine();
            for (int i = 0; i < line2.length(); i++) {
                char c1 = line2.charAt(i);
                if (cs > end){
                    if (c1 == '('){
                        cs += 1;
                    }
                    if (c1 == ')') {
                        end += 1;
                        Rasschet rass = new Rasschet(BRACKET);
                    } else if (cs > end){
                        int j1 = i;
                        bool2 = true;
                        for (int j = j1; j < line2.length(); j++) {
                            char c2 = line2.charAt(j);
                            if (bool2){
                                if (c2 != ')'){
                                    sb.append(c2);
                                } else {
                                    end += 1;
                                    i = j;
                                    Rasschet rasschet = new Rasschet(sb);
                                    sb.delete(0, sb.length());
                                    sb.append(RESULT);
                                    BRACKET.delete(0, BRACKET.length());
                                    BRACKET.append(sb);
                                    bool2 = false;
                                }
                            }
                        }
                    }  else {
                        BRACKET.append(c1);
                    }
                    if (cs == end) {
                        EXAMPLE.append(BRACKET);
                        sb.delete(0, sb.length());
                    }
                } else if (c1 == '('){
                    cs += 1;
                } else  if (c1 != ' ') {
                    EXAMPLE.append(c1);
                }
            }
            Rasschet rass2 = new Rasschet(EXAMPLE);
            RESULT = new BigDecimal(RESULT).setScale(1, RoundingMode.HALF_UP).doubleValue();
            System.out.println("Результат = " + RESULT);
        }
    }
}