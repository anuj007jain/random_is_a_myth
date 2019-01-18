package com.InterviewProblems;

import java.util.*;

/*
    Find the product of max and min in a dataset after each operation
    Operations available: push pop with integer values
    eg.
    PUSH 1 {1}      1*1
    PUSH 2 {1,2}    1*2
    PUSH 3 {1,2,3}  1*3
    POP  1 {2,3}    2*3
 */

public class Salesforce_Product_Of_Max_And_Min {

    public static List<Long> maxMin(List<String> operations, List<Integer> x) {
        List<Long> solution = new ArrayList();
        Set set = new TreeSet<Integer>();
        Iterator oIterator = operations.iterator();
        Iterator xIterator = x.iterator();
        while (oIterator.hasNext()) {
            String operation = String.valueOf(oIterator.next());
            Integer xElement = (Integer) xIterator.next();
            if (operation.equalsIgnoreCase("push")) {
                set.add(xElement);
            } else if (operation.equalsIgnoreCase("pop")) {
                set.remove(xElement);
            } else {
                //wrong input
            }
            solution.add(((long)(int)((TreeSet) set).first()) * ((Integer)((TreeSet) set).last()));
            System.out.println(((long)(int)((TreeSet) set).first()) * ((Integer)((TreeSet) set).last()));
        }
        return solution;
    }

    public static void main(String[] args) {
        Salesforce_Product_Of_Max_And_Min spomam = new Salesforce_Product_Of_Max_And_Min();
        List<String> operations = new ArrayList<>();
        operations.add("push");
        operations.add("push");
        operations.add("push");
        operations.add("pop");
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(1);
        spomam.maxMin(operations, integers);
    }
}
