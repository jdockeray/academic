package dev.dockeray.leetcode.trees.arraytree;

import dev.dockeray.leetcode.trees.TreeNode;

import java.util.*;

record Pointers(int start, int end) {
}
class Builder {
    int[] postorder;
    Map<Integer, Integer> pivots;

    public Builder(int[] postorder, Map<Integer, Integer> pivots) {
        this.postorder = postorder;
        this.pivots = pivots;
    }

    public TreeNode buildTree(Pointers po, Pointers io)  {
        TreeNode tree = new TreeNode(this.postorder[po.end()]);

        var ioPivot = pivots.get(tree.val);
        var leftSize = ioPivot - io.start();
        var rightSize = io.end() - ioPivot;

        if(leftSize > 0){
            var ioLeft = new Pointers(io.start(), ioPivot-1);
            var poLeft = new Pointers(po.start(), po.start() + leftSize -1);
            tree.left = this.buildTree(poLeft, ioLeft);
        }

        if(rightSize > 0){
            var ioRight = new Pointers(ioPivot+1, io.end());
            var poRight = new Pointers(po.start()+leftSize, po.end()-1);
            tree.right = this.buildTree(poRight, ioRight);
        }
        return tree;
    };
}

public class Solution {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> pivots = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            pivots.put(inorder[i], i);
        }
        var sol = new Builder(postorder, pivots);

        return sol.buildTree(new Pointers(0, postorder.length-1), new Pointers(0, inorder.length-1));
    }
}
