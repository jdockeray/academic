package dev.dockeray.leetcode.arrays.topKFrequentElements;


import java.util.*;


public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        Map<Integer, List<Integer>> countNums = new HashMap<>();

        int max = 0;

        for(int num: nums){
            int total = numsCount.getOrDefault(num, 0) + 1;
            numsCount.put(num, total);
            List<Integer> countBucket = countNums.getOrDefault(total, new ArrayList<>());
            countBucket.add(num);
            countNums.put(total, countBucket);
            if(total > max){
                max = total;
            }
        }

        int nextIdx = 0;
        int[] kFrequent = new int[k];
        Set<Integer> frequent = new HashSet<>();
        for(int i = max; i >= 1; i--){
            List<Integer> nextHighBucket = countNums.get(i);
            for(Integer val: nextHighBucket){
                if(frequent.add(val) && nextIdx < k){
                    kFrequent[nextIdx++] = val;
                }
            }

        }
        return kFrequent;
    }
}
