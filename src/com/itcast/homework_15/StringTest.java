package com.itcast.homework_15;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class StringTest {
    public static void main(String[] args){
        getCount("abcAB12");
        convert("aBC");
        getString("hellojava,nijavahaojava,javazhenbang", "java");

    }

    public static void getCount(String str){
        int number = 0;
        int upper = 0;
        int lower = 0;
        for(int i = 0; i < str.length(); i ++){
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'Z'){
                upper ++;
            }else if(c >= 'a' && c <= 'z'){
                lower ++;
            }else if(c >= 48 && c <= 57){
                number ++;
            }
        }
        System.out.println("number" + number);
        System.out.println("upper" + upper);
        System.out.println("lower" + lower);
    }

    public static void convert(String str){
        String first = str.substring(0, 1);
                first = first.toUpperCase();
        String after = str.substring(1);
        after = after.toLowerCase();
        System.out.println("str: " + first + after);

    }

    public static void getString(String str, String key){
        int count = 0;
        int index = 0;
        while((index = str.indexOf(key)) != -1){
            count ++;
            str = str.substring(index + key.length());
        }
        System.out.println(count);
    }
}
