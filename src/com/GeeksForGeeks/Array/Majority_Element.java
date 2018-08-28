package com.GeeksForGeeks.Array;

/**
 * Created by anuj.jain02 on 9/6/16.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element: A majority element in an array A[] of size n is an element that appears more than
 * n/2 times (and hence there is at most one such element).
 */

//http://www.geeksforgeeks.org/majority-element/
public class Majority_Element {

    private void findMajorityElementUsingHashMap(int[] arr){

        int majorityElement = 0;
        int majorityCount = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
                if(majorityCount < map.get(arr[i])+1){
                    majorityCount = map.get(arr[i]);
                    majorityElement = arr[i];
                }
            }
            else {
                map.put(arr[i], 1);
                if(majorityCount < 1){
                    majorityCount = 1;
                    majorityElement = arr[i];
                }
            }
        }
        if(majorityCount > arr.length/2)
            System.out.print(majorityElement);
        else
            System.out.print("No Majority Element");

    }

    /*When applying the algorithm on an array, only one of below two cases might happen:
    A. the first candidate’s counter never drops to zero through out the array, or;
    B. the first candidate’s counter drops to zero at some point (reset point).

    If A, then apparently this candidate is the majority;
    If B, then (let’s say we have an array of n elements, and by the first time counter drops to zero we have gone
    through x elements so far):

    If the real majority element M never appeared in the subarray before the reset point, then it will still be the
    majority in the remaining subarray — do the algorithm again on remaining subarray;

    If the majority element M has appeared in the subarray before reset point, then it must only have appeared up to
    x/2 times (because counter is now zero). Thus in remaining subarray we have (n-x) elements in total, of which at
    least (n/2 +1 – x/2) = (n-x)/2 +1 are M [to be more precise, it's at least (floor(n/2) +1 - x/2) = floor((n-x)/2)+1 ],
    making it still the majority in remaining subarray — do the algorithm again on remaining subarray;

    And there we have it like a recursive function. Note that this is when there IS a majority (more than half)
    in the array.

    When there's no majority, this process will give you a wrong candidate, that's why you always have to do
    a second pass to check.*/

    private void mooresVotingAlgorithm(int[] arr){ //O(n)

        int candidate = findCandidate(arr); //O(n)
        boolean flag = isCandidateMajorityElement(arr, candidate); //O(n)
        if(flag)
            System.out.println(candidate);
        else
            System.out.println("NONE");

    }

    private boolean isCandidateMajorityElement(int[] arr, int candidate){
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == candidate)
                count++;
            if(count > arr.length/2)
                return true;
        }
        return false;
    }

    private int findCandidate(int[] arr){
        int maj_index = 0, count = 1;

        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i] == arr[maj_index])
                count++;
            else
                count--;
            if(count == 0) {
                maj_index = i;
                count = 1;
            }
        }
        return arr[maj_index];
    }


    public static void main(String[] args) {

        Majority_Element me = new Majority_Element();
        int[] arr1 = {3,3,4,2,4,4,2,4,4};
        int[] arr2 = {3,3,4,2,4,4,2,4};
        me.findMajorityElementUsingHashMap(arr2);
        me.mooresVotingAlgorithm(arr2);


    }

}
