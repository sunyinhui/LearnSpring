package com.springinaction.thread;

/**
 * Created by sunyinhui on 2017/3/29.
 */
public class TraditionThreadCommunication {

    public static void main(String[] args) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        synchronized (TraditionThreadCommunication.class) {
                            for (int i = 0; i < 50; i++) {
                                for (int j = 0; j < 100; j++) {
                                    System.out.println("sub thread sequece of " + j + ", loop of :" + i);
                                }
                            }
                        }
                    }
                }
        ).start();

        synchronized (TraditionThreadCommunication.class) {
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.println("main thread sequece of " + j + ", loop of :" + i);
                }
            }
        }

    }
}
