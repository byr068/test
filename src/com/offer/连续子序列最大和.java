package com.offer;

import java.util.Arrays;

public class 连续子序列最大和 {
    public static void main(String[] args) {
        int[] arr = {1,2,3-4,5,0,-3};
        int res = maxSum(arr);
        int[] res2 = maxSumOfSubArray(arr);
        System.out.println(Arrays.toString(res2));
        System.out.println(res);
    }
    static int maxSum(int[] arr){
        if(arr==null||arr.length==0)return 0;
        int max = arr[0];
        int temp = arr[0];
        for(int i=1;i<arr.length;i++){
            temp = Math.max(temp+arr[i],arr[i]);
            max = Math.max(max,temp);
        }
        return max;
    }

    /**
     *  子序和及其下标
     * @param nums
     * @return
     */
    public static int[] maxSumOfSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        // 1. 更新最大值时，需记录开始下标
        int max = Integer.MIN_VALUE, start = 0 , end = 0, cur = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            if (cur <= 0) {
                cur = nums[i];
                j = i;
            } else {
                cur += nums[i];
            }
            if (cur > max) {
                max = cur;
                start = j;
                end = i;
            }
        }
        return new int[]{start, end};
    }
}
