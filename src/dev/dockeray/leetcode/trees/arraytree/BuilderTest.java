package dev.dockeray.leetcode.trees.arraytree;

import dev.dockeray.leetcode.trees.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @Test
    void buildTree() {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        var tree = Builder.buildTree(inorder, postorder);
        var result = TreeNode.toArray(Builder.buildTree(inorder, postorder));
        var compare = new int[]{9,3,15,20,7};

         assertArrayEquals(compare, result);

    }
}