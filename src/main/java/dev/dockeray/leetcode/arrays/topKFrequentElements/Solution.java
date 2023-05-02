package dev.dockeray.leetcode.arrays.topKFrequentElements;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            int total = map.getOrDefault(num, 0);
            map.put(num, ++total);
        }

        Map<Integer, HashSet<Integer>> buckets = new HashMap<>();

        for(int num: nums){
           int count =  map.get(num);
           HashSet<Integer> bucket = buckets.getOrDefault(count, new HashSet<>());
           bucket.add(num);
           buckets.put(count, bucket);
        }

        int count = nums.length;
        HashSet<Integer> kMostFrequented = new HashSet<Integer>();
        while (kMostFrequented.size() < k){
            HashSet<Integer> next = buckets.get(count--);
            if(next != null){
                kMostFrequented.addAll(next);
            }
        }

        return kMostFrequented.stream().mapToInt(i->i).toArray();
    }
}
