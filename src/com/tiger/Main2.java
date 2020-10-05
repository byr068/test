package com.tiger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            list.add(a);
        }
        int size = list.size();
        if(size==0){
            System.out.println(0);
        }
        int[] res = new int[size-1];
        int target = target = list.get(size-1);
        for(int i=0;i<size-1;i++){
            res[i] = list.get(i);
        }
        Solution s = new Solution();
        s.combinationSum(res,target);
    }
}
class Solution {
    /**
     * 合适的股票每手价格组合
     * @param prices int整型一维数组 股票数量
     * @param m int整型 资产值
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> combinationSum (int[] prices, int m) {
        // write code here
        if(prices==null||prices.length==0)return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(prices);
        dfs(prices,res,new ArrayList<>(),m,0);
        return res;
    }
    public void dfs(int[] prices,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int m,int index){
        if(m==0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<prices.length&&m>=prices[i];i++){
            list.add(prices[i]);
            dfs(prices,res,list,m-prices[i],i+1);
            list.remove(list.size()-1);
        }
    }
}