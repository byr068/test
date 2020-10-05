package com.baidu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = 0;
        int b = 0;
        for(int i=0;i<n;i++){
            int temp = in.nextInt();
            if(temp==0){
                a++;
            }
            if(temp==5){
                b++;
            }
        }
        if(a==0){
            System.out.println(-1);
        }
        helper(a,b);
    }
    static void helper(int a,int b){
        for(int i=0;i<b/9;i++){
            System.out.print("555555555");
        }
        if(b/9==0){
            for(int i=0;i<a;i++){
                System.out.print("0");
            }
            System.out.printf("\n");
        }else{
            System.out.println(0);
        }
    }
}
