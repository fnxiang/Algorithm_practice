package com.fring.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PrintTreeNode {
    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[0];
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            root = queue.pop();
            list.add(root.val);
            if(root.left!=null){
                queue.addLast(root.left);
            }
            if (root.right!=null){
                queue.addLast(root.right);
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i]=list.get(i);
        }
        return ans;
    }


    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root==null) return ans;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            while(size-->0){
                root = queue.pop();
                list.add(root.val);
                if(root.left!=null){
                    queue.addLast(root.left);
                }
                if (root.right!=null){
                    queue.addLast(root.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderIII(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root==null) return ans;
        boolean flag = false;
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<TreeNode> queue1 = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()||!queue1.isEmpty()){
            int size = Math.max(queue.size(),queue1.size());
            List<Integer> list = new LinkedList<>();
            while(size-->0){
                if(flag){
                    root = queue1.pop();
                    list.add(root.val);
                    if (root.right!=null){
                        queue.push(root.right);
                    }
                    if(root.left!=null){
                        queue.push(root.left);
                    }
                }else{
                    root = queue.pop();
                    list.add(root.val);
                    if (root.left!=null){
                        queue1.push(root.left);
                    }
                    if(root.right!=null){
                        queue1.push(root.right);
                    }
                }
            }
            flag=!flag;
            ans.add(list);
        }
        return ans;
    }
}
