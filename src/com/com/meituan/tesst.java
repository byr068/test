package com.com.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null||candidates.length==0)return res;
        Arrays.sort(candidates);
        helper(candidates,target,new ArrayList<>(),0);
        return res;
    }
    public static void helper(int[] candidates, int target,List<Integer> list,int index){
        if(target<=0){
            if(target == 0){
                res.add(new ArrayList<>(list));
            }
            return ;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index&&candidates[i]==candidates[i-1]){return;}
            list.add(candidates[i]);
            helper(candidates,target-candidates[i],list,index+1);
            list.remove(list.size()-1);
        }
    }
    static  int[] arr = {10,1,2,7,6,1,5};
    public static void main(String[]args){
        combinationSum2(arr,8);
    }
}




