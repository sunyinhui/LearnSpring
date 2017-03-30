package com.springinaction.extendsinterface;

/**
 * Created by sunyinhui on 2017/3/24.
 */
public interface InterfaceMultiInheritance  extends  TestInterfaceA, TestInterfaceB{
    int num = 1024;

    double divide(int x, int y);

    int get();
}
