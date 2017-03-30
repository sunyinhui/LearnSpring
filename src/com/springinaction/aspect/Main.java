package com.springinaction.aspect;

import com.springinaction.bean.Instrument;
import com.springinaction.bean.PerformanceException;
import com.springinaction.bean.Performer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sunyinhui on 2017/3/24.
 */
public class Main {
    public static void main(String[] args) throws PerformanceException {
        ApplicationContext context = new ClassPathXmlApplicationContext("configbean.xml");

        Instrument guitar = (Instrument) context.getBean("guitar");
        guitar.play();

    }
}
