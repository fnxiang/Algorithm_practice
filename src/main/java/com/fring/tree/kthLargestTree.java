package com.fring.tree;

public class kthLargestTree {
    /** 考虑树遍历的性质 */
    int ans=0, step;
    public int kthLargest(TreeNode root, int k) {
        step = k;
        return ans;
    }

    public void midSearch(TreeNode root){
        if(root==null) return;
        step--;
        midSearch(root.right);
        if(step==0) {
            ans=root.val;
            return;
        }
        midSearch(root.left);
    }

}
