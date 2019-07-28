package com.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_078_Subsets {

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> solution = new ArrayList<>();
//        solution.add(new ArrayList<>());
//        for (int i = 1 ; i <= nums.length ; i++) {
//            List<List<Integer>> solutionInternal = new ArrayList<>();
//            subsetsWithLimit(nums, solutionInternal, new ArrayList<>(), i);
//            for(List<Integer> list : solutionInternal) {
//                solution.add(list);
//            }
//        }
//        return solution;
//    }
//
//    private void subsetsWithLimit(int[] nums, List<List<Integer>> solutionInternal, List<Integer> solution, int size) {
//        if (size == solution.size()) {
//            Collections.sort(solution);
//            if(!solutionInternal.contains(solution)) {
//                solutionInternal.add(new ArrayList<>(solution));
//            }
//            return;
//        }
//        for (int num : nums) {
//            if (solution.contains(num)) {
//                continue;
//            }
//            solution.add(num);
//            subsetsWithLimit(nums, solutionInternal, solution, size);
//            //backtrack
//            solution.remove(Integer.valueOf(num));
//        }
//    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {1,2,3,4,5,6,7,8,10,0};
        LC_078_Subsets lc_078_subsets = new LC_078_Subsets();
        System.out.println(lc_078_subsets.subsets(nums1));
    }

}
