package com.cheelou.base.tree;

/**
 * @author louzf
 * @decription
 * @createTime 2019/9/10 11:18
 */
public class TreeNode implements Cloneable{
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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
