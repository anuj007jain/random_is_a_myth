package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC_0017_Letter_Combinations_Of_A_Phone_Number {

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return new ArrayList<>();
        }
        List<String> sol = new ArrayList<>();
        dial(new StringBuilder(), 0, digits, sol);
        return sol;
    }

    public void letterCombinationsUtil(StringBuilder str, int i, String digits, List<String> sol) {
        if(i == digits.length()) {
            sol.add(str.toString());
            return;
        }
        dial(str, i, digits, sol);
    }

    public void dial(StringBuilder str, int i, String digits, List<String> sol) {
        switch(digits.charAt(i))
        {
            case '2':
                letterCombinationsUtil(new StringBuilder(str).append("a"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("b"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("c"), i+1, digits, sol);
                break;
            case '3':
                letterCombinationsUtil(new StringBuilder(str).append("d"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("e"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("f"), i+1, digits, sol);
                break;
            case '4':
                letterCombinationsUtil(new StringBuilder(str).append("g"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("h"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("i"), i+1, digits, sol);
                break;
            case '5':
                letterCombinationsUtil(new StringBuilder(str).append("j"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("k"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("l"), i+1, digits, sol);
                break;
            case '6':
                letterCombinationsUtil(new StringBuilder(str).append("m"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("n"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("o"), i+1, digits, sol);
                break;
            case '7':
                letterCombinationsUtil(new StringBuilder(str).append("p"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("q"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("r"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("s"), i+1, digits, sol);
                break;
            case '8':
                letterCombinationsUtil(new StringBuilder(str).append("t"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("u"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("v"), i+1, digits, sol);
                break;
            case '9':
                letterCombinationsUtil(new StringBuilder(str).append("w"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("x"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("y"), i+1, digits, sol);
                letterCombinationsUtil(new StringBuilder(str).append("z"), i+1, digits, sol);
                break;
        }
    }

    public static void main(String[] args) {
        LC_0017_Letter_Combinations_Of_A_Phone_Number lc_017_lcoaph = new LC_0017_Letter_Combinations_Of_A_Phone_Number();
        System.out.println(lc_017_lcoaph.letterCombinations("23"));
    }

}
