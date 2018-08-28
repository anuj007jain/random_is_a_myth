package com.InterviewProblems;

/**
 * Created by anuj on 7/5/16.
 */
public class Wiffle_Base_SoftBall {

    public void calculateAnswer(int[] array){ // O(N)

        int min = Integer.MAX_VALUE;
        String ans = "WSB";     //max answer depending on the alphabetical order
        int[] W = {array[0],array[1],array[2]}; //size = N/3
        int[] B = {array[3],array[4],array[5]}; //size = N/3
        int[] S = {array[6],array[7],array[8]}; //size = N/3

        //considering 6 test cases here
        for(int i = 0;i<W.length ; i++){
            for(int j=0;j<B.length;j++){
                if(i==j)
                    continue;   //since i and j have to be unique
                for(int k=0;k<S.length;k++){
                    if(i==k || j==k)    //since i,j k have to be unique
                        continue;
                    int sum = W[(i+1)%3] + W[(i+2)%3] + B[(j+1)%3] + B[(j+2)%3] + S[(k+1)%3] + S[(k+2)%3];
                    if(sum<=min){
                        if(sum == min){     //to get the first correct answer depending on the alphabetical order
                            String temp = findAns(i,j,k);
                            if(temp.compareTo(ans)<0)
                                ans = temp;
                        }
                        else {
                            min = sum;      //update the correct answer
                            ans = findAns(i, j, k);
                        }
                    }
                }
            }
        }
        System.out.println(ans+" "+min);
    }
    private String findAns(int i,int j,int k){
        if(i == 0 && j == 1 && k == 2)
            return "WBS";
        if(i == 0 && j == 2 && k == 1)
            return "WSB";
        if(i == 1 && j == 0 && k == 2)
            return "BWS";
        if(i == 1 && j == 2 && k == 0)
            return "BSW";
        if(i == 2 && j == 0 && k == 1)
            return "SWB";
        if(i == 2 && j == 1 && k == 0)
            return "SBW";
        return "";
    }

    public static void main(String[] args) {
        Wiffle_Base_SoftBall wbs = new Wiffle_Base_SoftBall();
        int[] array1 = {15,8,31,30,12,8,10,15,20};      //input 1
        int[] array2 = {10,20,30,20,40,60,30,60,90};    //input 2
        int[] array3 = {10,10,10,0,0,0,0,0,0};          //input 3
        wbs.calculateAnswer(array1);                    //output 1
        wbs.calculateAnswer(array2);                    //output 2
        wbs.calculateAnswer(array3);                    //output 3


    }

}
