package com.InterviewProblems;

/**
 * Created by anuj.jain02 on 16/9/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Find the max bandwidth in the given segments.
 * eg. 10 20 40
 *     20 40 30
 *     15 25 50
 *     Answer : 90
 */
public class Amazon_Max_Bandwidth {

    static class SegmentObject {
        int startTime;
        int endTime;

        public SegmentObject(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public SegmentObject setStartTime(int startTime) {
            this.startTime = startTime;
            return this;
        }

        public int getEndTime() {
            return endTime;
        }

        public SegmentObject setEndTime(int endTime) {
            this.endTime = endTime;
            return this;
        }

        @Override
        public boolean equals(Object o) {
            return true;
            /*if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SegmentObject that = (SegmentObject) o;

            if (startTime != that.startTime) return false;
            return endTime == that.endTime;*/

        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    public static void main(String[] args) {
        Map<SegmentObject, Integer> map = new HashMap<>();
        map.put(new SegmentObject(10, 20), 40);
        map.put(new SegmentObject(20, 40), 30);
        System.out.println(map.get(new SegmentObject(20,30)));
    }
}
