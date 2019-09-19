package com.InterviewProblems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KeepTrucking_Good_Segment {

    public static int goodSegment(List<Integer> badNumbers, int l, int r) {
        // Write your code here
        int prevBadNumber = l;
        int bestRange = 0;
        Collections.sort(badNumbers);
        for (int i = 0 ; i < badNumbers.size() ; i++) {
            int badNumber = badNumbers.get(i);
            if (badNumber < l) {
                continue;
            }
            if (badNumber == l) {
                prevBadNumber = l+1;
                continue;
            }
            if (badNumber > r) {
                int range = r - prevBadNumber;
                if (bestRange < range) {
                    bestRange = range;
                }
                return bestRange;
            }
            int range = (badNumber - 1) - prevBadNumber;
            if (bestRange < range) {
                bestRange = range;
            }
            prevBadNumber = badNumber;
        }
        if (prevBadNumber < r) {
            int range = r - prevBadNumber;
            if (bestRange < range) {
                bestRange = range;
            }
        }
        return bestRange;
    }

    public static void main(String[] args) {
        KeepTrucking_Good_Segment ktgs = new KeepTrucking_Good_Segment();
        System.out.println(ktgs.goodSegment(Arrays.asList(5,4,2,15), 1, 10));
    }

}
