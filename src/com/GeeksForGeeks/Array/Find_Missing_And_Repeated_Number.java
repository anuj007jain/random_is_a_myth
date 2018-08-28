package com.GeeksForGeeks.Array;

/**
 * Created by anuj on 20/5/16.
 */
//http://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
public class Find_Missing_And_Repeated_Number {

    private void findMissingAndRepeatedNumber(int[] arr, int i, int j){

        int xor = 0;
        int x = 0;
        int y =0;
        for(int k = i ; k <=j ; k++)
            xor = xor ^ k;
        for(int k = 0 ; k < arr.length ; k++)
            xor = xor ^ arr[k];

        int set_bit_no = xor & ~(xor-1);

        for(int k = i; k <= j; k++)
        {
            if((k & set_bit_no)>0)
                x = x ^ k;
            else
                y = y ^ k;
        }

        for(int k = 0; k <arr.length ; k++)
        {
            if((arr[k] & set_bit_no)>0)
                x = x ^ arr[k];
            else
                y = y ^ arr[k];
        }

        System.out.print(x+" "+y);

    }

    public static void main(String[] args) {

        Find_Missing_And_Repeated_Number fmarn = new Find_Missing_And_Repeated_Number();
        int i = 10;
        int j = 20;
        int[] arr = {13,19,15,14,12,17,10,11,20,19,18};
        fmarn.findMissingAndRepeatedNumber(arr,i,j);
    }
}
