package com.LeetCode;

public class LC_907_Reverse_Only_Letters {

    public String reverseOnlyLetters(String S) {

        StringBuilder str = new StringBuilder(S);
        int i = 0, j = S.length() - 1;
        while (i<j) {
            boolean flag = true;
            if(Integer.valueOf(S.charAt(i)) < 65 || (Integer.valueOf(S.charAt(i)) > 90 && Integer.valueOf(S.charAt(i)) < 97)
                    || Integer.valueOf(S.charAt(i)) > 122) {
                i++;
                flag = false;
            }
            if(Integer.valueOf(S.charAt(j)) < 65 || (Integer.valueOf(S.charAt(j)) > 90 && Integer.valueOf(S.charAt(j)) < 97)
                    || Integer.valueOf(S.charAt(j)) > 122) {
                j--;
                flag = false;
            }
            if(flag) {
                swap(str, i++, j--);
                continue;
            }
        }

        return str.toString();
    }

    private void swap(StringBuilder str, int i, int j) {
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);
    }

    public static void main(String[] args) {
        String s = "Czyr^";
        System.out.println(new LC_907_Reverse_Only_Letters().reverseOnlyLetters(s));
    }

}
