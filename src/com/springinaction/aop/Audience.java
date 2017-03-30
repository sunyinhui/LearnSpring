package com.springinaction.aop;

import org.springframework.stereotype.Component;

/**
 * Created by sunyinhui on 2017/3/24.
 * 观众
 */
@Component
public class Audience {
    public void takeSeats() {
        System.out.println("The audience is taking their seats");
    }
    public void turnOffCellPhone() {
        System.out.println("The audience is turning off their cellphone");
    }

    public void applaud() {
        System.out.println("CLAP CLAP CLAP");
    }

    public void demanRefund() {
        System.out.println("Boo we want our money back");
    }
}
