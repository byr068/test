package com.offer;

import java.util.Arrays;

public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,3,6,4,8,9,7};
        System.out.println(Arrays.toString(LIS(arr)));
        System.out.println(lengthOfLIS(arr));
    }
    public static int[] LIS (int[] arr) {
        if(arr == null || arr.length <= 0){
            return null;
        }
        int len = arr.length;
        int[] count = new int[len];             // 存长度
        int[] end = new int[len];               // 存最长递增子序列
        //init
        int index = 0;                          // end 数组下标
        end[index] = arr[0];
        count[0] = 1;
        for(int i = 0; i < len; i++){
            if(end[index] < arr[i]){
                index++;
                end[index] = arr[i];
                count[i] = index;
            }
            else{
                int left = 0, right = index;
                while(left <= right){
                    int mid = (left + right) >> 1;
                    if(end[mid] >= arr[i]){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
                end[left] = arr[i];
                count[i] = left;
            }
        }
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(end));
        System.out.println(index);
        //因为返回的数组要求是字典序，所以从后向前遍历
        int[] res = new int[index + 1];
        for(int i = len - 1; i >= 0; i--){
            if(count[i] == index){
                System.out.println("第"+index+"位置为："+arr[i]);
                res[index--] = arr[i];
            }
        }
        return res;
    }

    public static int lengthOfLIS(int[] arr){
        int len = arr.length;
        int[] tail = new int[len]; //长度为i+1的子序列最小结尾
        int index = 0;
        tail[0] = arr[0];
        for(int i=1;i<len;i++){
            if(tail[index]<arr[i]){
                index++;
                tail[index] = arr[i];
            }else{
                //找到第一个大于nums[i]的元素，尝试让他变得更小
                int l = 0;
                int r = index;
                while(l<r){
                    int mid = (r-l)/2+l;
                    if(tail[mid]<arr[i]){
                        l = mid + 1;
                    }else{
                        r = mid;
                    }
                }
                //一定找到第一个大于等于nums[i]的元素
                tail[l] = arr[i];
            }
        }
        System.out.println(Arrays.toString(tail));
        index++;
        return index;
    }
}
