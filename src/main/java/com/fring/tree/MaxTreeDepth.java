package com.fring.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxTreeDepth {
    public int maxDepth(TreeNode root) {
        return countMinDepth(root, 0);
    }

    /** 用递归方式*/
    public int countDepth(TreeNode root, int depth){
        if(root==null) return depth;
        else return Math.max(countDepth(root.left, depth+1), countDepth(root.right, depth+1));
    }

    public int countMinDepth(TreeNode root, int depth){
        if(root==null) return depth;
        else return Math.min(countMinDepth(root.left, depth+1), countMinDepth(root.right, depth+1));
    }

    /** 尝试用DFS*/
    public int DFS(TreeNode root){
        if (root==null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
        int max = 0;
        while (!stack.isEmpty()){
            root = stack.pop();
            int level_num = level.pop();
            if(root.right!=null) {
                stack.push(root.right);
                level.push(level_num+1);
            }
            if(root.left!=null){
                stack.push(root.left);
                level.push(level_num+1);
            }
            max = max<level_num?level_num:max;
        }
        return max;
    }

    /** 尝试用BFS */
    public int BFS(TreeNode root){
        if(root==null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int count = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                TreeNode cur = queue.pop();
                if(cur.left!=null){
                    queue.addLast(cur.left);
                }
                if (cur.right!=null){
                    queue.addLast(cur.right);
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.right.right = new TreeNode(4);
        MaxTreeDepth obj = new MaxTreeDepth();
        System.out.println(obj.maxDepth(node1));
    }
}
