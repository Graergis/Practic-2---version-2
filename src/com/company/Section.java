package com.company;

public class Section {

    public Section(String line2) {
        StringBuffer sb = new StringBuffer();
        boolean bool2;
        int start = 0;
        int end = 0;
        for (int i = 0; i < line2.length(); i++) {
            char c1 = line2.charAt(i);
            if (start > end){
                if (c1 == '('){
                    start += 1;
                }
                if (c1 == ')') {
                    end += 1;
                    Rasschet rassch = new Rasschet(Calculator.BRACKET);
                } else if (start > end){
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
                                sb.append(Calculator.RESULT);
                                Calculator.BRACKET.delete(0, Calculator.BRACKET.length());
                                Calculator.BRACKET.append(sb);
                                bool2 = false;
                            }
                        }
                    }
                }  else {
                    Calculator.BRACKET.append(c1);
                }
                if (start == end) {
                    Calculator.EXAMPLE.append(Calculator.BRACKET);
                    sb.delete(0, sb.length());
                }
            } else if (c1 == '('){
                start += 1;
            } else {
                Calculator.EXAMPLE.append(c1);
            }
        }
    }
}
