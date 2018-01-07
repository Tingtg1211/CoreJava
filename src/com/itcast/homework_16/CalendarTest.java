package com.itcast.homework_16;

import java.util.Calendar;

public class CalendarTest {
    public static void  main(String[] args){
        Calendar my = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        //设置年月日 2020-01-01
        my.set(Calendar.YEAR, 2020);
        my.set(Calendar.MONTH, 0);
        my.set(Calendar.DATE, 1);
        //获取时间中的天数
        int day = c.get(Calendar.DATE);
        int myDay = my.get(Calendar.DATE);
        System.out.println(myDay - day);

    }
}
