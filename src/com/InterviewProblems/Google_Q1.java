package com.InterviewProblems;

import java.util.*;

public class Google_Q1 {

    public int solution(int[] A) {
        Map<Integer,Integer> minValuesWithCount = new HashMap<>();
        int solution = 0;
        for(int i = 0 ; i < A.length ; i++) {
            int curr = A[i];
            int bestMinimum = Integer.MAX_VALUE;
            for(Integer min: minValuesWithCount.keySet()){
                if(min > curr) {
                    if(min < bestMinimum) {
                        bestMinimum = min;
                    }
                }
            }
            if(bestMinimum == Integer.MAX_VALUE) {
                if(minValuesWithCount.get(curr) == null) {
                    minValuesWithCount.put(curr, 1);
                } else {
                    minValuesWithCount.put(curr, minValuesWithCount.get(curr)+1);
                }
                solution++;
            } else {
                if(minValuesWithCount.get(bestMinimum) == 1){
                    minValuesWithCount.remove(bestMinimum);
                    if(minValuesWithCount.get(curr) == null) {
                        minValuesWithCount.put(curr, 1);
                    } else {
                        minValuesWithCount.put(curr, minValuesWithCount.get(curr)+1);
                    }
                } else {
                    minValuesWithCount.put(bestMinimum, minValuesWithCount.get(bestMinimum) - 1);
                    if(minValuesWithCount.get(curr) == null) {
                        minValuesWithCount.put(curr, 1);
                    } else {
                        minValuesWithCount.put(curr, minValuesWithCount.get(curr)+1);
                    }
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        Google_Q1 gq1 = new Google_Q1();
        System.out.println(gq1.solution(new int[]{3,2,2,1,1}));
    }

}
