package com.InterviewProblems;

/**
 * Created by anuj on 25/4/16.
 */
public class Remove_Minimum_Elements_Either_Side_2Min_Max {

    private int min(int a, int b){
        return (a<b)?a:b;
    }

    private int min(int arr[], int l, int h){
        int min = arr[l];
        for(int i=l+1 ; i<h ; i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }

    private int max(int arr[], int l, int h){
        int max = arr[l];
        for(int i=l+1 ; i<h ; i++){
            if(max<arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    private int minRemovals(int arr[], int l, int h){
        if(l>=h)
            return 0;

        int mn = min(arr, l, h);
        int mx = max(arr, l, h);

        if(2*mn > mx)
            return 0;

        return min(minRemovals(arr,l+1,h),minRemovals(arr, l, h-1))+1;
    }

    public static void main(String[] args) {
        int arr[] = {20, 4, 1, 3};
        int size = arr.length;
        Remove_Minimum_Elements_Either_Side_2Min_Max test = new Remove_Minimum_Elements_Either_Side_2Min_Max();
        System.out.print(test.minRemovals(arr,0,size));

    }

}
