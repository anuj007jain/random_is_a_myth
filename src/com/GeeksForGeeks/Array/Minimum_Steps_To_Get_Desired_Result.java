package com.GeeksForGeeks.Array;

/**
 * Created by anuj on 10/5/16.
 */

//http://www.geeksforgeeks.org/count-minimum-steps-get-given-desired-array/
public class Minimum_Steps_To_Get_Desired_Result {

    private void getMinimumSteps(int[] arr){
        int i,j=0;
        int count = 0;
        int zeroes;
        while(true) {
            zeroes = 0;
            for (i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    zeroes++;
                }
                else if (arr[i] % 2 == 0 && zeroes == 0) {
                    j=i;
                    continue;
                }
                else {
                    j =i;
                    break;
                }
            }
            if (zeroes == arr.length) {
                System.out.print(count);
                return;
            }
            if (i == arr.length && zeroes == 0)
                for (i = 0; i < arr.length; i++)
                    arr[i] /= 2;
            else
                    arr[j]--;
            count++;

                }
        }

    public static void main(String[] args) {

        Minimum_Steps_To_Get_Desired_Result mstgdr = new Minimum_Steps_To_Get_Desired_Result();
        int[] arr = {3,5,4};
        mstgdr.getMinimumSteps(arr);

    }

}
