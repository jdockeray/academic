package dev.dockeray.leetcode.trees.binary.complete;

import dev.dockeray.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        List<TreeNode> level = new ArrayList<>();
        boolean valid = true;
        var nullPresent = false;

        level.add(root);
        while (!level.isEmpty() && valid) {
            var nextLevel = new ArrayList<TreeNode>();

            for(TreeNode t : level) {
                boolean isLeftNull = t.left == null;
                boolean isRightNull = t.right == null;
                boolean[] values = {!isLeftNull, !isRightNull};
                if(!isLeftNull){
                    nextLevel.add(t.left);
                }
                if(!isRightNull){
                    nextLevel.add(t.right);
                }
                for (Boolean current : values) {
                    if (nullPresent && current) {
                        valid = false;
                    }
                    if (!current) {
                        nullPresent = true;
                    }
                }
            }

            level = nextLevel;
        }
        return valid;
    }
}
