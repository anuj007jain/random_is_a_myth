package com.InterviewProblems;

public class Google_Sample {

    public String solution (String S, int K) {
        int N = S.length();
        StringBuilder str = new StringBuilder();
        int cnt = 0;
        while (N > 0) {
            char c = S.charAt(--N);
            if(c == '-') {
                continue;
            }
            str.insert(0,String.valueOf(c).toUpperCase());
            cnt++;
            if(cnt == K && N!=0) {
                cnt = 0;
                str.insert(0,'-');
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Google_Sample gs = new Google_Sample();
        System.out.println(gs.solution("2-4A0r7-4k",4));
    }

}
