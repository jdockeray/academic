package dev.dockeray.leetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
    public static int[] toArray(TreeNode root, List<Integer> list){
        if(root.left != null){
            TreeNode.toArray(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            TreeNode.toArray(root.right, list);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    };

    public static int[] toArray(TreeNode root){
        return TreeNode.toArray(root, new ArrayList<Integer>());
    };

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

