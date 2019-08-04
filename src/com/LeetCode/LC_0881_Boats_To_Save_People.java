package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_0881_Boats_To_Save_People {

    public static void main(String[] args) {
        LC_0881_Boats_To_Save_People lc_881_btsp = new LC_0881_Boats_To_Save_People();
        System.out.println(lc_881_btsp.numRescueBoats(new int[]{1,2}, 3));
        System.out.println(lc_881_btsp.numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println(lc_881_btsp.numRescueBoats(new int[]{3,5,3,4}, 5));
        System.out.println(lc_881_btsp.numRescueBoats(new int[]{3,2,3,2,2}, 6));
        //System.out.println(lc_881_btsp.numRescueBoatsDP(new int[]{3,2,3,2,2}, 6));
    }

    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        int i = 0, j = people.length-1;
        Arrays.sort(people);
        while(i<j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
                count++;
                continue;
            }
            j--;
            count++;
        }
        if (i==j) {
            count++;
        }

        return count;
    }

    public int numRescueBoatsDP(int[] people, int limit) {
        int count = 0;
        while(people.length > 0) {
            List<Integer> internalSolution = knapsack01(people, limit);
            int[] temp = new int[people.length - internalSolution.size()];
            int k = 0;
            for (int i = 0; i < people.length; i++) {
                if (internalSolution.contains(people[i])) {
                    internalSolution.remove(new Integer(people[i]));
                    continue;
                }
                temp[k++] = people[i];
            }
            people = temp;
            count++;
        }
        return count;
    }

    List<Integer> knapsack01(int[] people, int limit) {

        int[][] dp = new int[people.length][limit+1];

        //base cases
        for (int i = 0 ; i < people.length ; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1 ; j <= limit ; j++) {
            if (people[0] > j) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = people[0];
            }
        }

        for (int i = 1 ; i < people.length ; i++) {
            for (int j = 1 ; j <= limit ; j++) {
                int option1 = dp[i-1][j];
                int option2 = 0;
                if (j >= people[i]) {
                    option2 = people[i];
                }
                if (j > people[i]) {
                    option2 += dp[i-1][j-people[i]];
                }
                if (option1 > option2) {
                    dp[i][j] = option1;
                } else {
                    dp[i][j] = option2;
                }
            }
        }

        List<Integer> internalSolution = new ArrayList<>();
        int i = people.length - 1;
        int j = limit;
        while(i >= 0) {
            if (i == 0) {
                if (dp[i][j] == people[i]) {
                    internalSolution.add(people[i]);
                }
                break;
            }
            if (dp[i][j] == dp[i-1][j]) {
                i--;
            } else {
                internalSolution.add(people[i]);
                j = j-people[i];
                i--;
            }
        }

        return internalSolution;
    }

}
