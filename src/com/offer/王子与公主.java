package com.offer;

import java.util.Scanner;

public class 王子与公主 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tar = in.nextInt();
        int gx = 0, gy = 0, wx = 0, wy = 0;
        for (int k = 0; k < tar; k++) {
            String num = in.nextLine();
            String[] nums = num.split(" ");
            int n = Integer.valueOf(nums[0]);
            int m = Integer.valueOf(nums[1]);
            char[][] temp = new char[n][m];
            int[][] visw = new int[n][m];
            int[][] visg = new int[n][m];
            String str = null;
            for(int i=0;i<n;i++){
                String s = in.nextLine();
                System.out.println(s);
                str += s;
            }
            char[] temp2 = str.toCharArray();
            System.out.println(temp2);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.println(j);
                    temp[i][j] = temp2[j];
                    if (temp[i][j] == 'g') {
                        gx = i;
                        gy = j;
                    }
                    if (temp[i][j] == 'w') {
                        wx = i;
                        wy = j;
                    }
                }
            }
            dfsw(wx, wy,n,m,visw,temp);
            dfsg(gx, gy,n,m,visg,temp);
            int flag = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (visw[i][j] == 1 && visg[i][j] == 1) {
                        flag = 1;
                    }
                }
            }
            if (flag == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void dfsw(int x, int y,int n,int m,int[][] visw,char[][] temp) {
        if (x <= n && x >= 1 && y >= 1 && y <= m && visw[x][y] != 1 && temp[x][y] != '#') {
            visw[x][y] = 1;
            dfsw(x + 2, y,n,m,visw,temp);
            dfsw(x - 2, y,n,m,visw,temp);
            dfsw(x, y + 2,n,m,visw,temp);
            dfsw(x, y - 2,n,m,visw,temp);
        }
    }

    static void dfsg(int x, int y,int n,int m,int[][] visg,char[][] temp) {
        if (x <= n && x >= 1 && y >= 1 && y <= m && visg[x][y] != 1 && temp[x][y] != '#') {
            visg[x][y] = 1;
            dfsg(x + 1, y,n,m,visg,temp);
            dfsg(x - 1, y,n,m,visg,temp);
            dfsg(x , y+1,n,m,visg,temp);
            dfsg(x , y-1,n,m,visg,temp);
        }
    }
}
