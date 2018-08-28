package com.GeeksForGeeks.Array;

/**
 * Created by anuj on 20/5/16.
 */

//http://www.geeksforgeeks.org/find-the-missing-number/
public class Find_Missing_Number {

    private void findMissingNumber(int[] arr, int i, int j){

        int xor = 0;
        for(int k = i ; k <=j ; k++)
            xor = xor ^ k;
        for(int k = 0 ; k < arr.length ; k++)
            xor = xor ^ arr[k];
        System.out.print(xor);

    }

    public static void main(String[] args) {

        Find_Missing_Number fmn = new Find_Missing_Number();
        int i = 10;
        int j = 20;
        int[] arr = {13,15,14,12,10,11,20,19,17,18};
        fmn.findMissingNumber(arr,i,j);
    }

}
