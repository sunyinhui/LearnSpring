package com.springinaction.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by sunyinhui on 2017/3/30.
 */
public class CacheDemo {
    private Map<String, Object> cache = new HashMap<String, Object>();

    public static void main(String[] args) {
    }


    public Object getData1(String key) {
        Object value = cache.get(key);
        // 多线程情况下，会存在多个线程同时查数据库。so,需要加上锁 synchronized
        // 但是读的时候不需要互斥，写的时候才需要加上锁
        if (value == null) {
            value = "query from db";
            // 从数据库里取出来，然后放到缓存里
            cache.put("value", value);
        }

        return value;
    }

    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public Object getData2(String key) {
        rwl.readLock().lock();
        Object value = null;
        try {
            value = cache.get(key);
            if (value == null) {
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try {
                    if (cache.get(key) == null) {
                        value = "query from db";
                        cache.put("value", value);
                    }

                } finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();

            }
        } finally {
            rwl.readLock().unlock();
        }
        return value;
    }
}
