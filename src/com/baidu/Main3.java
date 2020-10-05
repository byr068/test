package com.baidu;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if(n==0){
            System.out.println(0);
        }
        System.out.println(helper(n,m));
    }
    static int helper(int n,int m){
        int sum = 0;
        if(n==0){
            return 1;
        }
        if(n>=m){
            for(int i=1;i<=m;i++){
                sum += helper(n-i,m);
            }
        }else{
            sum = helper(n,n);
        }
        return sum;
    }
}
