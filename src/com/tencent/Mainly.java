package com.tencent;

import java.util.*;

public class Mainly {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            int temp = in.nextInt();
            list.add(temp);
        }
//        while(list.size()>0){
//            int temp = helper(list);
//            System.out.println(temp+1);
//            list.remove(index);
//            index++;
//        }
        for(int i=0;i<n;i++){
            int temp = helper(list);
            System.out.println(temp+1);
            list.remove(0);
        }
    }
    static int helper(List<Integer> list){
        int j = 0;
        Collections.sort(list);
        int size = list.size();
        if(size %2 == 1){
            j = list.get((size-1)/2);
        }else{
            j = (list.get(size/2-1)+list.get(size/2+0))/2;
        }
        return j;
    }
}
