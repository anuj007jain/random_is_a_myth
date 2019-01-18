package com.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/repeated-dna-sequences/
public class LC_187_Repeated_DNA_Sequences {

    public List<String> findRepeatedDnaSequences(String s) {

        Set<String> seen = new HashSet<>(), repeated = new HashSet<>();

        for (int i = 0 ; i < s.length() - 9 ; i++) {
            if (!seen.add(s.substring(i, i+10))) {
                repeated.add(s.substring(i, i+10));
            }
        }
        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {

        LC_187_Repeated_DNA_Sequences lc_187_rds = new LC_187_Repeated_DNA_Sequences();
        System.out.println(lc_187_rds.findRepeatedDnaSequences("AAAAAAAAAAAA"));

    }

}
