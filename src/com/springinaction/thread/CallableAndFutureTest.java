package com.springinaction.thread;

import java.util.concurrent.*;

import static javafx.scene.input.KeyCode.T;

/**
 * Created by sunyinhui on 2017/3/30.
 * Future获取的结果类型和Callable返回的结果类型必须一致，这是通过泛型来实现的
 *
 * Callable要采用ExecutorService的submit方法提交，返回的Future对象可以取消任务
 * CompletionService 用于提交一组Callable任务，其task方法返回已完成的一个Callable任务对应的Future对象
 *
 */
public class CallableAndFutureTest {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<Object> future =
        threadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "hello";
            }
        });
        System.out.println("等待结果");
        try {
            System.out.println("拿到结果：" + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        ExecutorService threadPool2 = Executors.newFixedThreadPool(10);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(threadPool2);
        for (int i = 0; i < 10; i++) {
            final int seq = i;
            completionService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return seq;
                }
            });
        }

        // 等待结果
        System.out.println("等待结果");
        for (int i = 0; i < 10; i++) {
            System.out.println("拿到结果：");
            try {
                Integer integer = completionService.take().get();
                System.out.println(integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }


    }
}
