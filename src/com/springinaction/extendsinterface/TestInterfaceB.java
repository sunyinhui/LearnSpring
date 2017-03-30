package com.springinaction.extendsinterface;

/**
 * Created by sunyinhui on 2017/3/24.
 */


public interface TestInterfaceB {
    String pub_key = "guess what the public key is";

    int minus(int x, int y);

    byte[] decryt(String src);

    int get();
}
