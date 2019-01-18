package com.InterviewProblems;

import java.util.ArrayList;
import java.util.List;

public class Twilio_Missing_Words {

    public List<String> solution(String s, String t) {

        List<String> solution = new ArrayList<>();
        String[] ss = s.split(" ");
        String[] ts = t.split(" ");

        int lastJMatch = -1;
        for (int i = 0 ; i < ss.length ; i++) {
            boolean found = false;
            for (int j = lastJMatch + 1 ; j < ts.length ; j++) {
                if (ss[i].equals(ts[j])) {
                    found = true;
                    lastJMatch = j;
                    break;
                }
            }
            if (!found) {
                solution.add(ss[i]);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        Twilio_Missing_Words tmw = new Twilio_Missing_Words();
        System.out.println(tmw.solution("I am using Hackerrnank to improve programming", "am Hackerrnank improve"));

    }

}
