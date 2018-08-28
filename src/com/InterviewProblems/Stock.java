package com.InterviewProblems;

/**
 * Created by anuj.jain02 on 8/3/17.
 */
public class Stock {

    public static void main(String[] args) {
        int arr[] = {10 , 12 , 11 , 9 , 8 , 33 , 44 ,66};
        //int arr[] = {10 , 9 , 8};
        //int arr[] = {8 , 9 , 10};

        boolean buy = false;
        int buyingPrice = 0;
        int totalProfit = 0;

        int i;
        for(i = 0 ; i < arr.length - 1 ; i++){ // [0 - 7) in this  case
            if(arr[i+1] > arr[i]){
                if(buy){
                    System.out.println("Hold");
                }
                else{
                    System.out.println("Buy");
                    buy = true;
                    buyingPrice = arr[i];
                }
            }
            else{
                if(buy){
                    System.out.println("Sell");
                    buy = false;
                    totalProfit += arr[i] - buyingPrice;
                    buyingPrice = 0;
                }
                else{
                    System.out.println("Not buying");
                }
            }
        }
        if(buy){
            System.out.println("Sell");
            buy = false; // optional
            totalProfit += arr[i] - buyingPrice;
            buyingPrice = 0; // optional
        }
        System.out.println("Total profit that can be made: " + totalProfit);

    }


}
