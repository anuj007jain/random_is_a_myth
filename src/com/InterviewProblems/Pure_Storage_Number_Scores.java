package com.InterviewProblems;

public class Pure_Storage_Number_Scores {

    static int compute_number_score(int number) {

        int score = 0;
        int prev1more = 1;
        String num = String.valueOf(number);
        for (int i = 0 ; i < num.length() ; i++) {
            if (num.charAt(i) == '5') {
                score += 2;
            }
            if (num.charAt(i) == '3' && i > 0 && num.charAt(i - 1) == '3') {
                score += 4;
            }
            if (i < num.length() - 1 && Integer.parseInt(num.charAt(i) + "") == Integer.parseInt(num.charAt(i + 1) + "") - 1) {
                prev1more++;
            } else {
                score += prev1more * prev1more;
                prev1more = 1;
            }
            if (Integer.parseInt(num.charAt(i)+"") % 2 == 1) {
                score += 1;
            }
        }
        if (number % 5 == 0) {
            score += 6;
        }
        if (prev1more > 1) {
            score += prev1more * prev1more;
        }
        return score;
    }

    public static void main(String[] args) {
        Pure_Storage_Number_Scores psns = new Pure_Storage_Number_Scores();
        System.out.println(psns.compute_number_score(101275345));
    }

}
