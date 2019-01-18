package com.InterviewProblems;

import java.util.*;

/*
put(k, v) // time()
get(k, t)

put(1, 11) // 122
put(2, 23) // 277
put(1, 15) // 344

get(1, 101) => null
get(1, 122) => 11
get(1, 125) => 11
get(1, 355) => 15
*/

class SumoLogic {

    static class TimeToValue {

        long time;
        int value;

        public TimeToValue(long time, int value) {
            this.time = time;
            this.value = value;
        }

        public long getTime() {
            return time;
        }

        public int getValue() {
            return value;
        }

    }

    static long timer=100;
    public static long time()
    {
        timer+=10;
        return timer;
    }

    static Map<Integer, List<TimeToValue>> map = new HashMap<>();

    public static void put(int key, int value) {
        List<TimeToValue> list = map.get(key);

        if(list == null) {
            list = new ArrayList<TimeToValue>();
            list.add(new TimeToValue(time(), value));
        } else {
            list.add(new TimeToValue(time(), value));
        }
        map.put(key, list);
    }

    public static Integer get(int key, long time) {
        List<TimeToValue> list = map.get(key);
        if (list == null) {
            return null;
        }
        return BinarySearch(list, time);
    }

    public static Integer BinarySearch(List<TimeToValue> list, long time) {

        int lo = 0, hi = list.size() - 1;

        if (time < list.get(0).getTime()) {
            return null;
        }
        int mid = 0;
        while (lo < hi) {
            mid = (lo+hi)/2;
            if(time < (list.get(mid)).getTime()) {
                hi = mid - 1;
            } else if (time > (list.get(mid)).getTime()) {
                lo = mid + 1;
            } else {
                return list.get(mid).getValue();
            }
        }
        return list.get(mid).getValue();

    }

    public static void main(String[] args) {

        put(1, 11);
        put(2, 23);
        put(1, 15);

        System.out.println(get(1, 90));
        System.out.println(get(1, 100));
        System.out.println(get(1, 110));
        System.out.println(get(1, 220));
        System.out.println(get(2, 00));
        System.out.println(get(2, 95));
        System.out.println(get(2, 135));
        System.out.println(get(1, 105));
        System.out.println(get(1, 115));


    }

}