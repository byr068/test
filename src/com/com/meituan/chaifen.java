package com.com.meituan;

import java.util.Scanner;

public class chaifen {
    /**
     * 给定长度为n的串S，仅包含小写字母。定义
     *
     * 公式中，|A|代表字符串A的长度
     *
     * 也就是说如果子串是一个ABA型的字符串，且满足长度限制，则f(l,r)=1，否则等于0。（注意：形如“ababab”也可视为ABA型）
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        System.out.println(s+k);
    }
}
