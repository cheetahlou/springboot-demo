package com.cheelou.base.concurrent;
import	java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @decription 栅栏  所有到达await()的线程在此等待 最后一个线程到达后开始执行
 * @createTime 2019/12/20 14:39
 */
public class CyclicBarrierDemo {

    volatile static int sum = 0;
    static AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(3);
//        CyclicBarrier barrier = new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        sum++;
                        count.incrementAndGet();
                    }
                    latch.countDown();
                }
            };
            service.execute(r);
        }
        service.shutdown();
        latch.await();
        System.out.println("总和为sum="+sum);
        System.out.println("总和为count="+count.get());

    }
}
