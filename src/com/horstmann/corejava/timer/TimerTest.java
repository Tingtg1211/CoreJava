package com.horstmann.corejava.timer;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;      //to resolve conflict with java.util.Timer

public class TimerTest {
    public static void main(String[] args){
        ActionListener listener = new TimePrinter();

        //construct a timer that calls the listener
        //once every 10 seconds
        Timer t = new Timer(3000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
    }
}


class TimePrinter implements ActionListener{
    public void actionPerformed(ActionEvent event){
        System.out.println("At the tone, the time is " + new Date());
        Toolkit.getDefaultToolkit().beep();     //获得默认的工具箱，工具箱包含有关GUI环境的信息， beep发出一声铃响
    }
}
