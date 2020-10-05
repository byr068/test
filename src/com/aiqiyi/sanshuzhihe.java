package com.aiqiyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class sanshuzhihe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        if(s==null||s.length()==0){
            System.out.println(0);
        }else{
            String[] str = s.split(" ");
            int len = str.length;
            int[] arr = new int[len];
            for(int i=0;i<len;i++){
                arr[i] = Integer.valueOf(str[i]);
            }
            List<List<Integer>> res = threeSum(arr);
            if(res==null){
                System.out.println(0);
            }else{
                for(List<Integer> r :res){
                    for(int i=0;i<r.size();i++){
                        System.out.print(r.get(i)+" ");
                    }
                    System.out.println(" ");
                }
            }
        }
    }
    static List<List<Integer>> threeSum(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        int len = arr.length;
        if(arr==null||arr.length==0){
            return res;
        }
        Arrays.sort(arr);
        for(int i=0;i<len;i++){
            if(arr[i]>0)break;
            if(i>0&&arr[i]==arr[i-1])continue;
            int m = i+1;
            int n = len -1;
            while(m<n){
                int sum = arr[i] + arr[m] + arr[n];
                if(sum == 0){
                    res.add(Arrays.asList(arr[i],arr[m],arr[n]));
                    while(m<n&&arr[m]==arr[m+1])m++;
                    while(m<n&&arr[n]==arr[n-1])n--;
                    m++;
                    n--;
                }else if(sum<0)m++;
                else if(sum>0)n--;
            }
        }
        return res;
    }
}
