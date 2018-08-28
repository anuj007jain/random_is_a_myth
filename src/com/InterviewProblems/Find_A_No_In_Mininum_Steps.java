package com.InterviewProblems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by anuj.jain02 on 18/8/16.
 */
//http://www.geeksforgeeks.org/find-a-number-in-minimum-steps/
public class Find_A_No_In_Mininum_Steps {

    private int findMinimumSteps(int n){
        int steps = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        while(!map.isEmpty()){
            if(steps == 200)
                return steps;
            int size = map.size();
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries){
                if(map.get(entry.getKey()) == n)
                    return steps;
                map.put(map.get(entry.getKey())+steps,steps);
                map.put(map.get(entry.getKey())-steps,steps);
                map.remove(map.get(entry.getKey()));
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {

        Find_A_No_In_Mininum_Steps fanims = new Find_A_No_In_Mininum_Steps();
        int n = 10;
        System.out.print(fanims.findMinimumSteps(n));

    }

}
