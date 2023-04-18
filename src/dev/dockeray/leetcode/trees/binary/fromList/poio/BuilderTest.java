package dev.dockeray.leetcode.trees.binary.fromList.poio;

import dev.dockeray.leetcode.trees.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BuilderTest {

    @Test
    void buildTree() {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        var tree = Solution.buildTree(inorder, postorder);
        var result = TreeNode.toArray(tree);
        var compare = new int[]{9,3,15,20,7};

         assertArrayEquals(compare, result);

    }
    @Test
    void leftSideNull() {
        int[] inorder = {1,2,3,4};
        int[] postorder = {3,4,2,1};
        var tree = Solution.buildTree(inorder, postorder);
        var result = TreeNode.toArray(tree);
        var compare = new int[]{1,2,3,4};

        assertArrayEquals(compare, result);

    }
}