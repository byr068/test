package com.offer;

public class 最大公约数 {
    public static void main(String[] args) {
        System.out.println(GCD(2,3));
    }
    public static int GCD(int m, int n) {
        int result = 0;
        while (n != 0) {
            result = m % n;
            m = n;
            n = result;
        }
        return m;
    }

}
