package dev.dockeray.leetcode;

import java.util.ArrayList;
import java.util.Stack;
import java.util.stream.Collectors;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class RootToLeaf {
    public static void sumNumbers(TreeNode root) {

        TreeNode current = root;
        ArrayList<TreeNode> stack = new ArrayList<>();
        while(current != null){
            System.out.println(current.val);
            while(current.left != null){
                stack.add(current);
                current = current.left;
                System.out.println(current.val);
            }

            if(current.right == null){
                while(!stack.isEmpty() && current.right == null){
                    current = stack.remove(stack.size()-1);
                }
                if(stack.isEmpty() && current.right == null){
                    current = null;
                }
                if(current != null) {
                    current = current.right;
                }
            } else {
                // keep on diving
                current = current.right;
            }
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(1, new TreeNode(2, new TreeNode(22), new TreeNode(23)), new TreeNode(3));
        sumNumbers(root);
    }
}
