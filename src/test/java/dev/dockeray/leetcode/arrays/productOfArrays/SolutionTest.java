package dev.dockeray.leetcode.arrays.productOfArrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void productExceptSelf() {
        var sol = new Solution();
        var result = sol.productExceptSelf(new int[]{1,2,3,4});
        var expected = new int[]{24,12,8,6};
        assertArrayEquals(result, expected);
    }

    @Test
    void productExceptSelfMinusNumbers() {
        var sol = new Solution();
        var result = sol.productExceptSelf(new int[]{-1,1,0,-3,3});
        var expected = new int[]{0,0,9,0,0};
        assertArrayEquals(result, expected);
    }
}