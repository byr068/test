package com.pinduoduo;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //商品总数
        int m = in.nextInt(); //背包容量
        int[] ci = new int[n];
        int[] vi = new int[n];
        for(int i=0;i<n;i++){
            ci[i] = in.nextInt();
            vi[i] = in.nextInt();
        }
        int sum = helper(m,n,ci,vi);
        System.out.println(sum);
    }
    static int helper(int m,int n,int[] ci,int[] vi){
       int[][] v = new int[n+1][m+1];
       for(int i=1;i<n+1;i++){
           for(int j=1;j<m+1;j++){
               if(ci[i-1]>j){
                   v[i][j] = v[i-1][j];
               }else{
                   v[i][j] = Math.max(v[i-1][j],vi[i-1]+v[i-1][j-ci[i-1]]);
               }
           }
       }
       int j = m;
       String numStr = "";
       for(int i=n;i>=0;i--){
           if(v[i][j]>v[i-1][j]){
               numStr = i + ""+ numStr;
               j = j - ci[i-1];
           }
           if(j==0){
               break;
           }
           System.out.println(numStr);
       }
       return v[n][m];
    }
}
