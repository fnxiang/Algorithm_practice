package com.fring.tree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/**
 * 根据二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * */
public class ReBuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return findRoot(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode findRoot(int[] preorder, int pre_l, int pre_r, int[] inorder, int in_l, int in_r){
        if(pre_l>pre_r||in_l>in_r) return null;
        TreeNode root = new TreeNode(preorder[pre_l]);
        int i=in_l;
        while (inorder[i]!=preorder[pre_l]){
            i++;
        }
        root.left = findRoot(preorder, pre_l+1, pre_l+i-in_l, inorder, in_l, i-1);
        root.right = findRoot(preorder, pre_l+i+1-in_l, pre_r, inorder, i+1, in_r);
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        TreeNode tmp = root.left;
        root.left=root.right;
        root.right=tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
