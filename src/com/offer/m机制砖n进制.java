package com.offer;

import java.util.Stack;

public class m机制砖n进制 {
    public static void main(String[] args) {
        System.out.println(helper(100,5));
    }
    static String helper(int m,int n){
        Stack<Integer> s1 =new Stack<>();
        while(m!=0){
            int temp = m%n;
            s1.add(temp);
            m /= n;
        }
        String str= "";
        while(!s1.isEmpty()){
            str += String.valueOf(s1.pop());
        }
        return str;
    }
}
