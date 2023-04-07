package dev.dockeray.leetcode.trees;

public class CompleteTree {

    public static boolean isCompleteTree(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null){
            return false;
        }

       var checkLeft = isCompleteTree(root.left);
        if(checkLeft){
            if(root.right != null){
                return isCompleteTree(root.right);
            }
            return true;
        }
        return false;
    }
}
