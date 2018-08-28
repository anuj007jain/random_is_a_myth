package com.InterviewProblems;

/**
 * Created by anuj on 7/5/16.
 */
public class Cycles_Of_Sequence {

    private void maximumCycleLength(int a, int b){

        int maxCount =0;
        for(int i = a; i<=b ; i++){
            int count =1;
            int x = i;
            while(x!=1){
                count++;
                if(x%2==0)
                    x/=2;
                else
                    x=3*x+1;
            }
            if(count>maxCount)
                maxCount=count;
        }
    System.out.print(maxCount);
    }

    public static void main(String[] args) {

        Cycles_Of_Sequence cos = new Cycles_Of_Sequence();
        int a = 1;      //input interger 1
        int b = 10;     //input integer 2
        cos.maximumCycleLength(a,b);

    }

}
