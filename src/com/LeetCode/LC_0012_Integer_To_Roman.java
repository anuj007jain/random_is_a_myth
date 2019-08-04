package com.LeetCode;

public class LC_0012_Integer_To_Roman {

    public String intToRoman(int num) {

        StringBuilder str = new StringBuilder();
        while (num >= 1000) {
            str.append("M");
            num -= 1000;
        }
        if (num >= 900) {
            str.append("CM");
            num -= 900;
        }
        else if (num >= 500) {
            str.append("D");
            num -= 500;
        }
        else if (num >= 400) {
            str.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            str.append("C");
            num -= 100;
        }
        if (num >= 90) {
            str.append("XC");
            num -= 90;
        }
        else if (num >= 50) {
            str.append("L");
            num -= 50;
        }
        else if (num >= 40) {
            str.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            str.append("X");
            num -= 10;
        }
        if (num >= 9) {
            str.append("IX");
            num -= 9;
        }
        else if (num >= 5) {
            str.append("V");
            num -= 5;
        }
        else if (num == 4) {
            str.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            str.append("I");
            num -= 1;
        }
        return str.toString();
    }

}
