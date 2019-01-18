package com.InterviewProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter_The_Huffman_Decoder {

    public static String decode(List<String> codes, String encoded) {
        Map<String, String> map = new HashMap();
        for(String code : codes) {
            String[] arr = code.split("\t");
            map.put(arr[1],arr[0]);
        }
        int i = 0, j =1;
        StringBuilder stringBuilder = new StringBuilder();
        while(j < encoded.length()) {
            if(map.get(encoded.substring(i,j)) != null) {
                if(map.get(encoded.substring(i,j)).equals("[newline]")) {
                    stringBuilder.append("\n");
                } else{
                    stringBuilder.append(map.get(encoded.substring(i,j)));
                }
                i = j++;
            } else {
                j++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        List<String> codes = new ArrayList<>();
        codes.add("a\t100100");
        codes.add("b\t100101");
        codes.add("c\t110001");
        codes.add("d\t100000");
        codes.add("[newline]\t111111");
        codes.add("p\t111110");
        codes.add("q\t000001");
        System.out.println(new Twitter_The_Huffman_Decoder().decode(codes,"111110000001100100111111100101110001111110"));
    }

}
