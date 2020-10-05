package com.company;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

public class shiyan {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,8};
        System.out.println("cnm");
        int a = binarySearch(arr,7,0,arr.length-1);
        System.out.println(a);
        Queue<String> q1= new LinkedList<>();
    }

    /**
     * 求取两数之间的最大公约数
     *
     * @return 最大公约数
     */
    public static int binarySearch(int[] arr,int n,int l,int r){
//        if(l>r||n<arr[l]||n>arr[r])return -1;
//        int mid = (l+r)/2;
//        if(arr[mid]>n)return binarySearch(arr,n,l,mid-1);
//        else if(arr[mid]<n){
//            return binarySearch(arr,n,mid+1,r);
//        }else{
//            return mid;
//        }
        int mid = (l+r)/2;
        while(l<r){
            if(arr[mid]>n)return binarySearch(arr,n,l,mid-1);
        else if(arr[mid]<n){
            return binarySearch(arr,n,mid+1,r);
        }else{
            return mid;
        }
        }
        return -1;
    }
}
