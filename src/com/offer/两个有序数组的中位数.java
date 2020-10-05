package com.offer;

public class 两个有序数组的中位数 {
    public  static int getUpMedian(int[] arr1 , int[] arr2){

        if(arr1==null || arr2==null || arr1.length != arr2.length){
            throw new RuntimeException("hi,babay.are you ok?");
        }
        int start1 =0;
        int end1 = arr1.length-1;

        int start2=0;
        int end2 = arr2.length-1;

        int mid1 =0;
        int mid2 =0;

        int offset = 0;

        while(start1 < end1){

            mid1 = (start1+end1)/2;
            mid2 = (start2+end2)/2;

            //元素个数如果是奇数为0 偶数为1
            offset = ((end1 - start1+1)&1)^1;

            if(arr1[mid1] > arr2[mid2]){
                end1 = mid1;
                start2=mid2+offset;
            }else if(arr1[mid1]<arr2[mid2]){
                start1 = mid1 + offset;
                end2 = mid2;

            }else {
                return arr1[mid1];
            }
        }
        return Math.min(arr1[start1], arr2[start2]);
    }

    public static void main(String[] args){
        int[] a1 = new int[4];
        int[] a2 = new int[4];
        a1[0]=0;  a1[1]=1;  a1[2]=2; a1[3]=3;
        a2[0]=4;  a2[1]=5;  a2[2]=5; a2[3]=6;
        int c = getUpMedian(a1,a2);
        System.out.println(c);
    }
}
