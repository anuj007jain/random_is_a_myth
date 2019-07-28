package com.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC_432_All_O_One_Data_Structure {

    int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
    Map<String, Integer> keyToValueMap;
    Map<Integer, HashSet<String>> valueToKeySetMap;

    public LC_432_All_O_One_Data_Structure() {
        keyToValueMap = new HashMap<>();
        valueToKeySetMap = new HashMap<>();

    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        Integer currentValue = keyToValueMap.get(key);
        if (currentValue == null) {
            keyToValueMap.put(key, 1);
            if (maxValue == Integer.MIN_VALUE) {
                maxValue = 1;
            }
            if (minValue == Integer.MAX_VALUE || minValue > 1) {
                minValue = 1;
            }
            HashSet set = valueToKeySetMap.get(1);
            if (set == null) {
                set = new HashSet();
            }
            set.add(key);
            valueToKeySetMap.put(1, set); //check if necessary
        } else {
            keyToValueMap.put(key, currentValue + 1);
            if (maxValue == currentValue) {
                maxValue = currentValue + 1;
            }
            HashSet set = valueToKeySetMap.get(currentValue);
            set.remove(key);
            if (minValue == currentValue && set.size() == 0) {
                minValue = currentValue +1;
            }
            set = valueToKeySetMap.get(currentValue + 1);
            if (set == null) {
                set = new HashSet();
            }
            set.add(key);
            valueToKeySetMap.put(currentValue + 1, set); //check if necessary
        }

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        Integer currentValue = keyToValueMap.get(key);
        if (currentValue == null) {
            return;
        } else {
            if (currentValue == 1) {
                keyToValueMap.remove(key);
            } else {
                keyToValueMap.put(key, currentValue - 1);
            }
            HashSet set = valueToKeySetMap.get(currentValue);
            set.remove(key);
            if (maxValue == currentValue && set.size() == 0) {
                if (maxValue == 1) {
                    maxValue = Integer.MIN_VALUE;
                    minValue = Integer.MAX_VALUE;
                } else {
                    maxValue = maxValue - 1;
                }
            }
            if (minValue == currentValue && set.size() == 0) {
                minValue = getMinValueFromValues(); // not O(1)
            }
            if (currentValue != 1) {
                set = valueToKeySetMap.get(currentValue - 1);
                if (set == null) {
                    set = new HashSet();
                }
                set.add(key);
                valueToKeySetMap.put(currentValue - 1, set);
            }
        }

    }

    private int getMinValueFromValues() {
        int min = Integer.MAX_VALUE;
        for (Integer value : keyToValueMap.values()) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        HashSet<String> set = valueToKeySetMap.get(maxValue);
        if (set == null){
            return "";
        }
        return set.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        HashSet<String> set = valueToKeySetMap.get(minValue);
        if (set == null){
            return "";
        }
        return set.iterator().next();
    }

    public static void main(String[] args) {
        LC_432_All_O_One_Data_Structure lc_432_aoods = new LC_432_All_O_One_Data_Structure();
        lc_432_aoods.inc("a");
        lc_432_aoods.inc("b");
        lc_432_aoods.inc("b");
        lc_432_aoods.inc("c");
        lc_432_aoods.inc("c");
        lc_432_aoods.inc("c");
        lc_432_aoods.dec("b");
        lc_432_aoods.dec("b");
        lc_432_aoods.dec("a");
        System.out.println(lc_432_aoods.getMaxKey());
        System.out.println(lc_432_aoods.getMinKey());

    }

}
