package dev.dockeray.leetcode.arrays.twoSum;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Nested class  twoSum {
        @Test
        void finds_an_even() {
            var sol = new Solution();
            var result = sol.twoSum(new int[]{3,2,4}, 6);
            assertArrayEquals(result, new int[]{1,2});
        }

        @Test
        void finds_an_odd() {
            var sol = new Solution();
            var result = sol.twoSum(new int[]{2,7,11,15}, 9);
            assertArrayEquals(result, new int[]{0,1});
        }
    }

}