package com.springinaction.extendsinterface;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * Created by sunyinhui on 2017/3/24.
 *
 * 接口可以继承多个接口
 */

/**
 * 在这个类中，只有一个get方法实现了，同时也没有为有多个get要实现而冲突。
 * 同时，如果删除了接口InterfaceMultiInheritance.java中的get方法，也只有一个get方法得到了实现并且没有为多个get要实现而出现什么冲突。
 *
 所以，我们可以得到一个结论，当编译器在实现接口的时候会依然检查接口InterfaceMultiInheritance.java、TestInterfaceA.java和TestInterfaceB.java中的方法声明，
 如果后两者有与前者相冲突的方法声明，编译器将只要求类实现前者的声明，而后两者中相同的方法声明将自动被忽略。而当只有后两者中有相同的方法声明时，编译器将实现其中的一个即可。
 就好像是编译器中有一个专门存储方法声明的Set一样，在有继承关系的接口中，只保存一次相同的方法声明。
 */
public class InterfaceImplementTest implements InterfaceMultiInheritance {

    @Override
    public int add(int x, int y) {
        // TODO Auto-generated method stub
        return x + y;
    }

    @Override
    public String encryt(byte[] result) {
        // TODO Auto-generated method stub
        return Base64.encode(result);
    }

    @Override
    public int minus(int x, int y) {
        // TODO Auto-generated method stub
        return x - y;
    }

    @Override
    public byte[] decryt(String src) {
        // TODO Auto-generated method stub
        try {
            return Base64.decode(src);
        } catch (Base64DecodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double divide(int x, int y) {
        // TODO Auto-generated method stub
        return x/y;
    }

    @Override
    public int get() {
        // TODO Auto-generated method stub
        return num;
    }

    public void print() {
        System.out.println("The public key is: "+pub_key+"\nThe private key is: "+pri_key);
    }

}
