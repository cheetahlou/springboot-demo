package com.cheelou.springbootdemo.demo;

import com.cheelou.springbootdemo.demo.Chee;

/**
 * @createTime 2019/2/25 16:02
 */
public class CheeChild extends Chee {
    public static void main(String[] args) {
        CheeChild chil = new CheeChild();
        System.out.print(chil.getZzz());//子类继承父类后属性值也继承
        String property = System.getProperty("line.separator");//不同系统换行符
        System.out.print("111:");
        System.out.print(property);
        String curDir = System.getProperty("user.dir");//当前工作目录
        System.out.println(curDir);
    }
}
