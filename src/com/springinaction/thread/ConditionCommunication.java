package com.springinaction.thread;

/**
 * Created by sunyinhui on 2017/3/30.
 *  线程不仅要互斥还要实现通信
 *
 * Lock可以很好的解决线程同步的问题
 * Condition将Object的wait, notify, notifyAll分解为截然不同的对象，以便通过将这些对象与任意Lock实现组合使用
 * 为每个对象提供多个等待set(wait-set)
 * 其中，Lock替代了synchronized方法和语句的使用，Condition替代了Object监视器方法的使用
 *
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionCommunication {

    /**
     * @param args
     */
    public static void main(String[] args) {

        final Business business = new Business();
        new Thread(
                new Runnable() {

                    @Override
                    public void run() {

                        for(int i=1;i<=50;i++){
                            business.sub(i);
                        }

                    }
                }
        ).start();

        for(int i=1;i<=50;i++){
            business.main(i);
        }

    }

    static class Business {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        private boolean bShouldSub = true;
        public  void sub(int i){
            lock.lock();
            try{
                while(!bShouldSub){
                    try {
                        condition.await();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                for(int j=1;j<=10;j++){
                    System.out.println("sub thread sequence of " + j + ",loop of " + i);
                }
                bShouldSub = false;
                condition.signal();
            }finally{
                lock.unlock();
            }
        }

        public  void main(int i){
            lock.lock();
            try{
                while(bShouldSub){
                    try {
                        condition.await();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                for(int j=1;j<=100;j++){
                    System.out.println("main thread sequence of " + j + ",loop of " + i);
                }
                bShouldSub = true;
                condition.signal();
            }finally{
                lock.unlock();
            }
        }

    }
}
