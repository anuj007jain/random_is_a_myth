package com.InterviewProblems;

/**
 * Created by anuj on 3/5/16.
 */
public class Tower_Of_Hanoi_2_Aux {

    private void Hanoi(int n ,String source, String dest, String via, String via2){
        if(n==1)
            System.out.println(source+" -> "+dest);
        else if(n==2){
            System.out.println(source+" -> "+via);
            System.out.println(source+" -> "+dest);
            System.out.println(via+" -> "+dest);
        }

        else{
            Hanoi(n-2,source,via2,dest,via);
            System.out.println(source+" -> "+via);
            System.out.println(source+" -> "+dest);
            System.out.println(via+" -> "+dest);
            Hanoi(n-2,via2,dest,source,via);
        }
    }

    public static void main(String[] args) {
        Tower_Of_Hanoi_2_Aux toh = new Tower_Of_Hanoi_2_Aux();
        toh.Hanoi(4,"A","B","C","D");
    }

}
