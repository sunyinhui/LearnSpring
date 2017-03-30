package com.springinaction.thread;

/**
 * Created by sunyinhui on 2017/3/29.
 */

/**
 * 子线程循环10次，接着主线程循环100次，如此循环50次
 *
 */
public class LoopTest {

    public static void main(String[] args) throws InterruptedException {
        final Business bus = new Business();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        bus.sub(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 主线程
        for (int i = 0; i < 50; i++) {
            bus.main(i);
        }

    }



}

class Business {
    private boolean bShouldSub = true; // 目的是先让子线程先跑，如果交替进行呢？不考虑先后

    public synchronized void sub(int i) throws InterruptedException {
        // while 比 if 更牢靠
        while (!bShouldSub) {
            this.wait();
        }
        for (int j = 0; j < 100; j++) {
            System.out.println("sub thread sequece of " + j + ", loop of " + i);
        }
        bShouldSub = false;
        this.notify();

    }

    public synchronized void main(int i) throws InterruptedException {
        while (bShouldSub) {
            this.wait();
        }
        for (int j = 0; j < 10; j++) {
            System.out.println("main thread sequece of " + j + ", loop of :" + i);
        }
        bShouldSub = true;
        this.notify();
    }
}