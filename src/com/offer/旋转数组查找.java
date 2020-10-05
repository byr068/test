package com.offer;

public class 旋转数组查找 {
    public static void main(String[] args) {
        int[] arr = new int[]{6,7,8,9,1,2,3};
        int res = search(arr,8);
        System.out.println(res);
    }
    static int search(int[] arr,int tar){
        int len = arr.length;
        int l = 0;
        int r = len -1;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[l]==tar){
                return l;
            }
            if(arr[r]==tar)return r;
            if(tar==arr[mid])return mid;
            if(arr[mid]<arr[r]){
                if(arr[mid]<tar&&tar<arr[r]){
                    l = mid+1;
                }else{
                    r = mid;
                }
            }else if(arr[mid]>arr[r]){
                if(arr[mid]>tar||tar<arr[r]){
                    r = mid+1;
                }else{
                    l = mid;
                }
            }else{
                r--;
            }
        }
        return -1;
    }
}
