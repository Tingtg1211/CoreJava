package com.itcast.homework_13;

public class NewPhone extends Phone implements PlayGames {
    public void call(){
        System.out.println("NewPhone call");

    }

    public void sendMessage(){
        System.out.println("NewPhone sendMessage");
    }


        public void play(){
            System.out.println("NewPhone play");
        }


}
