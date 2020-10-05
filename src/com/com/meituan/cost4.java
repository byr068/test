package com.com.meituan;

import java.util.Scanner;

public class cost4 {
    /**
     * 西西所在的国家有N座城市，每座城市都有一道传送门，城市 i 的传送门通往城市 a[i]。当西西位于城市 i 时，每次他可以执行以下三种操作中的一种：
     *
     *   花费 A 的费用，从城市 i 前往城市 a[i]；如果 a[i] > 1，可以花费 B 的费用，将 a[i] 的值减少 1；
     *
     *   如果 a[i] < N，可以花费 C 的费用，将 a[i] 的值增加 1。现在，西西想从城市 1 前往城市 N，那么他至少要花费多少费用？
     *
     * 输入
     * 第一行输入四个整数 N、A、B、C（1 < N <= 10000，1 <= A、B、C <= 100000）。
     *
     * 第二行输入 N 个整数 a[1] 到 a[N]（1 <= a[i] <= N）。
     * 输出
     * 输出一个整数，表示从城市 1 前往城市 N 所花费的最少费用。
     * 样例输入
     * 7  1  1  1
     * 3  6  4  3  4  5  6
     * 样例输出
     * 4
     * 提示
     * 样例解释
     * 西西可以按顺序执行以下操作：
     * 将 a[1] 减少 1，此时 a[1] = 2；
     * 从城市 1 前往城市 2；
     * 将 a[2] 增加 1，此时 a[2] = 7；
     * 从城市 2 前往城市 7。
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int[] arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = in.nextInt();
        }
        int i = 1;
        int sum = 0;
        int right = arr[1];
        while(true){
            sum+=a;
            if(right==n)break;
            if(arr[right]<arr[arr[i]-1]){
                right = arr[i]-1;
                sum += b;
            }else if(arr[right] <arr[arr[i]+1]){
                right = arr[i]+1;
                sum += c;
            }else{
                right = arr[right];
            }
        }
    }
}
