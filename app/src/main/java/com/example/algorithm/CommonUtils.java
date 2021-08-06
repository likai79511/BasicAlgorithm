package com.example.algorithm;

public class CommonUtils {

    public static class Singleton {
        public final static CommonUtils instance = new CommonUtils();
    }

    private CommonUtils(){}

    public <E> String toArrayStr(E[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i != array.length-1){
                sb.append(i+",");
            }else{
                sb.append(i);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
