package dev.dockeray.leetcode.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void toArrayBasicTest() {
        var result = TreeNode.toArray(new TreeNode(1));
        var compare = new int[]{1};
        assertArrayEquals(result, compare);
    }

    @Test
    void toArrayMoreChildrenTest() {
        var left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        var right = new TreeNode(3, new TreeNode(6), null);
        var tree = new TreeNode(1, left, right);
        var result = TreeNode.toArray(tree);
        var compare = new int[]{4, 2, 5, 1, 6, 3};
        assertArrayEquals(result, compare);
    }



}