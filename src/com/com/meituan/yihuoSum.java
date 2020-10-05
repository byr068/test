package com.com.meituan;

import java.util.Scanner;

public class yihuoSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        int sum = 0;
        if(n%2==1){
            sum = 0;
        }else{
            for(int i=0;i<n-1;i++){
                    sum ^= arr[i];
                    System.out.println("i:"+sum);
                }
            }
        System.out.println(sum);
    }
}
