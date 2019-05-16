package com.cheelou.springbootdemo.controller;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @createTime 2019/3/6 15:56
 */
public class ThreadPoolDemo {
    class ThreadPoolArguments {
        private Integer coreSize = 1;

        public Integer getCoreSize() {
            return coreSize;
        }

        public void setCoreSize(Integer coreSize) {
            this.coreSize = coreSize;
        }
    }


    public void createThreadPool() {
        try {
            ThreadPoolArguments demo = new ThreadPoolArguments();
            Field field = ThreadPoolArguments.class.getDeclaredField("coreSize");
            field.setAccessible(true);
            field.set(demo, 3);
            System.out.println("coreSize = " + demo.getCoreSize());
            Method method = ThreadPoolArguments.class.getDeclaredMethod("setCoreSize", Integer.class);
            method.setAccessible(true);
            method.invoke(demo, 5);
            System.out.println("coreSize = " + demo.getCoreSize());
        } catch (NoSuchFieldException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
//        ArrayBlockingQueue workQueue = new ArrayBlockingQueue<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, null);
//        executor.execute(() -> );
    }
}
