package com.project.test;

public class Test extends AbstarctTest{

    protected boolean auth() {

        System.out.println("复写父类方法不验证");
        return true;
    }
}
