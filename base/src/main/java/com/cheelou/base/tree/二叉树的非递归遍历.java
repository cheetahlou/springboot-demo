package com.cheelou.base.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author louzf
 * @decription
 * @createTime 2019/9/9 17:04
 */
public class 二叉树的非递归遍历 {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        TreeNode t_l = new TreeNode(2);
        TreeNode t_r = new TreeNode(5);
        TreeNode t_l_l = new TreeNode(3);
        TreeNode t_l_r = new TreeNode(4);
        TreeNode t_r_r = new TreeNode(6);
        /* TreeNode t = new TreeNode(6);
        TreeNode t_l = new TreeNode(3);
        TreeNode t_r = new TreeNode(5);
        TreeNode t_l_l = new TreeNode(1);
        TreeNode t_l_r = new TreeNode(2);
        TreeNode t_r_r = new TreeNode(4);*/
        t.left = t_l;
        t.right = t_r;
        t_l.left = t_l_l;
        t_l.right = t_l_r;
        t_r.right = t_r_r;
        List<Integer> order = preorderTraversal(t);
        System.out.println(order);
    }

    /**
     * 非递归前序遍历
     */
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> order = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<> ();
        stack.push(root);//入栈root节点
        while(!stack.isEmpty()){
                TreeNode p = stack.pop();
                if(null != p){
                    order.add(p.val); //访问根节点
                    stack.push(p.right); //入栈右子节点
                    stack.push(p.left); //入栈左子结点，后进先出，先出栈
                }
        }
        return order;
    }

    中序遍历 左->中->右 先找到最左节点（中序遍历的第一个节点）,存储这条路径，因为需要根据根节点来找到右子节点，first = left?root.left.left:right

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

}
