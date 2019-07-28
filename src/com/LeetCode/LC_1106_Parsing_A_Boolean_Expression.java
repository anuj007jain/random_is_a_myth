package com.LeetCode;

import java.util.Stack;

public class LC_1106_Parsing_A_Boolean_Expression {

    public static void main(String[] args) {
        LC_1106_Parsing_A_Boolean_Expression lc_1106_pabe = new LC_1106_Parsing_A_Boolean_Expression();
        System.out.println(lc_1106_pabe.parseBoolExpr("!(f)"));
        System.out.println(lc_1106_pabe.parseBoolExpr("|(f,t)"));
        System.out.println(lc_1106_pabe.parseBoolExpr("&(f,t)"));
        System.out.println(lc_1106_pabe.parseBoolExpr("|(&(t,f,t),!(t))"));
    }

    public boolean parseBoolExpr(String expression) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == '(') {
                stack.push(i++);
                continue;
            }
            if (expression.charAt(i) == ')') {
                int start = stack.pop() - 1;
                expression = evaluate (expression, start, i);
                i = start+1;
                continue;
            }
            i++;
        }
        if(expression.charAt(0) == 't') {
            return true;
        }
        return false;
    }

    private String evaluate(String expression, int start, int end) {
        if (expression.charAt(start) == '!') {
            if (expression.charAt(start+2) == 't') {
                if (end == expression.length() - 1) {
                    return expression.substring(0, start) + "f";
                }
                return expression.substring(0, start) + "f" + expression.substring(end+1);
            } else {
                if (end == expression.length() - 1) {
                    return expression.substring(0, start) + "t";
                }
                return expression.substring(0, start) + "t" + expression.substring(end+1);
            }
        }
        if (expression.charAt(start) == '&') {
            if (expression.substring(start, end).contains("f")) {
                if (end == expression.length() - 1) {
                    return expression.substring(0, start) + "f";
                }
                return expression.substring(0, start) + "f" + expression.substring(end+1);
            } else {
                if (end == expression.length() - 1) {
                    return expression.substring(0, start) + "t";
                }
                return expression.substring(0, start) + "t" + expression.substring(end+1);
            }
        } if (expression.charAt(start) == '|') {
            if (expression.substring(start, end).contains("t")) {
                if (end == expression.length() - 1) {
                    return expression.substring(0, start) + "t";
                }
                return expression.substring(0, start) + "t" + expression.substring(end+1);
            } else {
                if (end == expression.length() - 1) {
                    return expression.substring(0, start) + "f";
                }
                return expression.substring(0, start) + "f" + expression.substring(end+1);
            }
        }
        return null;
    }

}
