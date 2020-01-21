package com.cheelou.base.concurrent;

/**
 * @author louzf
 * @decription
 * @createTime 2020/1/5 14:47
 */
public class StringSpliceDemo {

    public static final String SEPARATOR = "_";


    /**
     * 拼接redis key
     * @param prefix 前缀
     * @param params 若干参数
     */
    public static String spliceKey(String prefix,String... params){
        String key = prefix + String.join(SEPARATOR,params);
        return key;
    }

    public static void main(String[] args) {
        System.out.println(spliceKey("zz","11","22"));
        System.out.println("当前可用虚拟机可用CPU个数为："+Runtime.getRuntime().availableProcessors() );
    }
}
