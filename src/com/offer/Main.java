package com.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        String str = in.nextLine();
        List<Integer> res =new ArrayList<>();
        String year = "";
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                year = year +c;
            }else{
                isYear(year,res);
                year = "";
            }
        }
        for(Integer n:res){
            System.out.println(n+" ");
        }
    }
    static void isYear(String year, List<Integer> res){
        int sum = 0;
        for(int i=0;i<year.length();i++){
            char c =year.charAt(i);
            if(!Character.isDigit(c)){
                return;
            }
            sum = sum*10 + (c-'0');
        }
        if(sum>=1000 && sum<=3999){
            res.add(sum);
        }
    }
}
