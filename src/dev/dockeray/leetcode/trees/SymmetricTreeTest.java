package dev.dockeray.leetcode.trees;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SymmetricTreeTest {
    @Nested
    class InOrder {

        @Test
        void left_and_right_are_not_null_and_symmetric() {
            var st = new SymmetricTree();
            var left = new TreeNode(1);
            var right = new TreeNode(1);
            assertTrue(st.inOrder(left, right));
        }


        @Test
        void left_and_right_are_multi_child_and_symmetric() {
            var st = new SymmetricTree();
            var left = new TreeNode(1, new TreeNode(2), new TreeNode(3));
            var right = new TreeNode(1, new TreeNode(3), new TreeNode(2));
            assertTrue(st.inOrder(left, right));
        }

        @Test
        void left_and_right_are_single_child_and_symmetric() {
            var st = new SymmetricTree();
            var left = new TreeNode(1, new TreeNode(2), null);
            var right = new TreeNode(1, null, new TreeNode(2));
            assertTrue(st.inOrder(left, right));
        }

        @Test
        void left_and_right_are_multi_child_and_not_symmetric() {
            var st = new SymmetricTree();
            var left = new TreeNode(1, new TreeNode(2), new TreeNode(3));
            var right = new TreeNode(1, new TreeNode(2), new TreeNode(3));
            assertFalse(st.inOrder(left, right));
        }

        @Test
        void left_and_right_are_single_child_and_not_symmetric() {
            var st = new SymmetricTree();
            var left = new TreeNode(1, new TreeNode(2), null);
            var right = new TreeNode(1, new TreeNode(2), null);
            assertFalse(st.inOrder(left, right));
        }

        @Test
        void left_has_single_right_has_siblings() {
            var st = new SymmetricTree();
            var right = new TreeNode(1, new TreeNode(2), new TreeNode(2));
            var left = new TreeNode(1, new TreeNode(2), null);
            assertFalse(st.inOrder(left, right));
        }
    }
    @Nested
    class isSymmetric {
        @Test
        void left_and_right_are_both_null() {
            var tree = new TreeNode(1, null, null);
            var st = new SymmetricTree();

            assertTrue(st.isSymmetric(tree));
        }

        @Test
        void left_is_null_and_right_is_not() {
            var right = new TreeNode();
            var tree = new TreeNode(1, null, right);
            var st = new SymmetricTree();

            assertFalse(st.isSymmetric(tree));
        }

        @Test
        void right_is_null_and_left_is_not() {
            var left = new TreeNode();
            var tree = new TreeNode(1, left, null);
            var st = new SymmetricTree();

            assertFalse(st.isSymmetric(tree));
        }
    }


}