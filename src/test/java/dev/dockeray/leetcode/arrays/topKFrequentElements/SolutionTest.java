package dev.dockeray.leetcode.arrays.topKFrequentElements;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void returns_top_two_elements(){
        var input = new int[]{1,1,1,2,2,3};
        var sol = new Solution();

        var result = sol.topKFrequent(input, 2);
        var expected = new int[]{1, 2};

        assertArrayEquals(expected, result);
    }

    @Test
    void returns_top_three_elements(){
        var input = new int[]{1,1,1,2,2,3};
        var sol = new Solution();

        var result = sol.topKFrequent(input, 3);
        var expected = new int[]{1, 2, 3};

        assertArrayEquals(expected, result);
    }

    @Test
    void handles_negative_integers(){
        var input = new int[]{4,1,-1,2,-1,2,3};
        var sol = new Solution();

        var result = sol.topKFrequent(input, 2);
        var expected = new int[]{-1, 2};

        assertArrayEquals(expected, result);
    }
}


