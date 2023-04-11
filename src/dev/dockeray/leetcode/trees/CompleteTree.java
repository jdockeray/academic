package dev.dockeray.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        boolean valid = true;

        level.add(root);
        var nullPresent = false;
        while (!level.isEmpty() && valid) {

            var vals = level.stream().flatMap(l -> {
                List<Boolean> next = new ArrayList<>();
                next.add(l.left != null);
                next.add(l.right != null);
                return next.stream();
            }).toList();

            var isLastLevel = level.stream().filter(t -> t.right != null || t.left != null).toList().size() == 0;
            for (Boolean current : vals) {
                if (nullPresent && current) {

                    valid = false;

                }
//                if(!current && !isLastLevel){
//                    valid = false;
//                }

                if (!current) {
                    nullPresent = true;
                }
            }

            if (!isLastLevel) {
                level = level.stream().flatMap(l -> {
                    List<TreeNode> next = new ArrayList<>();
                    if (l.left != null) {
                        next.add(l.left);
                    }
                    if (l.right != null) {
                        next.add(l.right);
                    }
                    return next.stream();
                }).toList();
            } else {
                level = new ArrayList<>();
            }
        }
        return valid;
    }
}
