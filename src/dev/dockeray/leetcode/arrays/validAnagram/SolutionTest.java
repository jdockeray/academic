package dev.dockeray.leetcode.arrays.validAnagram;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Nested
    class  validAnagram {
        @Test
        void returns_true_when_valid () {
            var sol = new Solution();
            assertTrue(sol.isAnagram("anagram", "nagaram"));
        }

        @Test
        void returns_false_when_invalid () {
            var sol = new Solution();
            assertFalse(sol.isAnagram("rat", "car"));
        }

        @Test
        void returns_false_when_nearly_invalid () {
            var sol = new Solution();
            assertFalse(sol.isAnagram("aacc", "ccac"));
        }
    }
}