package com.fring.tree;

import java.util.Stack;

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        return Math.abs(DFS(root.left, 1)-DFS(root.right, 1))<2&&(isBalanced(root.left))&&isBalanced(root.right);
    }

    public int DFS(TreeNode root, int depth){
        if(root==null) return depth;
        return Math.max(DFS(root.left, depth+1), DFS(root.right, depth+1));
    }
}
