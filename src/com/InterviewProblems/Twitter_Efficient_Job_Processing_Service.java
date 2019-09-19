package com.InterviewProblems;

import java.util.Arrays;
import java.util.List;

public class Twitter_Efficient_Job_Processing_Service {

    public static int maximumTotalWeight(List<Integer> weights, List<Integer> tasks, int p) {
        int[][] dp = new int[tasks.size()+1][p+1];

        for (int i = 1 ; i < tasks.size() + 1 ; i++) {
            int weight = weights.get(i-1);
            int task = tasks.get(i-1);
            for (int j = 1 ; j < p + 1 ; j++) {
                dp[i][j] = Math.max(dp[i-1][j], (j >= task* 2 ? weight + dp[i-1][j-2*task] : 0));
            }
        }
        return dp[tasks.size()][p];
    }

    public static void main(String[] args) {
        Twitter_Efficient_Job_Processing_Service tejps = new Twitter_Efficient_Job_Processing_Service();
        System.out.println(tejps.maximumTotalWeight(Arrays.asList(2,4,4,5), Arrays.asList(2,2,3,4), 15));
        System.out.println(tejps.maximumTotalWeight(Arrays.asList(3,2,2), Arrays.asList(3,2,2), 9));
        System.out.println(tejps.maximumTotalWeight(Arrays.asList(1,4,6,3), Arrays.asList(1,2,2,3), 8));
        System.out.println(tejps.maximumTotalWeight(Arrays.asList(1,4,2,5,3), Arrays.asList(2,6,4,7,1), 13));
    }

}
