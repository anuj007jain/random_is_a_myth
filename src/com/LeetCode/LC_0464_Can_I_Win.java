package com.LeetCode;

import java.util.*;

public class LC_0464_Can_I_Win {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        Map<Integer, Integer> integerToTeamMap = new HashMap<>();
        for (int i = 1 ; i <= maxChoosableInteger ; i++) {
            integerToTeamMap.put(i,0);
        }

        return max(integerToTeamMap, 0, 0, maxChoosableInteger, desiredTotal);

    }

    public boolean max(Map<Integer, Integer> integerToTeamMap, int maxScore, int minScore,
                       int maxChoosableInteger, int desiredTotal) {
        for (int i = 1 ; i <= maxChoosableInteger ; i++) {
            if (integerToTeamMap.get(i) == 0) {
                integerToTeamMap.put(i, 1);
                maxScore += i;
                if (maxScore >= desiredTotal) {
                    //integerToTeamMap.put(i,0);
                    return true;
                }
                if(min(integerToTeamMap, maxScore, minScore, maxChoosableInteger, desiredTotal)) {
                    integerToTeamMap.put(i,0);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean min(Map<Integer, Integer> integerToTeamMap, int maxScore, int minScore,
                       int maxChoosableInteger, int desiredTotal) {
        for (int i = 1 ; i <= maxChoosableInteger ; i++) {
            if (integerToTeamMap.get(i) == 0) {
                integerToTeamMap.put(i, 2);
                minScore += i;
                if (minScore >= desiredTotal) {
                    //integerToTeamMap.put(i,0);
                    return false;
                }
                if (!max(integerToTeamMap, maxScore, minScore, maxChoosableInteger, desiredTotal)) {
                    integerToTeamMap.put(i,0);
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC_0464_Can_I_Win lc_464_ciw = new LC_0464_Can_I_Win();
        System.out.println(lc_464_ciw.canIWin(10,40));
    }
}
