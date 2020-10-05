package com.jinshanyun;

import java.util.Scanner;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        for(int i=1;i<=n;i++){
            int[] arr = fib(i);
            Stack<Integer> s1 = new Stack<>();
            if(i==1){
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr[j]+" ");
                }
            }else if(i>1){
                for(int j=0;j<arr.length-1;j++){
                    s1.push(arr[j]);
                }
                for(int j=0;j<arr.length;j++){
                    System.out.print(arr[j]+" ");
                }
                while(!s1.isEmpty()){
                    System.out.print(s1.pop());
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
        }
    }
    static int[] fib(int n){
        int[] arr = new int[n];
        arr[0] = 1;
        if(n==1){
            return arr;
        }
        arr[1] = 1;
        for(int i=0;i<arr.length;i++){
            if(i>1){
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        return arr;
    }
}
