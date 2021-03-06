package com.springinaction.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunyinhui on 2017/3/30.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int j = 0; j <= 10; j++) {
            final int taskId = j;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " is loop of " + i + " for task of " + taskId);
                    }
                }
            });
        }
        System.out.println("all of 10 tasks have committed!");
        // 如果任务做完，线程池就关闭
        threadPool.shutdown();

        // threadPool.shutdownNow();
        // 10秒之后运行
        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("bombing!");
            }
        }, 10, TimeUnit.SECONDS);

        // 10秒后运行，然后每两秒运行
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("bombing~!");
                    }
                },
                10,  //10秒之后
                2,   //每隔2秒
                TimeUnit.SECONDS
        );

        threadPool.shutdown();

    }
}
