package dev.dockeray.leetcode.arrays.validAnagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Character, Integer> map;

    public Solution() {
        map = new HashMap<>();
    }

    void plus(Character c) {
        map.merge(c, 1, Integer::sum);
    }

    void minus(Character c) throws Exception {
        var next = map.getOrDefault(c, 0);
        if (next == 0) {
            throw new Exception("invalid anagram");
        }
        map.put(c, next-1);
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        for (var i = 0; i < s.length(); i++) {
            plus(s.charAt(i));
        }

        for (var i = 0; i < t.length(); i++) {
            try {
                minus(t.charAt(i));
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }
}
