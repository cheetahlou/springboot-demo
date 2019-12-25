package com.cheelou.base.concurrent;
import	java.util.concurrent.CountDownLatch;

/**
 * @decription 计数器
 * @createTime 2019/11/8 16:22
 */
public class CountDownLatchDemo {


    public static void main(String[] args) throws InterruptedException {
        new CountDownLatchDemo().countDownLatchDemo();
    }

    public void countDownLatchDemo() throws InterruptedException {
        System.out.println("主线程开始执行，即将阻塞");
        CountDownLatch latch = new CountDownLatch(3);

        //依次创建并启动3个线程
        new Thread(new Task(latch),"Thread1").start();
        new Thread(new Task(latch),"Thread2").start();
        new Thread(new Task(latch),"Thread3").start();
        latch.await();
        System.out.println("所有线程已到达，主线程继续执行");
    }

    static class Task implements Runnable{

        CountDownLatch countDownLatch;
        public Task(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            System.out.println("当前线程 "+Thread.currentThread().getName()+"正在执行...");
            countDownLatch.countDown();
            System.out.println("count = "+countDownLatch.getCount());
            countDownLatch.countDown();
            System.out.println("count = "+countDownLatch.getCount());
            countDownLatch.countDown();
            System.out.println("count = "+countDownLatch.getCount());
        }
    }
}
