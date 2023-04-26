package dev.dockeray.leetcode.arrays.twoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> register = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            var partner = target-num;
            var pidx = register.get(partner);
            if (pidx != null) {
                return new int[]{pidx, i};
            } else {
                register.put(num, i);
            }
        }
        return  null;
    }
}
