package com.itcast.homework_15;

public class StringTest2 {
    public static void main(String[] args){
        String str = "  abcWE123  ";
        System.out.println(str.isEmpty());
        System.out.println(str.charAt(1));
        System.out.println(str.toUpperCase());
        System.out.println(str.replace('a', 'A'));
        System.out.println(str.replace("abc", "WER"));
        System.out.println(str.trim());
        System.out.println(getPropertyGetMethodName("123"));
    }


    /*
     * (1)定义如下方法public static String getPropertyGetMethodName(String property);
     * (2)该方法的参数为String类型，表示用户给定的成员变量的名字，返回值类型为String类型，返回值为成员变量对应的get方法的名字
     * (3)如：用户调用此方法时给定的参数为"name",该方法的返回值为"getName"
     */


    public static String getPropertyGetMethodName(String property){
        return "get" + property;
    }
}
