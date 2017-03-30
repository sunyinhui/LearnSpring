package com.springinaction.thread;

/**
 * Created by sunyinhui on 2017/3/29.
 */
public class SubClass  extends  Outer{
    class Inner {
        public Inner() {
            System.out.println("inner of subClass");
        }
    }

    SubClass.Inner sc = new SubClass().new Inner();

}

class Outer {
    Inner in;
     public Outer() {
        in = new Inner();
    }
    public class Inner{
        public Inner() {
            System.out.println("inner of Outer");
        }
    }

}
