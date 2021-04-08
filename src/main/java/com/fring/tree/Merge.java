package com.fring.tree;

public class Merge {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null) return null;
        TreeNode root;
        if(root1==null) {
             root = root2;
        }else if(root2==null){
            root = root1;
        }else{
            root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
        }
        return root;
    }
}
