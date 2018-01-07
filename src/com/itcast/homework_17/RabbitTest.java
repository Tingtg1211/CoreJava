package com.itcast.homework_17;

public class RabbitTest {
    public static void main(String[] args){
            //test();
        System.out.println(fun(12));
    }

    public static void test(){
        int[] arr = new int[12];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < arr.length; i ++){
            arr[i] = arr[i - 1] + arr[i - 2];

        }
        System.out.println(arr[arr.length - 1]);
    }

    public static int fun(int num){
        if(num == 1 || num == 2){
            return 1;
        }else {
            return fun(num - 1) + fun(num - 2);
        }


    }
}
