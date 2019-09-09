package com.cheelou.base.zzz;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author louzf
 * @decription
 * @createTime 2019/9/9 17:04
 */
public class 二叉树的非递归遍历 {


    /**
     * 非递归前序遍历
     */
    List<Integer> preorderTraversal(TreeNode root){
        List<Integer> order = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<> ();
        stack.push(root);//入栈root节点
        while(!stack.isEmpty()){
                TreeNode p = stack.pop();
                if(null != p){
                    order.add(p.val); //访问根节点
                    stack.push(p.right);//入栈右孩子
                    stack.push(p.left);//入栈左孩子
                }
        }
        return order;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
        @Override
        public String toString(){
            return "val: "+val;
        }
    }
}
