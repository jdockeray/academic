package dev.dockeray.leetcode.arrays.duplicate;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        boolean containsDuplicate = false;
        int idx = 0;
        while(!containsDuplicate && idx != nums.length){
            if(map.get(nums[idx]) != null){
                containsDuplicate = true;
            } else {
                map.put(nums[idx], true);
            };
            idx++;
        }

        return containsDuplicate;
    }
}
