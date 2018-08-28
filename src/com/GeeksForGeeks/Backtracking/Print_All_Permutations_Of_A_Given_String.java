package com.GeeksForGeeks.Backtracking;

/**
 * Created by anuj on 26/5/16.
 */

//http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
public class Print_All_Permutations_Of_A_Given_String {

    private void printAllPermutationsOfAGivenString(StringBuffer x,int l, int h){

        if(l==h)
            System.out.println(x);
        for(int i = l ; i <= h ; i++){
            swap(x,l,i);
            printAllPermutationsOfAGivenString(x,l+1,h);
            swap(x,l,i);//Backtracking
        }

    }

    public static void main(String[] args) {

        Print_All_Permutations_Of_A_Given_String papoags = new Print_All_Permutations_Of_A_Given_String();
        StringBuffer x = new StringBuffer("ABCD");
        papoags.printAllPermutationsOfAGivenString(x,0,x.length()-1);


    }

    private StringBuffer swap(StringBuffer x, int a, int b){
        char temp =  x.charAt(a);
        x.setCharAt(a,x.charAt(b));
        x.setCharAt(b,temp);
        return x;
    }

}
