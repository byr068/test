package com.alibaba;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static int a[]=new int[10];
    static int b[]=new int [10];
    static boolean vis[]=new boolean[10];
    static void dfs(int step,int n){
        if(step==n){
            for(int i=0;i<n;i++) System.out.println((b[i]));
            System.out.println();
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                vis[i]=true;
                b[step]=a[i];
                dfs(step+1,n);
                vis[i]=false;
                while(a[i]==a[i+1]) i++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new  Scanner(System.in);
        String s=in.next();
        for(int i=0;i<s.length();i++) a[i]=s.charAt(i)-'0';
        Arrays.sort(a,0,s.length());
        dfs(0,s.length());
        in.close();
    }
}
