package com.GeeksForGeeks.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anuj on 22/5/16.
 */

//http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
public class Sum_Of_2_Numbers_Equal_To_X {


    private void findPair(int[] arr, int x){

        Map<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < arr.length-1 ; i++){
            int y = x - arr[i];
            if(hashMap.get(y)==null)
                hashMap.put(arr[i],1);
            else
                System.out.print(arr[i]+" "+y);
        }

    }


    public static void main(String[] args) {

        Sum_Of_2_Numbers_Equal_To_X so2netx = new Sum_Of_2_Numbers_Equal_To_X();
        int[] arr = {+1,+70,-10,+60,-80,+85};
        int x = -90;
        so2netx.findPair(arr, x);

    }

}
