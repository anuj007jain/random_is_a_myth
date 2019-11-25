package com.InterviewProblems;

import java.util.*;

public class Pure_Storage_Lock_Use_Analyzer {

    static Stack<Integer> stack = new Stack<>();
    static Set<Integer> alreadyAcquiredLocks = new HashSet<>();

    static int check_log_history(List<String> events) {

        for (int i = 0 ; i < events.size() ;i++) {
            String event = events.get(i);
            String[] a = event.split(" ");
            String key = a[0];
            String val = a[1];

            if (key.equals("ACQUIRE")) {
                if (alreadyAcquiredLocks.contains(Integer.parseInt(val))) {
                    return i+1;
                }
                alreadyAcquiredLocks.add(Integer.parseInt(val));
                stack.push(Integer.parseInt(val));
            } else {
                if (!alreadyAcquiredLocks.contains(Integer.parseInt(val))) {
                    return i+1;
                }
                if (stack.peek() != Integer.parseInt(val)) {
                    return i+1;
                }
                alreadyAcquiredLocks.remove(stack.pop());
            }
        }
        if (!stack.empty()) {
            return events.size() + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Pure_Storage_Lock_Use_Analyzer pslua = new Pure_Storage_Lock_Use_Analyzer();
        System.out.println(pslua.check_log_history(Arrays.asList("ACQUIRE 84", "REMO 84")));
    }

}
