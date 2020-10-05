package com.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =in.nextInt();
        int m =in.nextInt();
        int result = 0;
        boolean flag = false;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            int len = in.nextInt();
            int[] arr = new int[len];
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<len;j++){
                int temp  = in.nextInt();
                list.add(temp);
                if(arr[j]==0){
                    flag = true;
                }
            }
        }
        if(!flag){
            System.out.println(result);
        }
        if(flag){
        }
    }
}
