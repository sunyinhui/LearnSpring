package com.springinaction.aop;

/**
 * Created by sunyinhui on 2017/3/24.
 * 读心者
 *       截听志愿者的内心感应和显示他们在想什么
 */
public interface MindReader {
    void interceptThoughts(String thoughts);
    String getThoughts();
}
