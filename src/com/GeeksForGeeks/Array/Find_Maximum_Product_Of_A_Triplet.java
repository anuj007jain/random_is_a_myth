package com.GeeksForGeeks.Array;

/**
 * Created by anuj on 1/6/16.
 */

//http://www.geeksforgeeks.org/find-maximum-product-of-a-triplet-in-array/
public class Find_Maximum_Product_Of_A_Triplet {

    private void findMaxProduct(int[] arr) {

        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > thirdLargest) {
                if (arr[i] > secondLargest) {
                    if (arr[i] > largest) {
                        thirdLargest = secondLargest;
                        secondLargest = largest;
                        largest = arr[i];
                    }
                    else{
                        thirdLargest = secondLargest;
                        secondLargest = arr[i];
                    }
                }
                else{
                    thirdLargest = arr[i];
                }
            }
            if(arr[i] < secondSmallest){
                if(arr[i] < smallest){
                    secondSmallest = smallest;
                    smallest = arr[i];
                }
                else{
                    secondSmallest = arr[i];
                }
            }
        }
        if((largest * secondLargest * thirdLargest) > (smallest * secondSmallest * largest))
            System.out.print(largest * secondLargest * thirdLargest);
        else
            System.out.print(smallest * secondSmallest * largest);
    }

    public static void main(String[] args) {

        Find_Maximum_Product_Of_A_Triplet fmpoat = new Find_Maximum_Product_Of_A_Triplet();
        int[] arr1 = {10, 3, 5, 6, 20};
        int[] arr2 = {-10, -3, -5, -6, -20};
        int[] arr3 = {1, -4, 3, -6, 7, 0};
        fmpoat.findMaxProduct(arr3);

    }

}
