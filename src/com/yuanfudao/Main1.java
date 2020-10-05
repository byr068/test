package com.yuanfudao;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        String[] strs = new String[sum];
        for(int i=0;i<sum;i++){
            strs[i] = in.next();
        }
        for(int i=0;i<sum;i++){
           String[] temp = strs[i].split(" ");
           char[] res = temp.toString().toCharArray();
           int len = res.length;
           if(len<5) {
               System.out.println("invalid");
               continue;
           }
           if(res[0]!='('&&res[len-1]!=')'){
               System.out.println("invalid");
               continue;
           }
           if(res[1]!='+'&&res[1]!='-'){
               System.out.println("invalid");
               continue;
           }
        }
    }
}
