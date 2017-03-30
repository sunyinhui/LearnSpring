package com.springinaction.aspect;

/**
 * Created by sunyinhui on 2017/3/24.
 */

import org.aspectj.lang.annotation.*;

/**
 * 使用注解来创建切面时AspectJ所引入的关键特性
 *
 * 通过AspeectJ注解我们重新来看Audience类，使其不需要任何额外的类或Bean声明就能将他装换为一个切面,省去了在xml中配置切面
 *
 *
 */
@Aspect
public class Audience {
    // 定义切点
    @Pointcut("execution(* com.springinaction.bean.Instrument.play(..))")
    public void play(){

    }

    @Before("play()")
    public void takeSeats() {
        System.out.println("The audience is talking their seats");
    }

    @Before("play()")
    public void turnOffCellPhone() {
        System.out.println("turn off their cellphone");
    }

    @AfterReturning("play()")
    public void applaud() {
        System.out.println("clap clap ....");
    }
    @AfterThrowing("play()")
    public void demandRefund() {
        System.out.println("boo back our money");
    }
}
