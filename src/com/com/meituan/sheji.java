package com.com.meituan;

import java.util.Scanner;

public class sheji {
    /**
     * 小仓酷爱射击运动。今天的小仓想挑战自我。小仓有N颗子弹，接下来小仓每次会自由选择K颗子弹进行连续射击，全中靶心的概率为p[k]。如果成功小仓将获得a[k]的得分，并且可以使用余下子弹继续射击，否则今天的挑战结束。小仓想知道在最佳策略下，自己能得到的最高期望分数是多少。
     *
     * 输入
     * 第一行一个数N，代表子弹数量。
     *
     * 第二行N个数p[]，第 i 个数代表p[i]。
     *
     * 第三行N个数a[]，第 i 个数代表a[i]。
     *
     * 1<=N<=5000   0<=p[i]<=1   0<=a[i]<=1000
     *
     * 输出
     * 一个数表示最高期望得分，保留两位小数。
     *
     *
     * 样例输入
     * 2
     * 0.80 0.50
     * 1 2
     * 样例输出
     * 1.44
     * 样例1解释
     * 选择用一颗子弹射击：如果命中则再用余下子弹射击（仅剩一颗子弹故只能选择一颗）：0.80 * 1 + 0.80 * 0.80 * 1= 1.44
     * 选择用两颗子弹射击：0.5 * 2 = 1.00
     * 此时最高期望得分为1.44
     *
     * 输入样例2
     * 3
     * 0.90 0.10 0.10
     * 2 1 1
     * 输出样例2
     * 4.88
     * 选择用一颗子弹射击：如果命中则再用一颗子弹进行射击，如果命中则再用一颗子弹进行射击（即3轮均使用了一颗
     * 子弹进行）：0.90 * 2 + 0.90 * 0.90 * 2+0.90 * 0.90 * 0.90 * 2= 4.878≈4.88
     * 此种情况的期望得分最高，故为4.88
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //子弹总数
        int n = in.nextInt();
        double[] p = new double[n+1];
        for(int i=1;i<=n;i++){
            p[i] = in.nextDouble();
        }
        //n个分数
        int[] a = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i] = in.nextInt();
        }
        double max = 0;
        double max1 = 0;
        for(int i=1;i<=n;i++){
            max1 = Math.max(max1,p[i]);
        }
        System.out.println("max1:"+max1);
        //System.out.println("max2:"+max2);
        for(int i=1;i<=n;i++){
            max +=Math.pow(max1,i)*a[1];
        }
        System.out.println(String.format("%.2f",max));
    }
}
