package com.offer;

import java.util.Arrays;

public class 打家劫舍II {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        System.out.println(rob(arr));
    }
    public static int rob(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        if(nums.length==1)return nums[0];
        int temp1 = helper(Arrays.copyOfRange(nums,0,nums.length-1),0,nums.length-1);
        int temp2 = helper(Arrays.copyOfRange(nums,1,nums.length),0,nums.length-1);
        return Math.max(temp1,temp2);
    }
    static int helper(int[] arr,int l,int r){
        int[] dp = new int[arr.length];
        dp[0] = arr[l];
        dp[1] = Math.max(arr[l],arr[l+1]);
        for(int i=l+2;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]);
        }
        return dp[r-1];
    }
}
