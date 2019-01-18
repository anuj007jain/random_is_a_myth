package com.InterviewProblems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Twilio_Hosts_And_Total_No_Of_Requests {

    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = "log.txt";
        FileInputStream in = new FileInputStream("log.txt");
        FileOutputStream out = new FileOutputStream("abc.txt");
        BufferedReader br = new BufferedReader(new FileReader("log.txt"));
        int c;
        String line = br.readLine();
        Map<String, Integer> map = new HashMap<>();
        while (line != null) {
            String s = line.split(" ")[0];
            if (map.get(s) == null) {
                map.put(s, 1);
            } else {
                int k = map.get(s);
                map.put(s, k + 1);
            }
            line = br.readLine();
        }
        for (Map.Entry<String,Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());

    }

}
