package com.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC_0837_New_21_Game {

    public double new21Game(int N, int K, int W) {
        double n = N;
        double k = K;
        double w = W;
        double totalProb = 0;
        Map<Double, Double> scoreToProb = new HashMap<>();
        if (K == 1) {
            return n/w;
        }
        for (double i = k-1 ; i > 0 ; i--) {
            double prob = 0;
            for (double j = i ; j < Math.min(k-1,i+10) ; j++) {
                prob += scoreToProb.get(i+k-1-j)/w;
            }
            prob += (Math.min(i+w,n)-k+1)/w > 0 ? (Math.min(i+w,n)-k+1)/w : 0;
            totalProb += prob;
            scoreToProb.put(i, prob);
        }
        return totalProb;
    }

    public static void main(String[] args) {
        LC_0837_New_21_Game lc_0837_n21g = new LC_0837_New_21_Game();
        System.out.println(lc_0837_n21g.new21Game(10,1,10));
        System.out.println(lc_0837_n21g.new21Game(6,1,10));
        System.out.println(lc_0837_n21g.new21Game(21,17,10));
    }

}
