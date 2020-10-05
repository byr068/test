package com.aiqiyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int res = helper(str);
        System.out.println(res);
    }
    public static int helper(String str){
        int len = str.length();
        int res =0;
        int start = 0,end = 0;
        Set<Character> set =new HashSet<>();
        while(start<len && end<len){
            if(set.contains(str.charAt(end))){
                set.remove(str.charAt(start++));
            }else{
                set.add(str.charAt(end++));
                res = Math.max(res,end-start);
            }
        }
        return res;
    }
}
