package com.InterviewProblems;

import java.util.Arrays;
import java.util.List;

public class Twitter_New_Office_Design {

    // assuming sorted order
    public static int maxHeight(List<Integer> tablePositions, List<Integer> tableHeights) {
        int maxHeight = 0;

        for (int i = 0 ; i < tablePositions.size() - 1 ; i++) {
            int height = findMaxHeightBetweenTwoTables(tablePositions.get(i), tableHeights.get(i),
                    tablePositions.get(i+1), tableHeights.get(i+1));
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        return maxHeight;
    }

    private static int findMaxHeightBetweenTwoTables(int currentTablePosition, int currentTableHeight,
                                                     int nextTablePosition, int nextTableHeight) {
        if (nextTablePosition == currentTablePosition + 1) {
            return 0;
        }
        int space = nextTablePosition - currentTablePosition - 1;
        int heightDiff = Math.abs(nextTableHeight - currentTableHeight);
        if (space <= heightDiff) {
            return Math.min(nextTableHeight, currentTableHeight) + space;
        }
        return Math.max(nextTableHeight, currentTableHeight) + (space - heightDiff + 1) / 2;
    }

    public static void main(String[] args) {
        Twitter_New_Office_Design tnod = new Twitter_New_Office_Design();
        System.out.println(tnod.maxHeight(Arrays.asList(1,2,4,7), Arrays.asList(4,5,7,11)));
        System.out.println(tnod.maxHeight(Arrays.asList(1,3,7), Arrays.asList(4,3,3)));
        System.out.println(tnod.maxHeight(Arrays.asList(1,10), Arrays.asList(1,5)));
    }

}
