package com.baidu;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cap = in.nextInt();
        System.out.println(cap);
        int res = (int)(cap/0.75f);
        System.out.println(res);
    }
}
