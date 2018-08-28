package com.GeeksForGeeks.PatternSearching;

/**
 * Created by anuj on 15/5/16.
 */

//http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
public class Naive_Pattern_Searching {

    private void searchPattern(String txt, String patt){

        int j = 0;
        for(int i = 0 ; i <= txt.length()-patt.length(); i++ ){
            for(j = 0 ; j <patt.length() ; j++) {
                if (txt.charAt(i+j) != patt.charAt(j))
                    break;
            }
            if(j == patt.length())
                System.out.print(i+" ");
        }

    }

    public static void main(String[] args) {

        Naive_Pattern_Searching nps = new Naive_Pattern_Searching();
        String txt = "AAAAAAAAAAAAAAAAAA";
        String patt = "AAAA";
        nps.searchPattern(txt,patt);

    }

}
