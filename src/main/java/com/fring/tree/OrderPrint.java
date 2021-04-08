package com.fring.tree;

import java.util.ArrayList;
import java.util.List;

public class OrderPrint {
    List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        recurInOrder(root);
        return ans;
    }

    public void recurInOrder(TreeNode root){
        if(root==null) return;
        if(root.left!=null) recurInOrder(root.left);
        ans.add(root.val);
        if(root.right!=null) recurInOrder(root.right);
    }
}
