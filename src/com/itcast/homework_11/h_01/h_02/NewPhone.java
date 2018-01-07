package com.itcast.homework_11.h_01.h_02;



public class NewPhone extends Phone implements IPlay {
    public void call(){
        System.out.println("newphone call");
    }
    public void message(){
        System.out.println("newphone message");
    }
    public void playgame(){
        System.out.println("newphone playgame");
    }
}
