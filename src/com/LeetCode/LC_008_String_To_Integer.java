package com.LeetCode;

public class LC_008_String_To_Integer {

    public int myAtoi(String str) {
        int i = 0;
        boolean neg = false;
        while(i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if(i < str.length() && str.charAt(i) == '-') {
            neg = true;
            i++;
        }
        else if(i < str.length() && str.charAt(i) == '+') {
            i++;
        }
        int start = i;
        while(i < str.length() && (int)str.charAt(i) > 47 && (int)str.charAt(i) < 58) {
            i++;
        }
        if (start == i) {
            return 0;
        }
        int abs = 0;
        if (neg) {
            abs = Integer.MIN_VALUE;
        } else {
            abs = Integer.MAX_VALUE;
        }
        try{
            abs = Integer.parseInt(str.substring(start, i));
        } catch (NumberFormatException e) {
            return abs;
        }
        if(neg) {
            return -1*abs;
        }
        return abs;
    }

    public static void main(String[] args) {
        LC_008_String_To_Integer lc_008_sti = new LC_008_String_To_Integer();
        System.out.println(lc_008_sti.myAtoi("-91283472332"));

    }

}
