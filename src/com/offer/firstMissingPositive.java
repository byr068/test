package com.offer;

import java.util.Arrays;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 */
public class firstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {1,2,0,3};
        System.out.println(firstMissingPositive(arr));;
    }
    public static int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0)return 1;
        int len = nums.length;
        for(int i=0;i<len;i++){
            while(nums[i]>0 && nums[i]<=len && nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        System.out.println(Arrays.toString(nums));
        int i = 0;
        for (; i < len; i++) {
            if(nums[i] != i+1){
                break;
            }
        }
        return i+1;
    }
    private static void swap(int[] nums,int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
