package com.GeeksForGeeks.Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anuj on 21/5/16.
 */

//http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
public class Zero_Sum_Sub_Array {

    private void findZeroSumArray(int[] arr){

        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < arr.length ; i++){
            sum+=arr[i];
            if(arr[i] == 0 || sum == 0 || map.get(sum)!=null) {
                System.out.print("Yes");
                return;
            }
            else
                map.put(sum,1);
        }
        System.out.print("No");

    }

    public static void main(String[] args) {

        Zero_Sum_Sub_Array zssa  = new Zero_Sum_Sub_Array();
        int[] arr = {1,4,3,-1,2,-5,1};
        zssa.findZeroSumArray(arr);

    }

}
