package com.InterviewProblems;

import java.util.Arrays;

public class KeepTruckin_Psychometric_Testing {

    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {

        int[] jobOffers = new int[lowerLimits.length];
        Arrays.sort(scores);
        for (int i = 0 ; i < lowerLimits.length ; i++) {
            jobOffers[i] = findJobOffers(scores, lowerLimits[i], upperLimits[i]);
        }
        return jobOffers;
    }

    static int findJobOffers(int[] scores, int lowerLimit, int upperLimit)
    {
        int count = upperLimitIndex(scores, upperLimit) -
                lowerLimitIndex(scores, lowerLimit) + 1;
        return count;
    }

    static int upperLimitIndex(int[] scores, int upperLimit)
    {
        int size = scores.length;
        int lo = 0, hi = size - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (scores[mid] <= upperLimit)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return hi;
    }

    static int lowerLimitIndex(int[] scores, int lowerLimit)
    {
        int size = scores.length;
        int lo = 0, hi = size - 1;
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (scores[mid] >= lowerLimit)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        KeepTruckin_Psychometric_Testing ktpt = new KeepTruckin_Psychometric_Testing();
        System.out.println(ktpt.jobOffers(new int[]{5, 6, 1, 8, 3}, new int[]{2}, new int[]{6}));
    }

}
