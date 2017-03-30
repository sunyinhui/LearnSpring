package com.springinaction.aop;

import org.springframework.stereotype.Component;

/**
 * Created by sunyinhui on 2017/3/24.
 *
 */
public class Volunteer implements Thinker {
    public Volunteer() {

    }
    private String thoughts;
    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts() {
        return thoughts;
    }
}
