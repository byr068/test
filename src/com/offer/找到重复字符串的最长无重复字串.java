package com.offer;

import java.util.HashMap;
import java.util.Map;

public class 找到重复字符串的最长无重复字串 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,4,2,2};
        System.out.println(maxLength1(arr));
    }
    public static int maxLength(int[] arr){
        int[] lastPos = new int[100000];
        int len = arr.length;
        int start = 0;
        int res = 0;
        for(int i=0;i<len;i++){
            //当重复字符的上一次位置在start之前，取start
            //当重复字符的上一次位置在start位置或之后，取重复字符的上一次位置的后一次位置
            //无重复字符则继续
            int now = arr[i];
            start = Math.max(start,lastPos[now]);
            res = Math.max(res,i-start+1);
            lastPos[now] = i + 1;
        }
        return res;
    }
    public static int maxLength1(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.clear();
                map.put(arr[i],i);
                index = map.get(arr[i]);
            }else{
                map.put(arr[i],i);
            }
            max = Math.max(max,i-index+1);
        }
        return max;
    }
}
