package com.springinaction.config;

import org.springframework.context.annotation.Configuration;

/**
 * Created by sunyinhui on 2017/3/24.
 *
 * 在基于Java的配置里使用@Configuration注解的Java类，就等价于XML配置中的<beans>元素
 * @Configuration 将会作为一个标识告知Spring: 这个类将包含一个或多个Spring Bean定义。
 * 这些Bean 定义是使用@Bean注解所标注的方法。
 *
 */

@Configuration
public class SpringIdolConfig {
}
