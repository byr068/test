package com.com.meituan;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        rect[] re = new rect[3];
        for (int j = 0; j < 3; j++){
            int chang = in.nextInt();
            int kuan = in.nextInt();
            rect rect = new rect(chang,kuan);
            re[j] = rect;
        }
        for(int i=0;i<re.length;i++){
            System.out.println(re[i].l+"+"+re[i].r);
        }
    }
}
class rect implements Comparable<rect>{
    int l;
    int r;
    public rect(int l,int r){
        this.l= l;
        this.r =r;
    }
    @Override
    public int compareTo(rect o) {
        if(o.l>this.l){
            return 1;
        }else if(o.l==this.l){
            if(o.r>this.r){
                return 1;
            }else if(o.r==this.r){
                return 1;
            }
        }
        return -1;
    }
}