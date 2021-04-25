package com.fring.tree;

public class BTreeNearestParent {
    /** 二叉树的最近公共祖先，明确递归的结果，不一定要用数字表示，可以存在与p、q相等的节点时返回节点，否则返回null */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val==p.val||root.val==q.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null&&right==null) return null;
        if(left==null) return right;
        if(right==null) return left;
        return root;
    }

    /** 复习最深节点的公共祖先 */
    public TreeNode highestCommonAncestor(TreeNode root) {
        if(root==null) return null;
        int left = recur(root.left);
        int right = recur(root.right);
        if(left==right){
            return root;
        }else if(left<right){
            return highestCommonAncestor(root.right);
        }
        return highestCommonAncestor(root.left);
    }

    public int recur(TreeNode root){
        if(root==null) return 0;
        int left = recur(root.left);
        int right = recur(root.right);
        return Math.max(left,right)+1;
    }
}
