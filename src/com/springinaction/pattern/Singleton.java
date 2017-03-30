package com.springinaction.pattern;

/**
 * Created by sunyinhui on 2017/3/29.
 */

/**
 * 单例模式
 */
public class Singleton {
    private static Singleton singleton;
    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
