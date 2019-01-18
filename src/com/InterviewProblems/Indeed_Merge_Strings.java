package com.InterviewProblems;

public class Indeed_Merge_Strings {

    static String mergeStrings(String a, String b) {

        StringBuilder str = new StringBuilder();

        int x = a.length();
        int y = b.length();

        int min = x < y ? x : y;

        for(int i = 0 ; i < min ; i++) {
            str.append(a.charAt(i));
            str.append(b.charAt(i));
        }

        for(int i = min ; i < x ; i++) {
            str.append(a.charAt(i));
        }

        for(int i = min ; i < y ; i++) {
            str.append(b.charAt(i));
        }

        return str.toString();

    }

    public static void main(String[] args) {

        Indeed_Merge_Strings ims = new Indeed_Merge_Strings();
        System.out.println(ims.mergeStrings("abc","stuvwx"));
    }
}
