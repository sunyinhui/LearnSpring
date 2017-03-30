package com.springinaction.loopup;

/**
 * Created by sunyinhui on 2017/3/27.
 */
public abstract class GetBeanTest {

    public void showMe() {
        this.getBean().showMe();
    }

    public abstract User getBean();
}
