package com.InterviewProblems;

import java.util.Scanner;

/**
 * Created by anuj on 25/5/16.
 */
public class Circle_BankBazaar {

    private int[] findSolution(int n, int d, int[] radius, int[] cost){
        int[] solution = new int[radius.length];
        int minCost = Integer.MAX_VALUE;
        int minPos = 0;
        for(int i=0; i<radius.length;i++ ){
            minCost = Integer.MAX_VALUE;
            minPos = 0;
            for(int j=i;j<radius.length;j++){
                if(radius[i]+radius[j]>=d){
                    if(solution[j]!=0){
                        if(cost[solution[j]]>cost[i]){
                            solution[j]=i+1;
                        }
                    }
                    solution[j]=i+1;
                    if(cost[i]+cost[j]<=minCost){
                        if(cost[i]+cost[j] == minCost){
                            if(radius[j]>radius[minPos]){
                                solution[i]= j+1;
                                minCost=cost[i]+cost[j];
                            }
                        }
                        else{
                            solution[i]=j+1;
                            minCost=cost[i]+cost[j];
                        }
                    }
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {

        Circle_BankBazaar cb = new Circle_BankBazaar();
        int n = 5;
        int d = 8;
        int[] radius =  {1,3,6,2,5};
        int[] cost =    {3,8,6,2,4};
        //solution = {0,5,4,3,5}
        int[] solution = cb.findSolution(n,d,radius,cost);
        for(int i =0;i<solution.length;i++)
            System.out.print(solution[i]+" ");
    }
}
