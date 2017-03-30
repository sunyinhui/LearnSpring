package com.springinaction.thread;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by sunyinhui on 2017/3/28.
 */
public class ConnectionPool {

    public static void main(String[] args) throws InterruptedException {
        final BusinessTest bus = new BusinessTest();

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

        for (int i = 0; i < 50; i++) {
            bus.main(i);
        }

    }



}

class BusinessTest {
    private boolean bShouldSub = true;

    public synchronized void sub(int i) throws InterruptedException {
        if (!bShouldSub) {
            this.wait();
        }
        for (int j = 0; j < 100; j++) {
            System.out.println("sub thread sequece of " + j + ", loop of " + i);
        }
        bShouldSub = false;
        this.notify();

    }

    public synchronized void main(int i) throws InterruptedException {
        if (bShouldSub) {
            this.wait();
        }
        for (int j = 0; j < 10; j++) {
            System.out.println("main thread sequece of " + j + ", loop of :" + i);
        }
        bShouldSub = true;
        this.notify();
    }
}
