package com.springinaction.aspect;


/**
 * Created by sunyinhui on 2017/3/24.
 */

public aspect JudgeAspect {
    public JudgeAspect() {
    }

    pointcut performer() : execution(* perform(..));

    after() returning() : performer() {
        System.out.println("cirticismEngine");
    }


}
