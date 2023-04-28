package dev.dockeray.leetcode.arrays.groupAnagrams;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SolutionTest {
    @Nested
    public class groupAnagrams{
        @Test
        public void groups_anagrams () {
            var sol = new Solution();
            var result = sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

            List<List<String>> expected = new ArrayList<>();
            expected.add(List.of("bat"));
            expected.add(List.of("nat", "tan"));
            expected.add(List.of("ate","eat","tea"));

            Comparator<List<String>> listSize = Comparator.comparingInt(List::size);
            result.sort(listSize);
            assertTrue(CollectionUtils.isEqualCollection(result.get(0), expected.get(0)));
            assertTrue(CollectionUtils.isEqualCollection(result.get(1), expected.get(1)));
            assertTrue(CollectionUtils.isEqualCollection(result.get(2), expected.get(2)));

        }
    }
}
