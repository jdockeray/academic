package dev.dockeray.datastructures.ch1;


import java.util.Arrays;
import java.util.HashSet;

public class Simple {
    void r1_1() {
        // String o = 54.5;
        String o = Double.valueOf(54.5).toString();

        // String p = "Pi = " + (String) 3.1415
        String p = "Pi = " + 3.1415;

        // String q = 1024
        String q = Integer.valueOf(1024).toString();
    }

    static boolean r1_10(long n, long m) {
        return Long.valueOf(n%m).intValue()==0;
    }

    static boolean isOdd(int num) {
        return (num & 1) == 1;
    }

    static boolean oddProduct(int[] values) {
        return Arrays.stream(values).filter(v -> v % 2 != 0).toArray().length > 1;
    }

    static boolean isDistinct(Integer[] values) {
         var set = new HashSet<Integer>(Arrays.asList(values));
         return set.size() == values.length;
    }
}
