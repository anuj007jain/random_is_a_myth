package com.InterviewProblems;

public class ArraySort{
    public static int[] sortArray( int arr[] ){
        int i , max , location , j , temp , len = arr.length;
        for( i = 0 ; i < len ; i++ ){
            max = arr[i];
            location = i;
            for( j = i ; j < len ; j++ ){
                if( max < arr[j] ){
                    max = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        ArraySort a = new ArraySort();
        a.sortArray(new int[]{3,2,1,4});
    }
}
