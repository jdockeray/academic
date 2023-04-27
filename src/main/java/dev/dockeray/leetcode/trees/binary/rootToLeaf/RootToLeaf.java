package dev.dockeray.leetcode.trees.binary.rootToLeaf;


import dev.dockeray.leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;



public class RootToLeaf {
    public static List<List<Integer>>  preOrder(TreeNode root, List<List<Integer>> stack, List<Integer> current){
        current.add(root.val);

        if(root.left != null){
            preOrder(root.left, stack, new ArrayList<>(current));
        }
        if(root.right != null){
            preOrder(root.right, stack, new ArrayList<>(current));
        }
        if(root.left == null && root.right == null) {
            stack.add(new ArrayList<>(current));
        }

        return stack;
    }



    public static int sumNumbers(TreeNode root) {
        List<List<Integer>> stack = new ArrayList<>();
        var visited = preOrder(root, stack, new ArrayList<>());
        System.out.println(visited);
        var numbers = visited.stream().map(list -> {
            StringBuilder number = new StringBuilder();

            for (Integer str : list) {
                number.append(str);
            }
            return Integer.parseInt(number.toString());
        }).toList();
        System.out.println(numbers);
        var sum = 0;

        for(Integer n:numbers){
            sum += n;
        }

        return sum;
    }

    public static void main(String[] args) {
        var root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
//        var root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), null));
        System.out.println(sumNumbers(root));
    }
}
