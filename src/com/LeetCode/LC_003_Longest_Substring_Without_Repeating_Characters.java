package com.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anuj.jain02 on 25/6/16.
 */
public class LC_003_Longest_Substring_Without_Repeating_Characters {

    private int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int max = 0;
        int count = 0;
        while(i <= s.length()-1){
            if(map.get(s.charAt(i)) == null || map.get(s.charAt(i)) == i){
                map.put(s.charAt(i),i);
                count++;
                i++;
            }
            else{
                i = map.get(s.charAt(i));
                map = new HashMap<>();
                i++;
                if(max < count)
                    max = count;
                count = 0;

            }
        }
        if(count > max)
            max = count;
        return max;

    }

    public static void main(String[] args) {

        LC_003_Longest_Substring_Without_Repeating_Characters lswrc = new LC_003_Longest_Substring_Without_Repeating_Characters();
        String s = "bbbbb";
        int max = lswrc.lengthOfLongestSubstring(s);
        System.out.print(max);

    }
}
