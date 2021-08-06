package com.example.algorithm;

public class Log {
    public static void i(String msg){
        System.out.println(msg);
    }

    public static void i(String msg,Object ...format){
        System.out.println(String.format(msg,format));
    }
}
