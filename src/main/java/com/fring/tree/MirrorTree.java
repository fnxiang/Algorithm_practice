package com.fring.tree;

public class MirrorTree {
    public TreeNode mirrorTreeBuild(TreeNode root) {
        mirror(root);
        return root;
    }

    public void mirror(TreeNode root){
        if(root==null) return ;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirror(root.left);
        mirror(root.right);
    }

}
