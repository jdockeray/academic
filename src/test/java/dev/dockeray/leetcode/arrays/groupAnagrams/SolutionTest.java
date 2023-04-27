package dev.dockeray.leetcode.arrays.groupAnagrams;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

            boolean isEqual = new EqualsBuilder()
                    .append(result, expected)
                    .isEquals();

            assertTrue(isEqual);
        }
    }
}
