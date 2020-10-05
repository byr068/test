package com.company;

import org.junit.Test;

import java.util.Scanner;


public class Main {
    @Test
    public void laji() {
        // write your code here
//        String path = "d:/test";//改为最外面的文件夹名字
//        File file = new File(path);
//        File[] tempList = file.listFiles();
//        System.out.println("该目录下对象个数：" + tempList.length);
//        for (int i = 0; i < tempList.length; i++) {
////                System.out.println("文件夹：" + tempList[i]);
////            }
//                 String path2 = ""+tempList[i];
//                 System.out.println(path2);//第二层文件夹
//                 File file2 = new File(path2);
//                 File[] tempList2 = file2.listFiles();
//                 //System.out.println((String)tempList2);
//                 if(tempList2 != null) {
//                     System.out.println("文件：" + tempList2.length);//获取文件数
//                 }
//        }
        Main8 main8 = new Main8();
//        main8.test();

        System.out.println("partition--------------------");
        int partition = main8.partition(new int[]{4, 5, 4},0,2);
        System.out.println("partition:"+partition);
    }
}

class Main8 {
    /**
     * 快排一趟划分过程
     * @param a 要排序的数组
     * @param low 子序列左边界下标
     * @param high 子序列右边界下标
     * @return
     *      返回值不小于0，证明该趟排序没有重复元素，并且返回值就是基准元素要插入的位置，
     *如果返回值为-1，证明该趟排序有重复元素
     */

    public static int partition(int []a,int low,int high){
        int key=a[low];
        while(low<high){
            while(low<high && a[high]>=key){
                if(a[high]==key){
                    return -1;//返回-1说明有重复元素
                }
                high--;
            }
            a[low]=a[high];

            while(low<high&&a[low]<=key){
                if(a[low]==key){
                    return -1;//返回-1说明有重复元素
                }
                low++;
            }
            a[high]=a[low];
        }
        a[low]=key;
        return low;
    }
    /**
     * 快排算法
     * @param a 带排序数组
     * @param left 待排序列左边界下标
     * @param right 待排序列右边界下标
     * @param flag 如果快排结束后，flag中包含true，则说明有重复元素（这里选择StringBuffer作为标志，主要是为了以引用作为形参）
     */
    public static void quickSort(int [] a,int left,int right, StringBuffer flag){
        if(right-left==0){//如果子序列长度等于1，结束递归，说明已经排好序
            return ;
        }
        //基准元素下标
        int middleIndex= partition(a, left, right);
        if(middleIndex==-1){
            flag.append("true");
            return;
        }
        quickSort(a, left, middleIndex-1,flag);
        quickSort(a, middleIndex+1, right,flag);
    }

    /**
     * 判断数组a是否有重复元素
     * @param a 待判断数组
     * @return 返回true则有重复元素
     */
    public boolean isDoubleOrMore(int [] a){
        StringBuffer flag = new StringBuffer();
        int left=0;
        int right=a.length-1;
        quickSort(a, left, right, flag);
        if(flag.toString().contains("true")){
            return true;
        }
        return false;
    }

    public void test(){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入数组长度");
        int n=sc.nextInt();
        System.out.println("请输入数组元素");
        int []a=new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i]=sc.nextInt();
        }
        System.out.println(isDoubleOrMore(a));

    }
}