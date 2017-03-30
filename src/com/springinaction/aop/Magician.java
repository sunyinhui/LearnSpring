package com.springinaction.aop;

/**
 * Created by sunyinhui on 2017/3/24.
 * 魔术师 会读心术
 */
public class Magician implements MindReader {
    private String thoughts;
    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("InterceptThoughts volunteer's thoughts: " + thoughts);
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
