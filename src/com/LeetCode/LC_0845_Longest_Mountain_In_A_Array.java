package com.LeetCode;

public class LC_0845_Longest_Mountain_In_A_Array {

    public int longestMountain(int[] A) {
        boolean goingUp = false;
        int answer = 0, currentScore = 1;
        int i = 1;
        while(i < A.length && A[i] <= A[i-1]) {
            i++;
        }
        for (; i < A.length ; i++) {
            if(i == 870) {
                int x = 7;
            }
            if (A[i] > A[i-1]) {
                if (goingUp) {
                    currentScore++;
                } else {
                    goingUp = true;
                    if (currentScore >= 3 && answer < currentScore) {
                        answer = currentScore;
                    }
                    currentScore = 2;
                }
            } else if (A[i] < A[i-1]){
                if (!goingUp) {
                    currentScore++;
                } else {
                    goingUp = false;
                    currentScore++;
                }
            } else {
                if (currentScore >= 3 && answer < currentScore) {
                    answer = currentScore;
                }
                i++;
                while(i < A.length && A[i] <= A[i-1]) {
                    i++;
                }
                goingUp = true;
                currentScore = 2;
            }
        } if (currentScore > answer && currentScore >=3 && !goingUp) {
            return currentScore;
        }
        return answer;
    }

    public static void main(String[] args) {
        LC_0845_Longest_Mountain_In_A_Array lc_0845_lmiaa = new LC_0845_Longest_Mountain_In_A_Array();
        System.out.println(lc_0845_lmiaa.longestMountain(new int[]{2,1,3,1,0,1,3,1,0,1,2,0,0,0,2,1,0,3,0,3,1,0,3,2,1,1,1,0,2,0,0,1,0,2,2,0,3,1,2,2,0,3,2,2,3,3,3,1,3,0,0,2,3,0,0,1,0,1,2,3,1,0,1,0,0,3,0,3,2,0,2,1,1,2,0,0,2,3,1,1,1,3,1,0,1,3,2,0,0,3,0,2,0,3,2,2,0,0,3,0,3,1,0,0,2,2,1,2,1,1,3,0,1,1,3,1,2,0,3,1,1,0,2,2,2,0,2,2,2,0,0,0,0,0,1,0,1,2,2,1,3,3,0,0,3,0,1,0,0,2,2,2,1,0,3,0,2,3,1,0,1,0,0,2,3,2,3,0,2,0,0,1,2,3,1,3,3,3,2,2,3,2,0,0,0,2,2,1,0,3,0,1,3,1,0,2,3,3,3,0,2,3,3,3,3,3,3,1,2,3,1,2,2,2,2,3,3,2,0,0,1,2,1,3,2,1,2,2,2,0,0,3,2,2,2,3,1,0,1,3,0,2,3,2,3,1,3,1,1,1,1,3,1,1,1,1,3,0,0,0,1,3,2,0,3,1,3,2,2,0,0,3,3,1,0,1,3,1,2,2,1,2,1,2,1,3,0,1,1,1,0,0,0,1,2,0,2,2,1,2,2,2,2,1,2,3,3,3,3,1,2,1,1,0,0,0,0,1,1,2,3,1,0,3,0,3,0,3,3,2,2,3,0,3,2,2,3,0,3,0,3,3,0,2,0,3,0,2,0,3,2,0,2,1,0,1,1,1,1,2,2,3,0,1,1,2,0,0,1,2,3,2,2,2,3,0,1,3,3,0,3,3,3,0,1,3,0,3,0,3,2,0,2,2,0,1,0,0,3,1,1,2,0,0,3,1,3,2,0,0,0,3,1,0,1,1,1,0,0,3,2,2,3,0,3,0,3,2,1,1,2,0,3,3,0,0,2,2,3,0,1,2,0,2,0,0,0,1,3,1,2,2,1,1,3,0,2,0,3,3,3,2,3,3,2,0,2,1,2,3,2,1,0,2,2,2,2,0,3,0,2,3,3,2,2,0,3,0,2,1,1,3,2,0,3,0,1,3,1,1,2,3,1,1,1,3,3,3,0,3,2,1,2,0,0,0,0,2,0,3,0,2,0,3,0,3,0,3,0,3,1,3,3,2,1,0,2,3,1,0,3,2,0,1,1,0,2,2,1,1,3,2,2,2,2,1,1,2,0,2,2,2,0,0,2,0,1,1,0,0,1,3,1,1,3,3,1,1,2,0,1,2,2,1,3,3,2,3,1,0,1,0,2,3,1,3,2,1,3,2,1,0,0,0,3,3,1,0,0,2,0,1,2,2,2,3,2,0,3,0,0,2,3,0,1,2,0,2,3,0,3,1,0,1,0,1,1,3,2,3,0,2,3,1,2,0,0,3,2,1,0,0,1,3,0,2,1,2,3,2,2,3,3,1,3,1,0,0,1,0,2,1,3,1,0,3,0,3,2,3,2,1,1,2,1,2,3,2,1,0,1,1,1,3,2,1,1,3,1,0,3,1,2,2,3,3,3,3,3,1,3,3,2,0,3,2,3,1,1,3,0,3,0,0,2,1,3,2,2,1,0,1,3,1,3,0,3,3,3,2,2,0,2,1,0,2,3,3,2,3,0,2,1,1,2,2,3,0,3,2,3,1,1,1,1,3,3,2,1,2,3,2,1,2,0,0,0,1,0,1,2,2,2,3,0,1,0,3,0,2,3,0,3,1,1,0,3,1,2,2,0,1,0,1,2,0,2,3,0,1,1,0,1,0,2,0,2,2,3,0,0,0,2,2,3,1,2,2,3,1,3,2,3,3,0,2,2,3,2,3,0,1,1,1,0,3,3,2,2,0,2,0,2,2,2,1,2,2,0,0,1,2,0,2,0,1,0,1,1,3,0,3,2,2,2,1,1,0,1,2,3,2,1,0,1,2,1,1,3,0,1,2,2,1,3,2,2,1,3,3,0,0,3,0,3,1,0,3,2,1,3,3,0,0,3,2,0,1,0,2,0,1,2,3,0,3,2,2,0,2,0,1,0,2,1,2,0,3,2,0,3,1,0,0,0,0,1,3,0,2,0,1,2,3,3,1,2,3,1,1,3,0,3,3,3,1,0,0,1,1,1,3,3,0,3,0,1,2,0,0,1,1,0,3,2,0,0,0,1,0,1,1,0,1,2,3,1,3,3,3}));
    }
}
