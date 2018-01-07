package com.itcast.homework_13;

public class TestPhone {
    public static void main(String[] args){
        PlayGames P = new PlayGames(){
            public void play(){
                System.out.println("PLAY");
            }
        };

        P.play();
    }
}
