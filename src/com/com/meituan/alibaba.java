package com.com.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class alibaba {
    public static void main(String[] args) {
//        long a, b, A, B;
//        Scanner in = new Scanner(System.in);
//        A = in.nextLong();
//        B = in.nextLong();
//        a = in.nextLong();
//        b = in.nextLong();
//        long g = gys(a,b);
//        a /= g;
//        b /= g;
//        long x = a;
//        long y = b;
//        System.out.println(x+ "" + y);
//        if(x>A||y>B){
//            System.out.println(0+""+0);
//        }else{
//            long l = 1, r = Math.max(A,B),ans = 1;
//            while(l<=r){
//                long mid = l + (r-l)/2;
//                if(mid*x <= A && mid*y <=B) {
//                    ans = mid;
//                    l = mid+1;
//                }else{
//                    r = mid -1;
//                }
//            }
//
//            System.out.println(x*ans+ "" + y*ans);
//        }
        int[] arr = {1, 2, 5, 8};
        System.out.println(CrossRiverProblem(arr, 4));

    }

    public static long gys(long a, long b) {
        if (b == 0) return a;
        return gys(b, a % b);
    }


    public static long getDigitalMaxSum(long n) {
        if (n <= 18) return n;
        int result = 0;
        while (n >= 10) {
            long i = n % 10 + 10;
            if (i <= 18) {
                result += i;
                n -= 10;
                n /= 10;
            } else {
                result += n % 10;
                n /= 10;
            }
        }
        return result + n;
    }


    public static int CrossRiver(int[] T, int n) {
        if(n == 2)       //剩两个人
            return T[1];
        else if (n == 3) {  //剩三个人
            return T[0] + T[1] + T[2];
        }

        int t1 = T[0] + T[1] + T[1] + T[n - 1];   //方案1
        int t2 = T[0] + T[0] + T[n - 1] + T[n - 2]; //方案2
        int t = t1 > t2 ? t2 : t1;
        return CrossRiver(T, n - 2) + t;

    }

    public static int CrossRiverProblem(int[] T, int n) {
        if (n == 1)         //一个旅行者
            return T[0];
        else if (n == 2)    //两个旅行者
            return T[0] > T[1] ? T[0] : T[1];
        //多个，递归求解{
        Arrays.sort(T);//排个序
        return CrossRiver(T, n);
    }
}

