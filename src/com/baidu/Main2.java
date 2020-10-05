package com.baidu;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = in.nextInt(); //牛的数量
        int m = in.nextInt(); // 特性数量
        int[] arr1 = new int[m];
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            arr1[i] = in.nextInt();
            for(int j=0;j<arr1[i];j++){
                int begin = in.nextInt();
                int end = in.nextInt();
                for(int g=begin;g<=end;g++){
                    if(map.containsKey(g)){
                        int temp = map.get(g);
                        if(temp>=m){
                            sum++;
                            list.add(g);
                        }
                        map.put(g,temp+1);
                        continue;
                    }else{
                        map.put(g,1);
                        continue;
                    }

                }
            }
        }
        System.out.println(sum);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        System.out.println(Arrays.toString(res));
    }
}
