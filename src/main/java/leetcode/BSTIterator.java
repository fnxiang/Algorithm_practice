package leetcode;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        buildTree(root);
    }

    public int next() {
        return stack.pop().val;
    }

    public boolean hasNext() {
        return stack.isEmpty();
    }

    public void buildTree(TreeNode root){
        if (root==null) return;
        buildTree(root.right);
//        if(root.right!=null) stack.push(root.right);
        stack.push(root);
        buildTree(root.left);
    }
}
