package com.springinaction.thread;

/**
 * Created by sunyinhui on 2017/3/30.
 * 多个线程共享变量
 */
public class MultiThreadShareData {
    public static void main(String[] args) {
        final ShareData1 shareData1 = new ShareData1();
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
    }

}

class ShareData1{

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
