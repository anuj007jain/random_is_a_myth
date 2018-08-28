package com.InterviewProblems;

import java.util.Arrays;

/**
 * Created by anuj.jain02 on 13/5/17.
 */
public class Yatra_Anagram_Difference {

    public static void main(String[] args) {
        String[] a = new String[5];
        String[] b = new String[5];

        int[] results = new int[a.length];
        a[0] = "a";
        a[1] = "jk";
        a[2] = "abb";
        a[3] = "mn";
        a[4] = "abc";
        b[0] = "bb";
        b[1] = "kj";
        b[2] = "bbc";
        b[3] = "op";
        b[4] = "def";

        for(int i = 0 ; i < a.length ; i++){
            int count = 0;
            if(a[i].length() != b[i].length()){
                results[i] = -1;
                continue;
            }
            for(int j = 0 ; j < a[i].length() ; j++){
                if(b[i].indexOf(a[i].charAt(j)) >= 0){
                    b[i] = b[i].substring(0,b[i].indexOf(a[i].charAt(j))) + b[i].substring(b[i].indexOf(a[i].charAt(j))+1);
                }
                else{
                    count++;
                }
            }
            results[i] = count;
        }
        System.out.println(Arrays.toString(results));


    }
}
