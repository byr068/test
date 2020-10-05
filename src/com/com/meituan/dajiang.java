package com.com.meituan;

import java.util.Scanner;
/**
 * 第一行输入两个整数N和X，中间用空格隔开，其中N表示游戏的数目N(1<=N<=10)，X表示计划玩游戏的总时间天数 (1<=X<=1000)。
 *
 * 第二行输入第1个游戏的成就值A1(0<=A1<=10000) 和 通关所需要花费时间B1天 (1<=Bi<=500) 中间用空格隔开。
 *
 * 第N+1行输入第N游戏的成就值An(0<=An<=10000) 和 通关所需要花费时间Bn天(1<=Bn<=500) 中间用空格隔开
 */

class Test5 {
    public static void main(String[] args) {
        int numberGames,days;
        //每款游戏完成天数数组
        int[] dayArr = new int[10];
        //每款游戏完成成就值数组
        int[] honorArr = new int[10];
        Scanner scanner = new Scanner(System.in);
        //输入的第一行第一个数字-游戏数
        numberGames = scanner.nextInt();
        // 输入的第一行第二个数字-总天数
        days = scanner.nextInt();
        // 外层循环-根据游戏数量
        for (int i = 0; i < numberGames; i++) {
            //当前行的的第一个数字-游戏的成就值
            int a = scanner.nextInt();
            honorArr[i]=a;
            //当前行的的第二个数字-游戏所需完成时间
            int b = scanner.nextInt();
            dayArr[i]=b;
        }
        biggestHonor(dayArr,honorArr,days,numberGames);
    }
    /** * * @param w 每款游戏完成天数 数组
     * * @param v 每款游戏完成成就值 数组
     * * @param m 输入的第一行第二个数字-总天数
     * * @param n 输入的第一行第一个数字-游戏数
     * */
    public static void biggestHonor(int[] w ,int [] v,int m,int n){
        int[][] val = new int[n+1][m+1];//表格中有一行一列为0，表示没有物品时价值为0，背包没有容量时价值为0
        int[][] path = new int[n+1][m+1];//记录背包装物品的记录
        // 将val数组的第一行跟第一列置0
        for (int i = 0; i < val.length; i++) {
            val[i][0] = 0;//将列置0
        }
        for (int j = 0; j < val[0].length; j++) {
            val[0][j] = 0;//将行置0
        }
        for (int i = 1; i < val.length; i++) {
            for (int j = 1; j < val[0].length; j++) {
                if (w[i - 1] > j) {
                    val[i][j] = val[i - 1][j];
                } else {
                    if (val[i - 1][j] > v[i - 1] + val[i - 1][j - w[i - 1]]) {
                        val[i][j] = val[i - 1][j];
                    } else {
                        val[i][j] = v[i - 1] + val[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }
                }
            }
        }
        System.out.println(val[val.length - 1][val[0].length - 1]);
    }
}
