package com.CrazyJava.CollectionTest;

import java.util.HashSet;



    //类A的equals()方法总是返回true,没有重写其hashCode()方法
    class A{
        public boolean equals(Object obj){
            return true;
        }

    }


    //类B的hashCode()方法总是返回1，没有重写equals()方法
    class B{
        public int hashCode(){
            return 1;
        }
    }

    class C{
        public int hashCode(){
            return 2;
        }


        public boolean equals(Object obj){
            return true;
        }
    }


public class HashSetTest{
    public static void main(String[] args){
        HashSet books = new HashSet();
        books.add(new A());
        books.add(new A());
        books.add(new B());
        books.add(new B());
        books.add(new C());
        books.add(new C());
        System.out.println(books);
    }
}
