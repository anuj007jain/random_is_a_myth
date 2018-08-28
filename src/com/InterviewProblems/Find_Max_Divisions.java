package com.InterviewProblems;

/**
 * Created by anuj.jain02 on 6/6/16.
 */
public class Find_Max_Divisions {

    int[] solution = new int[10];

    private int findMax(int n, int sum){

        if(n > (n/2+n/3+n/4+n/5))
            sum+=n;
        else {
            findMax(n/2, sum);
            findMax(n/3, sum);
            findMax(n/4, sum);
            findMax(n/5, sum);
        }
        return sum;
    }

    public static void main(String[] args) {

        Find_Max_Divisions fmd = new Find_Max_Divisions();
        int n = 20;
        fmd.findMax(n,0);




    }

}
