package com.LeetCode;

public class LC_0011_Container_With_Most_Water {

    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1;
        int sol = Math.min(height[i], height[j]) * (j-i);
        while(i < j) {
            if(height[i] == height[j]) {
                i++;
                j--;
            } else if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
            sol = Math.max(sol, Math.min(height[i], height[j]) * (j-i));
        }
        return sol;
    }

    public int maxAreaN2(int[] height) {
        int sol = 0;
        for (int i = 0 ; i < height.length ; i++) {
            for (int j = i+1 ; j < height.length ; j++) {
                sol = Math.max(sol, Math.min(height[i], height[j]) * (j-i));
            }
        }
        return sol;
    }
    public static void main(String[] args) {
        LC_0011_Container_With_Most_Water lc_011_cwmw = new LC_0011_Container_With_Most_Water();
        int[] arr = {1,3,2,5,25,24,5};
        System.out.println(lc_011_cwmw.maxArea(arr));
    }

}
