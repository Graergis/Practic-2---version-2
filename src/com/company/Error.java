package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Error {

    public Error(String str1) {
        int start = 0;
        Pattern patt = Pattern.compile("[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?\\s*[0-9]");
        Matcher match = patt.matcher(str1);
        while (match.find(start)) { //Проверка на пробелы между цифрами
            try {
                String value2 = str1.substring(match.start(), match.end());
                Double.parseDouble(value2);
                start = match.end();
            } catch (NumberFormatException e) {
                System.out.println("Неверное выражение!");
                System.exit(0);
            }
        }
        for (int i = 1; i < str1.length(); i++) { //проверка на наличие букв
            char c = str1.charAt(i);
            if (Character.isLetter(c)){
                System.out.println("Неверное выражение!");
                System.exit(0);
            }
        }
    }
}
