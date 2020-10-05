package com.com.meituan;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class laji{
    public static void main(String[] args) {
        solution s= new solution();
//        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        s.helper(arr);
        s.helper2(9);
    }

}
class solution{
    public void helper(int[][] arr){
        int row = arr.length;
        int col = arr[0].length;
        for(int i=col-1;i>=0;i--){
            int n = 0;
            int m = i;
            while(n>=0&&n<row&&m>=0&&m<col){
                System.out.println(arr[n][m]);
                n++;
                m++;
            }
        }
        for(int i=1;i<row;i++){
            int n = i;
            int m = 0;
            while(n>=0&&n<row&&m>=0&&m<col){
                System.out.println(arr[n][m]);
                n++;
                m++;
            }
        }
    }
    void helper2(int n){
        if(n<2) System.out.println("无");
        for(int i=2;i<=n;i++){
            if(isSu(i)){
                System.out.println("sushu:"+i);
            }
        }
    }
    boolean isSu(int i){
        for(int j=2;j<=(i/2);j++){
            if(i%j==0){
                return false;
            }
        }
        return true;
    }
}