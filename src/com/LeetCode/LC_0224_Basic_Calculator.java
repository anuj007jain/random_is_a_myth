package com.LeetCode;

public class LC_0224_Basic_Calculator {

    public int calculate(String s) {
        s = s.replaceAll(" ","");
        s = s.replaceAll("\\+","p");
        s = s.replaceAll("-","m");
        StringBuilder str = new StringBuilder(s);
        str.insert(0, "(");
        str.append(")");
        while (true) {
            int i = 1;
            int lastOpenPIndex = 0;
            while (i < str.length()) {
                if (str.charAt(i) == '(') {
                    lastOpenPIndex = i;
                } else if (str.charAt(i) == ')') {
                    calculateUtils(str, lastOpenPIndex, i);
                    if(str.charAt(str.length()-1) != ')') {
                        return Integer.parseInt(str.toString());
                    }
                    break;
                }
                i++;
            }
        }
    }

    private void calculateUtils(StringBuilder str, int openPIndex, int closedPIndex) {
        StringBuilder number = new StringBuilder();
        int i = openPIndex + 1;
        while (str.charAt(i) != 'p' && str.charAt(i) != 'm' && i < closedPIndex){
            number.append(str.charAt(i));
            i++;
        }
        int sum = Integer.parseInt(number.toString());
        boolean op = true;
        number = new StringBuilder();
        while (i < closedPIndex) {
            if(str.charAt(i) == 'p') {
                op = true;
                i++;
            } else if (str.charAt(i) == 'm') {
                op = false;
                i++;
            } else {
                while (str.charAt(i) != 'p' && str.charAt(i) != 'm' && i < closedPIndex){
                    number.append(str.charAt(i));
                    i++;
                }
                if (op) {
                    sum += Integer.parseInt(number.toString());
                    number = new StringBuilder();
                } else {
                    sum -= Integer.parseInt(number.toString());
                    number = new StringBuilder();
                }
            }
        }
        str.replace(openPIndex, closedPIndex+1, String.valueOf(sum));
    }

    public static void main(String[] args) {
        LC_0224_Basic_Calculator lc_224_bc = new LC_0224_Basic_Calculator();
        System.out.println(lc_224_bc.calculate("(5-(1+(5)))"));
    }

}