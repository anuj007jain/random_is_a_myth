package com.Repeat_Practice;

/**
 * Created by anuj.jain02 on 3/9/17.
 */
public class EditDistanceRecursion {

    public int findEditDistance(String str1, String str2, int m, int n) {
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return findEditDistance(str1, str2, m-1, n-1);

        return 1 + min ( findEditDistance(str1,  str2, m, n-1),// Insert
                findEditDistance(str1,  str2, m-1, n),   // Remove
                findEditDistance(str1,  str2, m-1, n-1) // Replace
        );

    }

    private int min(int x, int y, int z) {
        if (x<y && x<z) return x;
        if (y<x && y<z) return y;
        else return z;
    }

    public static void main(String[] args) {

        EditDistanceRecursion editDistanceRecursion = new EditDistanceRecursion();
        String str1 = "cut";
        String str2 = "caat";
        System.out.println(editDistanceRecursion.findEditDistance(str1, str2, str1.length(), str2.length()));

    }
}
