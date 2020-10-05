package com.company;

import java.util.*;

public class delete  {
    /**
     * 一个长方体纸箱由六个面构成。
     *
     * 现在给出六块纸板的长和宽，请你判断能否用这六块纸板构成一个长方体纸箱。
     * @param args
     */
    public static void main(String[] args) {
        test2 t = new test2();
//        System.out.println(t.toString(123456789));
        int[] arr = {1,4,5,6,7,3};
        t.quickSort(arr,0,arr.length-1);
        for(int s :arr){ System.out.println(s); }

    }

}
class test2{
    public String toString(int num){
        String str = "";
        String sb = num + "";
        String[] arr = new String[sb.length()];
        for(int i=0;i<arr.length;i++){
            arr[i] = String.valueOf(sb.charAt(i));
        }
        for(int i=arr.length-1,j=0;i>=0;i-=4,j++){
            if(i-1>=0){
                arr[i-1] = arr[i-1]+"十";
            }
            if(i-2>=0){
                arr[i-2] = arr[i-2]+"百";
            }
            if(i-3>=0){
                arr[i-3] = arr[i-3] +"千";
            }
            switch (j){
                case 1:
                    arr[i] = arr[i]+"万";
                    break;
                case 2:
                    arr[i] = arr[i]+"亿";
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            stringBuffer.append(arr[i]);
        }
        str = stringBuffer.toString();
        str = str.replaceAll("1","一");
        str = str.replaceAll("2","二");
        str = str.replaceAll("3","三");
        str = str.replaceAll("4","四");
        str = str.replaceAll("5","五");
        str = str.replaceAll("6","六");
        str = str.replaceAll("7","七");
        str = str.replaceAll("8","八");
        str = str.replaceAll("9","九");
        return str;
    }
    /**
     * 快排
     */
    public void quickSort(int[] arr,int l,int r){
        int i = l;
        int j = r;
        int privot = arr[(i+j)/2];
        while(i<j){
            while(arr[i]<privot){
                i++;
            }
            while(arr[j]>privot){
                j--;
            }
            if(i>=j)break;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            if(arr[i]==privot){
                j-=1;
            }
            if(arr[j]==privot){
                i+=1;
            }
        }
        if(i==j){
            i++;
            j--;
        }
        if(l<j){
            quickSort(arr,l,j);
        }
        if(i<r){
            quickSort(arr,i,r);
        }
    }
}
class test1{
    /**
     * 根据输入的数字，转化为相应的字符串;如 123456 ---> 一十二万三千四百五十六圆
     * @param number
     * @return
     */
    public String getString(int number){
        //将 number 转化为字符串数组
        String str=number+"";
        String[] array=new String[str.length()];
        for(int i=0;i<str.length();i++){
            array[i]=str.substring(i,i+1);
            System.out.println(array[i]);
        }
        //处理字符串，加上相应的 万，亿， 圆，千，百 字
        for(int i=array.length-1,j=1;i>=0;i-=4,j++){
            if(i-1>=0){
                array[i-1]=array[i-1]+"十";
            }
            if(i-2>=0){
                array[i-2]=array[i-2]+"百";
            }
            if(i-3>=0){
                array[i-3]=array[i-3]+"千";
            }

            switch(j){
//                case 1:
//                    array[i]=array[i]+"圆";
//                    break;
                case 2:
                    array[i]=array[i]+"万";
                    break;
                case 3:
                    array[i]=array[i]+"亿";
            }
        }
        //将 字符串数组 转化为字符串
        StringBuffer sb=new StringBuffer();
        for(int i = 0; i < array.length; i++){
            sb.append(array[i]);
        }
        str=sb.toString();

        //将数字 转化为 汉字
        str=str.replaceAll("1", "一");
        str=str.replaceAll("2", "二");
        str=str.replaceAll("3", "三");
        str=str.replaceAll("4", "四");
        str=str.replaceAll("5", "五");
        str=str.replaceAll("6", "六");
        str=str.replaceAll("7", "七");
        str=str.replaceAll("8", "八");
        str=str.replaceAll("9", "九");
        return str;
    }

}
class Solution {
    public Solution(){
        System.out.println("父亲构造方法");
    }
    public void fu(){
        System.out.println("父亲普通方法");
    }
}
class Test extends Solution{
    public Test(){
        System.out.println("子构造方法");
    }
}