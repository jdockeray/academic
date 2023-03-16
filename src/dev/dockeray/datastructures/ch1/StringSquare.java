package dev.dockeray.datastructures.ch1;

import java.util.ArrayList;
import java.util.Stack;

public class StringSquare {
    static void square(String str) {

        // var str = "carbon";
        var result = new ArrayList<ArrayList<String>>();
        var tmp = str;

        while(tmp.length() > 0){
            var active = tmp.substring(0, 1);
            tmp = tmp.substring(1);
        }
    }

    public static void main(String[] args) {

    }
}





