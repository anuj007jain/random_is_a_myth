package com.InterviewProblems;

public class BlackRock_Stock_Picker_From_The_Future {

    static String computeBestTransaction(int[] data) {

        //initial cases
        int bestMinValue = data[0];
        int bestMinIndex = 0;
        int bestMaxValue = data[0];
        int bestMaxIndex = 0;
        int currentMinValue = data[0];
        int currentMaxValue = data[0];
        int currentMinIndex = 0;
        int currentMaxIndex = 0;

        for (int i = 1 ; i < data.length ; i++) {
            int value = data[i];
            if (value < currentMinValue) {
                if (currentMaxValue - currentMinValue > bestMaxValue - bestMinValue) {
                    bestMinValue = currentMinValue;
                    bestMinIndex = currentMinIndex;
                    bestMaxValue = currentMaxValue;
                    bestMaxIndex = currentMaxIndex;
                }
                currentMinValue = value;
                currentMinIndex = i;
                currentMaxValue = value;
                currentMaxIndex = i;
            }
            else if (value > currentMaxValue) {
                currentMaxValue = value;
                currentMaxIndex = i;
            }
        }
        if(currentMaxValue - currentMinValue > bestMaxValue - bestMinValue) {
            bestMinValue = currentMinValue;
            bestMinIndex = currentMinIndex;
            bestMaxValue = currentMaxValue;
            bestMaxIndex = currentMaxIndex;
        }

        return formatOutputString(bestMinValue, bestMinIndex, bestMaxValue, bestMaxIndex, bestMaxValue - bestMinValue);//formatOutputString(buyPrice,buyDay,sellPrice,sellDay,profit);
    }

    static String formatOutputString(int buyPrice, int buyDay, int sellPrice, int sellDay, int profit){
        return "BUY@"+buyPrice+" on day "+buyDay+" and SELL@"+sellPrice+" on day "+sellDay+".  For a profit of $"+profit+" per share!";
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{100,99,100,101,80};
        int[] arr2 = new int[]{99,101,100,102,104,98,97,102};
        BlackRock_Stock_Picker_From_The_Future brspftf = new BlackRock_Stock_Picker_From_The_Future();
        System.out.println(brspftf.computeBestTransaction(arr2));
    }

}
