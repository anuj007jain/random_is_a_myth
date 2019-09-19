package com.InterviewProblems;

import java.util.*;

public class Twitter_Authentication_Tokens {

    public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        Map<Integer, Integer> tokenIdToExpiryMap = new HashMap<>();
        for (List<Integer> command : commands) {
            int commandType = command.get(0);
            int tokenId = command.get(1);
            int time = command.get(2);
            if (commandType == 0) { //GET
                if (tokenIdToExpiryMap.get(tokenId) == null) { //token
                    tokenIdToExpiryMap.put(tokenId, time + expiryLimit);
                } // what if token id present and expired
            } else { //RESET
                if (tokenIdToExpiryMap.get(tokenId) == null || tokenIdToExpiryMap.get(tokenId) < time) {
                    continue;
                }
                tokenIdToExpiryMap.put(tokenId, time + expiryLimit);
            }
        }
        int latestTime = commands.get(commands.size() - 1).get(2);
        int count = 0;
        for (int expiryTime : tokenIdToExpiryMap.values()) {
            if (expiryTime >= latestTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Twitter_Authentication_Tokens twa = new Twitter_Authentication_Tokens();
        List<List<Integer>> commands1 = new ArrayList<>();
        commands1.add(Arrays.asList(0,1,1));
        commands1.add(Arrays.asList(1,1,5));
        System.out.println(twa.numberOfTokens(3, commands1));
    }

}
