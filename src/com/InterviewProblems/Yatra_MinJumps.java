package com.InterviewProblems;

/**
 * Created by anuj.jain02 on 14/5/17.
 */

/**
 *  Given an array find the min number of jumps to get to the end of the array.
 *  Condition : Start from the first index and you can jump to the next index's value elements.
 */
public class Yatra_MinJumps {
     //                 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    static int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
    static int answer = 1;
    static boolean flag = false;

    public static void main(String[] args) {

        printMinJumps(0, arr[0]);

    }

    private static int printMinJumps(int currentIndex, int currentValue) {

        if(flag)
            return 0;

        if(currentIndex+currentValue >= arr.length){
            System.out.print("Min Jumps : "+answer);
            flag = true;
        }

        if(!flag) {
            answer++;
            int bestIndex = findBestIndex(currentIndex, currentValue);
            printMinJumps(bestIndex, arr[bestIndex]);
        }
        return 0;
    }

    private static int findBestIndex(int currentIndex, int currentValue) {

        System.out.println("Searching best Index between "+(currentIndex+1) +" and "+(currentIndex+currentValue));
        int bestIndex = currentIndex+1;
        int bestValue = Integer.MIN_VALUE;
        for(int i = currentIndex+1 ; i <= currentIndex+currentValue ; i++){
            if(arr[i] + i > bestValue){
                bestIndex = i;
                bestValue  = arr[i] + i;
            }
        }
        System.out.println("Best Index found: "+bestIndex);
        return bestIndex;
    }

}
