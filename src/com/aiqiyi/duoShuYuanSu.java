package com.aiqiyi;

import java.util.*;

public class duoShuYuanSu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String[] str = s.split(" ");
        int len = str.length;
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = Integer.valueOf(str[i]);
        }
        System.out.println(helper(arr));
    }
    static int helper(int[] nums){
        double n = Math.ceil(nums.length/2.0);
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.get(nums)==null){
                map.put(num,1);
            }else{
                map.put(num,map.get(num)+1);
            }
        }
        for(Integer key:map.keySet()){
            if(map.get(key) >= n){
                res = key;
                break;
            }
        }
        return res;
    }
}
