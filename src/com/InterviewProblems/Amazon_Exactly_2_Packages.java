package com.InterviewProblems;

import java.util.*;

public class Amazon_Exactly_2_Packages {

    ArrayList<Integer> IDsOfPackages(int truckSpace,
                                     ArrayList<Integer> packagesSpace)
    {
        Map<Integer, Integer> prevPackageSpaceToIndex = new HashMap<>();
        int spaceAvailable = truckSpace - 30;
        ArrayList<Integer> IDsofPackages = new ArrayList<>();
        int currentHighestPackageSelected = 0;
        for (int i = 0 ; i < packagesSpace.size() ; i++) {
            int packageSpace = packagesSpace.get(i);
            if (prevPackageSpaceToIndex.containsKey(spaceAvailable - packageSpace)) {
                if (Math.max(packageSpace, spaceAvailable - packageSpace) > currentHighestPackageSelected) {
                    currentHighestPackageSelected = Math.max(packageSpace, spaceAvailable - packageSpace);
                    IDsofPackages = new ArrayList<>();
                    IDsofPackages.add(prevPackageSpaceToIndex.get(spaceAvailable - packageSpace));
                    IDsofPackages.add(i);
                }
            }
            prevPackageSpaceToIndex.put(packageSpace, i);
        }
        return IDsofPackages;
    }

    public static void main(String[] args) {
        Amazon_Exactly_2_Packages ae2p = new Amazon_Exactly_2_Packages();
        ArrayList packagesSpace = new ArrayList();
        packagesSpace.add(100);
        packagesSpace.add(180);
        packagesSpace.add(120);
        packagesSpace.add(120);
        packagesSpace.add(90);
        System.out.println(ae2p.IDsOfPackages(250, packagesSpace));
    }

}
