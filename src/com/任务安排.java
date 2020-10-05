package com;

import java.util.*;

public class 任务安排 {
    static int maxValue = 0;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int endTime = in.nextInt();
        int taskNum = in.nextInt();
        int[][] arr = new int[taskNum][4];
        for(int i=0;i<taskNum;i++){
            for(int j=0;j<4;j++){
                arr[i][j] = in.nextInt();
            }
        }
        Arrays.sort(arr,(o1,o2)->o1[2]==o2[2]?o1[3]-o2[3]:o1[2]-o2[2]);
        for(int i=0;i<arr.length;i++){
            System.out.println("排序后二维数组："+Arrays.toString(arr[i]));
        }

        List<Integer> res = helper(arr,endTime);
        System.out.println("最大利润为"+maxValue);
        if(res==null){
            System.out.println(0);
        }else{
            System.out.println("方案总数为"+res.size());
            for(int i=0;i<res.size();i++){
                System.out.println("方案编号为："+res.get(i));
            }
        }
    }
    static List<Integer> helper(int[][] arr, int endTime){
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int temp = arr[i][3] + arr[i][2];
            if(temp>endTime){
                continue;
            }
            list.add(i);
        }
        if(list==null)return null;
       List<Integer> res = new ArrayList<>();
        int index = 0;
        //左右区间
        for(int i=1;i<list.size();i++){
            int left = arr[list.get(index)][2];
            int r = arr[list.get(index)][3];
            if(left==arr[list.get(i)][2]){
                if(arr[index][1]>arr[list.get(i)][1]){
                    maxValue += arr[index][1];
                    res.add(i);
                }else{
                    maxValue += arr[list.get(i)][1];
                    index = list.get(i);
                    res.add(i);
                }
            }else if(r<arr[list.get(i)][2]){
                maxValue += arr[list.get(i)][1];
                index = list.get(i);
                res.add(i);
            }
        }
        return res;
    }
}
