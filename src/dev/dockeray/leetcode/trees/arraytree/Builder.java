package dev.dockeray.leetcode.trees.arraytree;

import dev.dockeray.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Builder {
    public static TreeNode buildTree(List<Integer> inorder, List<Integer> postorder, TreeNode tree)  {
        tree.val = postorder.get(postorder.size()-1);
        if(postorder.size() > 1) {
            var ioPivot = inorder.indexOf(postorder.get(postorder.size()-1));
            var ioLeft = inorder.subList(0, ioPivot);
            var ioRight = inorder.subList(ioPivot+1, inorder.size());

            var poPivot = ioLeft.size();
            var poLeft = postorder.subList(0, poPivot);
            var poRight = postorder.subList(poPivot, postorder.size()-1);

            if(poLeft.size()>0){
                tree.left = Builder.buildTree(ioLeft, poLeft, new TreeNode());
            }

            if(poRight.size()>0){
                tree.right = Builder.buildTree(ioRight, poRight, new TreeNode());
            }
        }
        return tree;
    };

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> iList = Arrays.stream(inorder).boxed().toList();
        List<Integer> pList = Arrays.stream(postorder).boxed().toList();

        return buildTree(iList, pList, new TreeNode());
    }
}
