package com.springinaction.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by sunyinhui on 2017/3/29.
 * 线程间的共享变量
 */
public class ThreadLocalTest {
    public static Map<Thread, Integer> threadData = new HashMap<>();
    public static ThreadLocal<Integer> x = new ThreadLocal<>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName() + ": has put data :" + data);
                    x.set(data);
                    new A().get();
                    new B().get();
                }
            }).start();
        }

    }

    // 静态内部类
    static class A {
        public void get() {
            int data = x.get(); // 存的就是与当期线程相关的，so, 取得就是当前线程相关的
            System.out.println("A:" + Thread.currentThread().getName() + ":get data:" + data);
        }

    }
    static class B {
        public void get() {
            int data = x.get();
            System.out.println("B:" + Thread.currentThread().getName() + ":get data:" + data);
        }
    }
}
