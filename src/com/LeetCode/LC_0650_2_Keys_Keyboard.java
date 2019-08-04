package com.LeetCode;

public class LC_0650_2_Keys_Keyboard {

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        int count = 2;
        int current = 1;
        int option = 2;
        n-=2;
        while(n != 0) {
            if (n % option == 0) {
                count += 2;
                current = option;
                n -= option;
                option = current + option;
                continue;
            }
            count += 1;
            option += current;
            n -= current;
        }
        return count;
    }

}
