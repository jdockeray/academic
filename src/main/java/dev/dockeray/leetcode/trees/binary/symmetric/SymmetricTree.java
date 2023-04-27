package dev.dockeray.leetcode.trees.binary.symmetric;

import dev.dockeray.leetcode.trees.TreeNode;

public class SymmetricTree {

    public boolean inOrder(TreeNode r1, TreeNode r2) {
        if(
            r1.val != r2.val ||
            r1.left != null && r2.right == null ||
            r1.right != null && r2.left == null ||
            r1.right == null && r2.left != null  ||
            r1.left == null && r2.right != null
        ){
            return false;
        }

        var valid = true;
        if (r1.left != null) {
            valid = inOrder(r1.left, r2.right);
        }
        if (valid && r1.right != null) {
            valid = inOrder(r1.right, r2.left);
        }

        return valid;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null || root.right == null) {
            return root.left == null && root.right == null;
        }


        return inOrder(root.left, root.right);
    }
}