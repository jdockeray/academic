package dev.dockeray.leetcode.arrays.productOfArrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] r2l = new int[nums.length];
        int[] l2r = new int[nums.length];

        int last = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                l2r[0] = nums[0];
                r2l[last] = nums[last];
            } else {
                l2r[i] = l2r[i - 1] * nums[i];
                r2l[last - i] = r2l[last - (i - 1)] * nums[last - i];
            }
        }

        int[] product = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                product[0] = r2l[1];
            } else if (i == last) {
                product[last] = l2r[last - 1];
            } else {
                product[i] = l2r[i - 1] * r2l[i + 1];
            }
        }

        return product;
    }
}
