package com.InterviewProblems;

/**
 * Created by anuj on 4/5/16.
 */
public class Incomplete_Well_Stones_Problem {

    private int findMin(int a, int b){
        return (a<b)?a:b;
    }


    private void findMaxStoneCount(int[] well, int[] stones) {
        int first = well[0];
        int count = 0;
        int min = Integer.MAX_VALUE;
        int lastPos = 0;
        for (int i = 0; i < well.length; i++)
            if (well[i] < min) {
                min = well[i];
                lastPos = i;
            }
        for (int i = 0; i < stones.length; i++) {

            if (stones[i] > first)
                continue;
            else {
                while (stones[i] > min) {
                    lastPos--;
                    min = well[lastPos];
                    if (lastPos == 0)
                        break;
                }
                if(stones[i] <= min){
                    lastPos--;
                    min = well[lastPos];
                    count++;

                }


            }
        }
        System.out.print(count);
    }
    public static void main(String[] args) {

        Incomplete_Well_Stones_Problem wsp = new Incomplete_Well_Stones_Problem();
        int[] well = {6,2,7,3,1,4,2};
        int[] stones = {9,4,3,2,1,7,8};
        wsp.findMaxStoneCount(well,stones);
    }
}
