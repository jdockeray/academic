package dev.dockeray.leetcode.arrays.topKFrequentElements;

import java.util.*;

import static java.util.Map.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            int total = map.getOrDefault(num, 0);
            map.put(num, ++total);
        }
       Comparator<Integer> c = new Comparator<Integer>() {
           @Override
           public int compare(Integer o1, Integer o2) {
               if(o2 > o1){
                   return 1;
               }
               if(o2.equals(o1)){
                   return 0;
               }
               return -1;
           }
       };
        List<Entry<Integer, Integer>> set = map.entrySet().stream().sorted(Entry.comparingByValue(c)).toList();
        int[] kFrequented = new int[k];
        int i = 0;
        for(Entry<Integer, Integer> e : set){
            if (i < k) {
                kFrequented[i++] = e.getKey();
            }
        }

        return kFrequented;
    }
}
