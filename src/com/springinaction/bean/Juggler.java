package com.springinaction.bean;

/**
 * Created by sunyinhui on 2017/3/23.
 */

import org.springframework.context.annotation.Bean;

/**
 * 杂技师
 */
public class Juggler implements Performer {
    private int beanBags = 3;

    // 在 configbean.xml中通过constructor-arg的方式 通过构造器注入 但是此类必须要提供构造器方法
    // 除了构造器注入还可以通过工厂方法创建bean
    public Juggler(){
    }

    public Juggler(int beanBags) {
        this.beanBags = beanBags;
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Juggler:" + beanBags + ":beanBags");
    }

    /**
     * Bean注解 生成一个Bean
     * @return
     */
    @Bean
    public Performer duke() {
       return new Juggler();
    }
}
