package dev.dockeray.leetcode;

import java.lang.Math;
import java.util.Random;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    ListNode list;
    Random r;

    public int getSize() {
        var count = 0;
        var tmp = list;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public Solution(ListNode head) {
        r = new Random();
        list = head;
    }

    public Integer getRandom() {
        var rand = r.nextInt(this.getSize());
        return getNode((int) rand) != null ? getNode((int) rand).val : null;
    }

    public ListNode getNode(int idx) {
        var count = 0;
        var tmp = list;
        while (count != idx) {
            count++;
            tmp = tmp.next;
        }
        return tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */