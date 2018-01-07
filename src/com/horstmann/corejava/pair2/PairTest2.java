package com.horstmann.corejava.pair2;

import java.time.LocalDate;

public class PairTest2 {
    public static void main(String[] args){
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1926, 10, 9),
                LocalDate.of(1905, 12, 5),
                LocalDate.of(1926, 11, 9),
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min= " + mm.getFirst());
        System.out.println("max= " + mm.getSecond());
    }
}

class Pair<T>{
    private T first;
    private T second;

    public Pair(){
        first = null;
        second = null;

    }

    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    public void setFirst(T newValue){
        first = newValue;
    }

    public void setSecond(T newValue){
        second = newValue;
    }
}

class ArrayAlg{

    //泛型方法
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if(a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for(int i = 1; i < a.length; i ++){
            if(min.compareTo(a[i]) > 0) min = a[i];
            if(max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<T>(min, max);
    }
}