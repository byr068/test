package com;

public class 旋转数组 {
    public static void main(String[] args) {
        Interval in = new Interval();
        in.end = 1;
        String[] str1 = {"1101","1010","1111","1110"};
        String[] str2 = {"ABCD","EFGH","IJKL","MNPQ"};
        if(str1==null||str2==null){
            return;
        }
        if(str1.length==0||str2.length==0){
            return;
        }
        int len = str1.length;
        char[][] ch = new char[len][len];
        for(int i=0;i<len;i++){
            String sb = str2[i];
            for(int j=0;j<len;j++){
                ch[i][j] = sb.charAt(j);
                //System.out.print(ch[i][j]+"\t");
            }
        }
        System.out.println();
        String s = "";
        int[][] num = new int[len][len];
        for(int i=0;i<len;i++){
            String sb = str1[i];
            for(int j=0;j<len;j++){
                num[i][j] = Integer.valueOf(sb.substring(j,j+1));
                if(num[i][j]==0){
                    //System.out.println(ch[i][j]);
                    s += String.valueOf(ch[i][j]);
                }
                //System.out.print(num[i][j]+"\t");
            }
        }
        //System.out.println();

        int[][] tempArr1 = helper(num);
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(tempArr1[i][j]==0){
                    s += String.valueOf(ch[i][j]);
                }
            }
        }
        int[][] tempArr2 = helper(tempArr1);
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(tempArr2[i][j]==0){
                    s += String.valueOf(ch[i][j]);
                }
            }
        }
        int[][] tempArr3 = helper(tempArr2);
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(tempArr3[i][j]==0){
                    s += String.valueOf(ch[i][j]);
                }
            }
        }
        System.out.println(s);
    }
    static int[][] helper(int[][] matrix){
        //if(arr==null||arr.length==0)return;
        int[][] temp = new int[matrix[0].length][matrix.length];
        int dst = matrix.length -1;
        for(int i=0;i<matrix.length;i++,dst--){
            for(int j=0;j<matrix[0].length;j++){
                temp[j][dst] = matrix[i][j];
            }
        }
        return temp;
    }
}
class Interval{
    int start;
    int end;
}
