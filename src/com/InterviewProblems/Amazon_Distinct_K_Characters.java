package com.InterviewProblems;

import java.util.ArrayList;

public class Amazon_Distinct_K_Characters {

    private int findNumberOfSubtrings(String str, int k) {
        int number = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (str.substring(i, j).chars().distinct().count() == k) {
                    number++;
                }
            }
        }
        return number;

    }

    public static void main(String[] args) {
        System.out.println(new Amazon_Distinct_K_Characters().findNumberOfSubtrings("pqpqs", 2));
    }

}
