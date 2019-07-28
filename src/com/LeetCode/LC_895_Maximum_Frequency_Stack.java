package com.LeetCode;

import java.util.*;

public class LC_895_Maximum_Frequency_Stack {

    public static void main(String[] args) {
        LC_895_Maximum_Frequency_Stack lc_895_mfs = new LC_895_Maximum_Frequency_Stack();
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(4);
        freqStack.push(5);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

    static class FreqStack {
        Map<Integer, Integer> elementToCount = new HashMap<>();
        TreeMap<Integer, List<Integer>> countToElement = new TreeMap<>(Collections.reverseOrder());

        public FreqStack() {

        }

        public void push(int x) {
            Integer count = elementToCount.get(x);
            if (count == null) {
                elementToCount.put(x, 1);
                if (countToElement.get(1) == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    countToElement.put(1, list);
                } else {
                    List<Integer> list = countToElement.get(1);
                    list.add(x);
                    countToElement.put(1, list);
                }
            } else {
                elementToCount.put(x, count+1);
                if (countToElement.get(count + 1) == null) {
                    List<Integer> list = new ArrayList<>();
                    list.add(x);
                    countToElement.put(count + 1, list);
                } else {
                    List<Integer> list = countToElement.get(count + 1);
                    list.add(x);
                }
            }
        }

        public int pop() {
            Map.Entry<Integer, List<Integer>> entry = countToElement.firstEntry();
            Integer count = entry.getKey();
            List<Integer> list = entry.getValue();
            Integer element;
            if (list.size() == 1) {
                element = list.get(0);
                countToElement.pollFirstEntry();
            } else {
                element = list.remove(list.size() - 1);
                countToElement.put(count, list);
            }
            if (count != 1) {
                elementToCount.put(element, count - 1);
            } else {
                elementToCount.remove(element);
            }
            return element;
        }
    }
}
