package com.itcast.homework_16;

public class RegexDemo {
    public static void main(String[] args){
       System.out.println(checkTel());
        System.out.println(checkQQ());
        split_3();
    }

    public static boolean checkTel(){
        String tel = "18806130512";
        String regex = "1[1378][\\d]{9}";
         return tel.matches(regex);
    }

    public static boolean checkQQ(){
        String QQ = "514545287";
        String regex = "[1-9][\\d]{5,11}";
        return QQ.matches(regex);
    }

    public static void split_1(){
        String str = "1-2-3-2-2-8-8";
        String[] strArr = str.split("-");
        System.out.println("数组的长度" + strArr.length);
        for (int i = 0; i < strArr.length; i ++)
            System.out.println(strArr[i]);

    }

    public static void split_2(){
        String str = "1  2  3 4 q 2       3";
        String[] strArr = str.split(" +");
        System.out.println("数组的长度" + strArr.length);
        for (int i = 0; i < strArr.length; i ++)
            System.out.println(strArr[i]);
    }

    public static void split_3(){
        String ip = "192.168.105.27";
        String[] strArr = ip.split("\\.");
        System.out.println("数组的长度"+strArr.length);
        for(int i = 0 ; i < strArr.length ; i++){
            System.out.println(strArr[i]);
        }
    }


}
