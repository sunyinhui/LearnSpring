package com.springinaction.finallyTest;

/**
 * Created by sunyinhui on 2017/3/29.
 */
public class Test {
    public int aaa() {
        int x = 1;
        int y = 666;

        try {
            return ++x;
        } catch (Exception e) {

        } finally {
            ++x;
        }
        return y;
    }

    public static void main(String[] args) {
        Test t = new Test();
        int y = t.aaa();
        System.out.println(y);
    }
}
