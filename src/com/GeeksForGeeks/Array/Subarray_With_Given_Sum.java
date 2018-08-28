package com.GeeksForGeeks.Array;

import edu.princeton.cs.algs4.In;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anuj.jain02 on 17/9/17.
 */
public class Subarray_With_Given_Sum {

    public Pair<Integer, Integer> findIndexes(int[] arr, int sum) {
        Map<Integer, Integer> sumToIndexMap = new HashMap<>();
        int currentSum = 0;
        for(int i = 0  ; i < arr.length ; i++) {
            currentSum += arr[i];
            if(currentSum == sum){
                return new Pair<>(1, i+1);
            }
            if(sumToIndexMap.get(currentSum - sum) != null) {
                return new Pair<>(sumToIndexMap.get(currentSum - sum) + 1, i+1);
            }
            sumToIndexMap.put(currentSum, i+1);
        }
        return new Pair<>(0,0);
    }

    public static void main(String[] args) {

        Subarray_With_Given_Sum swgs = new Subarray_With_Given_Sum();
        int[] arr1 = {1, 2, 3, 7, 5};
        int sum1 = 8;
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum2 = 4;
        Pair<Integer, Integer> indexes = swgs.findIndexes(arr1, sum1);
        if(indexes.getKey() == 0 && indexes.getValue() == 0){
            System.out.println(-1);
        }
        else {
            System.out.println(indexes.getKey()+" "+indexes.getValue());
        }
    }

}
