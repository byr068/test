package com.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); //n行
        int m = in.nextInt(); //m列
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = in.nextInt();
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        int sum = countIsland(arr);
        System.out.println(sum);
    }
    static int countIsland(int[][] arr){
        if(arr==null||arr[0] ==null)return 0;
        int row = arr.length;
        int col = arr[0].length;
        int res = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]==1){
                    res++;
                    helper(arr,i,j,row,col);
                }
            }
        }
        return res;
    }
    static void helper(int[][] m,int i,int j,int row,int col){
        if(i<0||i>=row||j<0||j>=col||m[i][j]!=1){
            return;
        }
        m[i][j] = 2;
        helper(m,i+1,j,row,col);
        helper(m,i-1,j,row,col);
        helper(m,j+1,j,row,col);
        helper(m,j-1,j,row,col);
    }
}
