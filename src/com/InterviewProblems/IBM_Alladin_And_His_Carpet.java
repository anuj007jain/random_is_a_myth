package com.InterviewProblems;

import java.util.Arrays;
import java.util.List;

public class IBM_Alladin_And_His_Carpet {

    public static int optimalPoint(List<Integer> magic, List<Integer> dist) {
        for (int i = 0 ; i < magic.size() ; i++) {
            if(checkForI(i, magic, dist)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean checkForI(int i, List<Integer> magic, List<Integer> dist) {
        int availableMagic = magic.get(i);
        if (availableMagic < dist.get(i)) {
            return false;
        }
        availableMagic -= dist.get(i);
        int j = ((i+1) % magic.size());
        while (j != i) {
            availableMagic += magic.get(j);
            if (dist.get(j) > availableMagic) {
                return false;
            }
            availableMagic = availableMagic - dist.get(j);
            j = ((j+1) % magic.size());
        }
        return true;
    }

    public static void main(String[] args) {
        IBM_Alladin_And_His_Carpet ibmaahc = new IBM_Alladin_And_His_Carpet();
        System.out.println(ibmaahc.optimalPoint(Arrays.asList(3,2,5,4), Arrays.asList(2,3,4,2)));
    }

}
