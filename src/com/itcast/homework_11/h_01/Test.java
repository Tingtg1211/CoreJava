package com.itcast.homework_11.h_01;

public class Test {
    public static void main(String[] args){
        Animal aa = new Dog();
        Test.function(aa);
        Animal bb = new Cat();
        Test.function(bb);


    }

    public static void function(Animal a){
        a.eat();
        if(a instanceof Dog){
            ((Dog) a).keepHome();
        }
        if(a instanceof Cat){
            ((Cat) a).catchMouse();
        }

    }
}
