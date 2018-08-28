package com.InterviewProblems;

/**
 * Created by anuj.jain02 on 13/5/17.
 */
public class Yatra_Substring {

    public static void main(String[] args) {
        String s = "aab";
        Character[] vowels = {'a','e','i','o','u'};
        Character[] consonants = {'b','c','d','f','g','h','j','k','l','m','n',
        'p','q','r','s','t','v','w','x','y','z'};

        for(int k = 0 ; k <= 1 ; k++) {
            int starting_index = 0, ending_index = 0;
            boolean foundStarting = false;
            if(k == 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (!foundStarting && contains(s.charAt(i), vowels)) {
                        starting_index = i;
                        foundStarting = true;
                    }
                    if (foundStarting && contains(s.charAt(i), consonants)) {
                        ending_index = i+1;
                        System.out.println(s.substring(starting_index, ending_index));
                        break;
                    }
                }
            }
            if(k == 1) {
                for (int i = s.length()-1; i >= 0 ; i--) {
                    if (!foundStarting && contains(s.charAt(i), consonants)) {
                        ending_index = i+1;
                        foundStarting = true;
                    }
                    if (foundStarting && contains(s.charAt(i), vowels)) {
                        starting_index = i;
                        System.out.println(s.substring(starting_index, ending_index));
                        break;
                    }
                }
            }
        }

    }

    private static boolean contains(char ch, Character[] charArray) {
        boolean contains = false;
        for (char c : charArray) {
            if (c == ch) {
                contains = true;
                break;
            }
        }
        return contains;
    }

}
