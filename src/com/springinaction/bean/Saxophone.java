package com.springinaction.bean;

/**
 * Created by sunyinhui on 2017/3/23.
 */

/**
 *萨克斯乐器
 */
public class Saxophone implements Instrument{
    public Saxophone(){

    }
    @Override
    public void play() {
        System.out.println("萨克斯乐器：TOOT TOOT TOOT");
    }
}
