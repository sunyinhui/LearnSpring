package com.springinaction.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by sunyinhui on 2017/3/29.
 * 线程范围内的共享变量
 *
 */
public class ThreadScopeShareData {

    public static int data = 0;
    public static Map<Thread, Integer> threadData = new HashMap<>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            System.out.println("this is :" + i + ":thread");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + ": has put data :" + data);
//                    threadData.put(Thread.currentThread(), data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }

    // 静态内部类
    static class A {
        public void get() {
//            int data = threadData.get(Thread.currentThread());
            System.out.println("A:" + Thread.currentThread().getName() + ":get data:" + data);
        }

    }
    static class B {
        public void get() {
//            int data = threadData.get(Thread.currentThread());
            System.out.println("B:" + Thread.currentThread().getName() + ":get data:" + data);
        }
    }
}
