package com.InterviewProblems;

import java.util.Arrays;

public class Google_Q2 {

    public int[] solution(int[] stores, int[] houses) {
        int[] solution = new int[houses.length];
        for(int i = 0 ; i < houses.length ; i++) {
            int minimumDistanceYet;
            int closestStoreYet = 0; // given m,n >= 1
            try {
                minimumDistanceYet = Math.abs(stores[closestStoreYet] - houses[i]); // still checking :P
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Wrong input");
                return null;
            }
            for (int j = 1 ; j < stores.length ; j++) {
                if(Math.abs(houses[i] - stores[j]) < minimumDistanceYet) {
                    minimumDistanceYet = Math.abs(houses[i] - stores[j]);
                    closestStoreYet = j;
                } else if(Math.abs(houses[i] - stores[j]) == minimumDistanceYet && stores[j] < stores[closestStoreYet]) {
                    closestStoreYet = j;
                }
            }
            solution[i] = stores[closestStoreYet];
        }
        return solution;
    }

    public static void main(String[] args) {
        Google_Q2 gq2 = new Google_Q2();
        System.out.println(Arrays.toString(gq2.solution(new int[]{}, new int[]{2,23,1,4,5555,1233,132123,1,3,1,44})));

    }

}
