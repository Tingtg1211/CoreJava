package com.itcast.homework_10.h_02;

public class Test {
    public static void main(String[] args){
        SEteacher s = new SEteacher();
        s.setName("zhangsi");
        s.teach();
        ANteacher a = new ANteacher();
        a.setName("lisi");
        a.teach();
    }
}
