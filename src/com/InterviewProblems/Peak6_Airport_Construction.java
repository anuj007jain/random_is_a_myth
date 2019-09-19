package com.InterviewProblems;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Peak6_Airport_Construction {

    public static int getMinGates(List<Integer> landingTimes, List<Integer> takeOffTimes, int maxWaitTime, int initialPlanes) {
        int count = initialPlanes;
//        if (landingTimes.size() > takeOffTimes.size()) {
//            count += landingTimes.size() - takeOffTimes.size();
//        }
        PriorityQueue<Integer> takeOffTimesHeap = new PriorityQueue<>();
        for (int i = 0 ; i < landingTimes.size() ; i++) {
            int landingTime = landingTimes.get(i);
            if (takeOffTimes.size() <= i) {
                int latestTimeCanWaitOnRunway = findlatestTimeCanWaitOnRunway(landingTime, maxWaitTime);
                if (!takeOffTimesHeap.isEmpty() && takeOffTimesHeap.peek() <= latestTimeCanWaitOnRunway) {
                    takeOffTimesHeap.poll();
                    continue;
                } else {
                    count++;
                    continue;
                }
            }
            int takeOffTime = takeOffTimes.get(i);
            int latestTimeCanWaitOnRunway = findlatestTimeCanWaitOnRunway(landingTime, maxWaitTime);
            if (latestTimeCanWaitOnRunway >= takeOffTime) {
                continue;
            }
            if (!takeOffTimesHeap.isEmpty() && takeOffTimesHeap.peek() <= latestTimeCanWaitOnRunway) {
                takeOffTimesHeap.poll();
                takeOffTimesHeap.add(takeOffTime);
                continue;
            }
            count++;
            takeOffTimesHeap.add(takeOffTime);
        }
        return count;
    }

    private static int findlatestTimeCanWaitOnRunway(int landingTime, int maxWaitTime) {
        int hours = landingTime / 100;
        int mins = landingTime % 100;
        if (mins + maxWaitTime < 60) {
            return landingTime + maxWaitTime;
        }
        int new_mins = (mins + maxWaitTime) % 60;
        hours += (mins + maxWaitTime) / 60;
        if (hours > 24) {
            hours /= 24;
        }
        String hourStr = String.valueOf(hours);
        String minStr = "";
        if (new_mins < 10) {
            minStr = "0"+String.valueOf(new_mins);
        } else {
            minStr = String.valueOf(new_mins);
        }
        return Integer.parseInt(hourStr+minStr);
    }

    public static void main(String[] args) {
        Peak6_Airport_Construction p6ac = new Peak6_Airport_Construction();

        System.out.println(p6ac.getMinGates(Arrays.asList(1837, 1837, 1941), Arrays.asList(1837), 18, 1));
        System.out.println(p6ac.getMinGates(Arrays.asList(408, 553, 558, 819, 905, 1526, 1537, 1952, 2054, 2059), Arrays.asList(944, 1231, 1436, 1707, 1939, 2045, 2328), 0, 0));
        System.out.println(p6ac.getMinGates(Arrays.asList(340, 1240, 1250, 1600, 1715, 1832, 2204), Arrays.asList(1144, 1305, 1318, 1612, 1801, 2141, 2300), 15, 0));
        System.out.println(p6ac.getMinGates(Arrays.asList(630, 645, 730, 1100), Arrays.asList(700, 845, 1015,1130), 20, 1));
    }

}
