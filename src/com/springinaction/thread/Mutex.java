package com.springinaction.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;

/**
 * Created by sunyinhui on 2017/3/28.
 */
public class Mutex {
    // 静态内部类，自定义同步器
    private static class Sync extends AbstractQueuedSynchronizer {
        // 是否处于占用状态
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        // 当状态为0的时候获取锁
        public boolean tryAcquire(int acquires) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        // 释放锁，将状态设置为0
        protected boolean tryRelease(int release) {
            if (getState() == 0) throw new IllegalMonitorStateException();
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // 返回一个Condition, 每个Condition都包含了一个Condition队列
        Condition newCondition() {
            return new ConditionObject();
        }


    }

    // 仅需要将操作代理到sync上即可
    private final Sync sync = new Sync();
    public void lock() {
        sync.acquire(1);
    }



}
