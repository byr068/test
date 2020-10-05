package com.pinduoduo;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        long n = in.nextInt();
        int m = in.nextInt();
        long res = 0;
        if(m ==1){
            int temp = in.nextInt();
            for(int i=1;i<=n;i++){
                if(i%temp==0){
                    res++;
                }
            }
            System.out.println(res);
        }else{
            int[] arr = new int[m];
            for(int i=0;i<m;i++){
                arr[i] = in.nextInt();
            }
            long sum = helper(arr,n);
            System.out.println(sum);
        }
    }
    static long helper(int[] arr,long n){
        long res = 0;
        int temp = 0;
        for(long i=1;i<n;i++){
            if(temp>=arr.length){
                break;
            }
            if(i%arr[temp]==0){
                res++;
            }
        }
        temp++;
        for(long i=1;i<n;i++){
            if(temp>=arr.length){
                break;
            }
            if(i%arr[temp]==0){
                res++;
            }
        }
        temp++;
        for(long i=1;i<n;i++){
            if(temp>=arr.length){
                break;
            }
            if(i%arr[temp]==0){
                res++;
            }
        }
        temp++;
        for(long i=1;i<n;i++){
            if(temp>=arr.length){
                break;
            }
            if(i%arr[temp]==0){
                res++;
            }
        }
        temp++;
        for(long i=1;i<n;i++){
            if(temp>=arr.length){
                break;
            }
            if(i%arr[temp]==0){
                res++;
            }
        }
        temp++;
        for(long i=1;i<n;i++){
            if(temp>=arr.length){
                break;
            }
            if(i%arr[temp]==0){
                res++;
            }
        }
        temp++;
        for(long i=1;i<n;i++){
            if(temp>=arr.length){
                break;
            }
            if(i%arr[temp]==0){
                res++;
            }
        }
        temp++;
        for(long i=1;i<n;i++){
            if(temp>=arr.length){
                break;
            }
            if(i%arr[temp]==0){
                res++;
            }
        }
        temp++;
        for(long i=1;i<n;i++){
            if(temp>=arr.length){
                break;
            }
            if(i%arr[temp]==0){
                res++;
            }
        }
        temp++;
        return res;
    }
}
