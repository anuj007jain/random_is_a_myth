package com.InterviewProblems;

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class IBM_Large_Responses {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        // read the string filename
        int count = 0;
        double bytesSum = 0;
        String filename;
        filename = scan.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter("bytes_" + filename));
        while (line != null) {
            String[] elems = line.split(" ");
            double bytes = Double.parseDouble(elems[elems.length - 1]);
            if (bytes > 5000) {
                count++;
                bytesSum += bytes;
            }
            line = reader.readLine();
        }
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(0);
        String str = nf.format(bytesSum);
        writer.write(String.valueOf(count) + "\n");
        writer.write(String.valueOf(String.valueOf(str.replaceAll(",", ""))));
        reader.close();
        writer.close();

        reader = new BufferedReader(new FileReader("bytes_" + filename));
        line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
        }
    }
}
