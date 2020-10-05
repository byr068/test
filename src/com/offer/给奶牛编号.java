package com.offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 把奶牛所希望的编号排个序，然后就是乘法原理了。 比如 4 3 9 6， 排序为3 4 6 9。第一个奶牛有3种取法，
 * 第二只奶牛有(4-1)种取法，第三头奶油有(6-2)种取法，第四匹奶牛就有9-3种取法。
 * import java.util.*;
 */
public class 给奶牛编号 {
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i != n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        long ans = 1;
        for (int i = 0; i != n; i++) {
            ans *= ((nums[i] - i) % MOD);
            ans %= MOD;
        }
        System.out.println(ans);
    }
}
