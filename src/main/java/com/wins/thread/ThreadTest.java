package com.wins.thread;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ThreadTest {

    private static Object lock = new Object();


    public static void main(String[] args) {
//        new Thread(new Thread1()).start();
        Thread t1 = new Thread(new Thread2());
        try {
//            Thread.sleep(5000);
            t1.start();
//        System.out.println("join方法开始");
            t1.join();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            System.out.println("final");
        }

        new Thread(new Thread3()).start();
//        new Thread(new Thread4()).start();

        System.out.println("结果    ：   "+m1());
    }

    public static int m1() {

        int i = 0;

        try {
            System.out.println("try....   "+i);
            i = 1;

            System.out.println(i/0);

            return i;
        } catch (Exception e) {
            i = -1;
            System.out.println("catch....  "+i);
        } finally {
            i = 2;
            System.out.println("finally...  "+i);
        }
        return i;
    }

    private static class Thread1 implements Runnable{

        public void run(){

            synchronized (lock) {
                System.out.println("enter thread1...");
                System.out.println("thread1 is waiting...");
                try {
                    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                    lock.wait();
                    Thread.yield();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread1 is going on ....");
                System.out.println("thread1 is over!!!");
            }
        }
    }

    private static class Thread2 implements Runnable{

        public void run(){

            try {
                wait(100);
//                lock.wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (lock) {
                System.out.println("enter thread2....");
                System.out.println("thread2 is sleep....");

                try {
                    Thread.sleep(1000);
//                    lock.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread2 is going on....");
                System.out.println("thread2 is over!!!");
            }
        }
    }

    private static class Thread3 implements Runnable{

        public void run(){
//            synchronized (lock) {
                System.out.println("enter thread3....");
                System.out.println("thread3 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
//                lock.notifyAll();
                //==================
                //区别
                //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
                //方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
//                    System.out.println("\n");
//                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("thread3 is going on....");
                System.out.println("thread3 is over!!!");
//            }
        }
    }


    private static class Thread4 implements Runnable{

        public void run(){
            synchronized (ThreadTest.class) {
                System.out.println("enter thread4....");
                System.out.println("thread4 is going on....");
                System.out.println("thread4 is over!!!");
            }
        }
    }
}
