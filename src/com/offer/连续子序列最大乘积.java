package com.offer;

import java.util.Arrays;

public class 连续子序列最大乘积 {
    public static void main(String[] args) {
        int[] arr = {-2,-1,-3};
        int res = maxProduct(arr);
        System.out.println(res);
    }
    static int maxProduct(int[] arr){
        if(arr==null||arr.length==0)return 0;
        int max = 1;
        int min = 1;
        int maxTemp = max;
        int minTemp = min;
        int res = 0;
        for(int i=0;i<arr.length;i++){
            //最大乘积应该是三种情况
            //都是正数，有负数，奇数个或者偶数个
            //维护一个最大值和最小值，如果下一个数是负数，有可能负负为正，则是最大值
            maxTemp = Math.max(arr[i],Math.max(max*arr[i],min*arr[i]));
            minTemp = Math.min(arr[i],Math.min(max*arr[i],min*arr[i]));
            max = maxTemp;
            min = minTemp;
            res = Math.max(res,max);

        }
        return res;
    }
}
