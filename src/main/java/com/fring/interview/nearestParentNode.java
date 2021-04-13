package com.fring.interview;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class nearestParentNode {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root==null) return null;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left==right) return root;
        if(left<right) return lcaDeepestLeaves(root.right);
        return lcaDeepestLeaves(root.left);
    }

    private int dfs(TreeNode root){
        if(root==null) return 0;
        return Math.max(dfs(root.left), dfs(root.right))+1;
    }
}
