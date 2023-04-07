package dev.dockeray.leetcode.trees;

public class CompleteTree {
    int empty = 0;
    public boolean isCompleteTree(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null){
            return false;
        }
        if(root.right == null && empty == 0){
            empty++;
        }

       var checkLeft = isCompleteTree(root.left);


        if(checkLeft){
            if(root.right != null && empty == 0){
                return isCompleteTree(root.right);
            }
            return root.right == null && empty <= 1;
        }
        return false;
    }
}
