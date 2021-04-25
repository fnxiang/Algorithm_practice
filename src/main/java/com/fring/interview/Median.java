package com.fring.interview;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/** 求旋转数组的中位数 */
public class Median {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, TreeNode> map = new HashMap<>();
        int num = scan.nextInt();
        if(num<1||num>1000) System.out.println(0);
        if(num<3) {
            System.out.println(num);
        }else{
            TreeNode root=null;
            while(scan.hasNextInt()){
                int parent = scan.nextInt();
                int child = scan.nextInt();
                if(root==null){
                    root = new TreeNode(parent);
                    map.put(parent, root);
                }
                if(map.get(parent)==null){
                    map.put(parent, new TreeNode(parent));
                }
                if(map.get(parent).left==null){
                    map.get(parent).left = new TreeNode(child);
                    map.put(child, new TreeNode(child));
                }else if(map.get(parent).right==null){
                    map.get(parent).right = new TreeNode(child);
                    map.put(child, new TreeNode(child));
                }else{
                    continue;
                }
            }
            System.out.println(computeHight(root));
        }
    }

    public static int computeHight(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
        int max = 1;
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            int t_level = level.pop();
            if(tmp.left!=null){
                stack.push(tmp.left);
                level.push(t_level+1);
            }
            if(tmp.right!=null){
                stack.push(tmp.right);
                level.push(t_level+1);
            }
            max = max>t_level?max:t_level;
        }
        return max;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val = val;}
    }

}
