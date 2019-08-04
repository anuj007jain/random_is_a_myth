package com.LeetCode;

import java.util.Stack;

public class LC_0151_Reverse_Words_In_A_String {

    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == ' ' && !stack.isEmpty()) {
                while(!stack.isEmpty()) {
                    str.insert(0,stack.pop());
                }
                str.insert(0," ");
            } else if (s.charAt(i) != ' ') {
                stack.push(s.charAt(i));
            }
        }
        while(!stack.isEmpty()) {
            str.insert(0,stack.pop());
        }
        return str.toString().trim();
    }

}
