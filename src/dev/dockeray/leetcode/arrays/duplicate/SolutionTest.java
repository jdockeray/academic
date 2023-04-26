package dev.dockeray.leetcode.arrays.duplicate;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Nested class  containsDuplicateTest {
        @Test
        void true_when_contains_duplicates() {
            var sol = new Solution();
            var input = new int[]{1,1,1,3,3,4,3,2,4,2};

            assertTrue(sol.containsDuplicate(input));
        }

        @Test
        void false_when_does_not_contains_duplicates() {
            var sol = new Solution();
            var input = new int[]{1,2};

            assertFalse(sol.containsDuplicate(input));
        }
    }
}