package com.springinaction.thread;

/**
 * Created by sunyinhui on 2017/3/30.
 * 多个线程共享变量
 */
public class MultiThreadShareData {
    public static void main(String[] args) {
        final ShareData shareData1 = new ShareData();
        // 第一种方式
        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData1.increment();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData1.decrement();
            }
        }).start();

        // 第二种方式
        ShareData shareData = new ShareData();
        for (int i = 0; i < 2 ; i++) {
            new Thread(new MyRunnable(shareData)).start();
            new Thread(new MyRunnable2(shareData)).start();
        }

    }

}

class ShareData {

    private int j = 0;
    public synchronized void increment() {
        j++;
        System.out.println("increment j is " + j);
    }

    public synchronized void decrement() {
        j--;
        System.out.println("decrement j is " + j);
    }


}


class MyRunnable implements Runnable {
    private ShareData data;
    public MyRunnable(ShareData shareData1) {
        this.data = shareData1;
    }
    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName() + ":");
        data.increment();

    }
}

class MyRunnable2 implements Runnable {
    private ShareData data;

    public MyRunnable2(ShareData data) {
        this.data = data;
    }

    @Override
    public void run() {
        System.out.print(Thread.currentThread().getName() + ":");
        data.decrement();

    }
}