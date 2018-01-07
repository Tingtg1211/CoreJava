package com.itcast.homework_11.h_01.h_02;

public class Test {
    public static void main(String[] args){
        Phone p = new OldPhone();
        p.call();
        p.message();
        p = new NewPhone();
        p.call();
        p.message();
        IPlay I = new NewPhone();
        I.playgame();
        //p.playgame();
    }
}
