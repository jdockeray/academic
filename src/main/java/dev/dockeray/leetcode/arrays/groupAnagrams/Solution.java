package dev.dockeray.leetcode.arrays.groupAnagrams;


import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

       for(String str:strs){
           char[] charArray = str.toCharArray();
           Arrays.sort(charArray);
           String key = new String(charArray);
           map.putIfAbsent(key, new ArrayList<>());
           map.get(key).add(str);
       }

       return new ArrayList<>(map.values());
    }
}
