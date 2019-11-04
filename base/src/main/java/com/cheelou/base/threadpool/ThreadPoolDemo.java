package com.cheelou.base.threadpool;
import java.util.concurrent.*;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author louzf
 * @decription 功能描述:
 * 使用Executor 封装好的四种线程池类型。
 * 1、newCachedThreadPool创建一个可以缓存线程池，如果线程池长度超过处理需要
 * ，可灵活回收空闲线程，若无可回收，则新建线程。
 * 2、newFixedThreadPool 创建一个定长的线程池。可控制线程最大并发数，超出的
 * 线程会在队列中等待。
 * 3、newFixedThreadPool 创建一个定长的线程池。
 * 4、newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作
 * 线程来执行任务。
 *
 * 线程池不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式，这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险。 说明：Executors返回的线程池对象的弊端如下：
 * 1）FixedThreadPool和SingleThreadPool:
 *   允许的请求队列长度为Integer.MAX_VALUE，可能会堆积大量的请求，从而导致OOM。
 * 2）CachedThreadPool:
 *   允许的创建线程数量为Integer.MAX_VALUE，可能会创建大量的线程，从而导致OOM。
 * @createTime 2019/11/4 10:48
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        NewCachedThreadPoolDemo();
        newFixedThreadPoolDemo();
        NewScheduledThreadPoolDemo();
        NewSingleThreadScheduledDemo();
    }

    public static void NewCachedThreadPoolDemo(){
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            int temp = i;
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("ThreadName:" + Thread.currentThread().getName() + " i:" + temp);
                }
            });
        }
    }
    public static void newFixedThreadPoolDemo (){
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 10; i++) {
            int temp = i;
            newFixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("ThreadName:"+Thread.currentThread().getName()+" i:"+temp);
                }
            });
        }
    }
    public static void NewScheduledThreadPoolDemo (){
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        for(int i = 0; i < 10; i++) {
            int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {

                @Override
                public void run() {
                    System.out.println("ThreadName:"+Thread.currentThread().getName()+" i:"+temp);

                }
            }, 3, TimeUnit.SECONDS);//定时3秒后 执行这个线程池
        }
    }
    public static void NewSingleThreadScheduledDemo (){
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int temp = i;
            newSingleThreadExecutor.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println("ThreadName:" + Thread.currentThread().getName() + " i:" + temp);
                }
            });
        }
    }
}
