package com.InterviewProblems;

/**
 * Created by anuj on 3/5/16.
 */
public class Tower_Of_Hanoi_1_Aux {

    private void Hanoi(int n ,String source, String dest, String via){
        if(n==1)
            System.out.println(source+" -> "+dest);
        else{
            Hanoi(n-1,source,via,dest);
            System.out.println                                                                                                                                                                                                                              (source+" -> "+dest);
            Hanoi(n-1,via,dest,source);
        }
    }

    public static void main(String[] args) {
        Tower_Of_Hanoi_1_Aux toh = new Tower_Of_Hanoi_1_Aux();
        toh.Hanoi(4,"A","B","C");
    }
}
