package dev.dockeray.leetcode.trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompleteTreeTest {

    @Test
    void is_complete_as_all_left_present_and_right_side_missing_right_child() {
        var left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        var right = new TreeNode(3, new TreeNode(6), null);
        var tree = new TreeNode(1, left, right);

        var t = new CompleteTree();
        assertTrue(t.isCompleteTree(tree));
    }

    @Test
    void is_not_complete_as_all_left_present_and_left_side_missing_right_child() {
        var left = new TreeNode(2, new TreeNode(5), null);
        var right = new TreeNode(3, new TreeNode(7), new TreeNode(8));

        var tree = new TreeNode(1, left, right);
        var t = new CompleteTree();
        assertFalse(t.isCompleteTree(tree));
    }

    @Test
    void is_not_complete_as_left_missing() {
        var left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        var right = new TreeNode(3, null, new TreeNode(6));
        var tree = new TreeNode(1, left, right);
        var t = new CompleteTree();

        assertFalse(t.isCompleteTree(tree));
    }

    @Test
    void is_complete_as_children_null() {
        var tree = new TreeNode(1);
        var t = new CompleteTree();

        assertTrue(t.isCompleteTree(tree));
    }
}