package com.yuanfudao;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = in.nextInt();
        String[] sb = new String[4];
        for(int i=0;i<sum;i++){
            for(int j=0;j<4;j++){
                sb[i] = in.next();
                System.out.print(sb[i]);
            }
        }

    }
}
