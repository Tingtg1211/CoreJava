package com.itcast.homework_10.h_02;

public class ANteacher extends Teacher {
    @Override
    public void teach() {
        System.out.println(super.getName() + "\t" + "teach Andriod");
    }
}
