package com.InterviewProblems;

public class BlackRock_Decode_The_Message {

    private static String encode(String text) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            b.append(c += c + i);
        }
        return b.reverse().toString();
    }

    private static String decode(String encodedMessage) {
        int N  = encodedMessage.length();
        StringBuilder a = new StringBuilder();
        for (int i = 0 ; i < encodedMessage.length() ; i++) {
            char c = encodedMessage.charAt(i);
            a.append((char)((c - (N - i - 1))/2));
        }
        return a.reverse().toString();
    }

    public static void main(String[] args) {
        BlackRock_Decode_The_Message brdtm = new BlackRock_Decode_The_Message();
        String x = brdtm.encode("anuj");
        System.out.println(brdtm.decode(x));
    }

}
