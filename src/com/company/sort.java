package com.company;

import com.duoxiancheng.DieLock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class sort {
    public static void main(String[] args){
        SortTest sortTest = new SortTest();
        //int[] arrs ={1,-9,78,0,23,-567,70,-4};
        int[] arrs = {10,7,2,4,7,62,3,4,2,1,8,9,19};

//        int[] arrs={2,3,4,6,8,9,1,0,5,7};
//        System.out.println("排序前的数组为"+ Arrays.toString(arrs));
//
//        sortTest.selectSort(arrs);
//        sortTest.insertSort(arrs);

        //希尔排序-交换法
//        sortTest.shellSort(arrs);

        //希尔排序-移动法
//        sortTest.shellSort2(arrs);

//        //快速排序
//        sortTest.quickSort(arrs,0,arrs.length-1);
//
//        //归并排序
//        sortTest.mergeSort(arrs,0,arrs.length-1);
//        sortTest.quicksort(arrs,0,arrs.length-1);
        sortTest.quickSort3(arrs,0,arrs.length-1);
       System.out.println("排序后的数组为"+ Arrays.toString(arrs));

    }
}


class SortTest{
    /**
     *  冒泡排序
     * @param arrs  要排序的数组
     */
    //冒泡排序，第一次排序将最大的数字确定，第二次排序不用对最大的数字进行比较
    //优化：如果排序时没有发生一次变化，则可以提前结束
    public void pollSort(int[] arrs) {
        int temp = 0;
        boolean flag =false;
        for (int i = 0; i < arrs.length - 1; i++) {//冒泡排序的次数为n-1
            for (int j = 0; j < arrs.length - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    flag = true;
                    temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
                if(!flag){
                    break;
                }else{
                    flag = false;
                }

            }
        }
    }

    /**
     *  选择排序
     * @param arr
     */
    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {//一共数组大小-1轮排序
            int minIndex = i;//设置排序索引
            int min = arr[i];//假定为最小值
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];//找到最小值
                    minIndex = j;//最小值得索引
                }
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("排序后的数组为 \n" + Arrays.toString(arr));
        }
        /*
        //第一次排序
        int minIndex=0;//设置排序索引
        int min = arr[0];//假定为最小值
        for(int j=0+1;j<arr.length;j++){
            if(min>arr[j]){
               min=arr[j];//找到最小值
               minIndex=j;//最小值得索引
            }
            arr[minIndex]=arr[0];
            arr[0]=min;
        }
        System.out.println("第一次排序后的数组为"+Arrays.toString(arr));

        //第二次排序
        minIndex=1;//设置排序索引
        min = arr[1];//假定为最小值
        for(int j=1+1;j<arr.length;j++){
            if(min>arr[j]){
                min=arr[j];//找到最小值
                minIndex=j;//最小值得索引
            }
            arr[minIndex]=arr[1];
            arr[1]=min;
        }
        System.out.println("第二次排序后的数组为 \n"+Arrays.toString(arr));

        //第三次排序
        minIndex=2;//设置排序索引
        min = arr[2];//假定为最小值
        for(int j=1+1;j<arr.length;j++){
            if(min>arr[j]){
                min=arr[j];//找到最小值
                minIndex=j;//最小值得索引
            }
            arr[minIndex]=arr[2];
            arr[2]=min;
        }
        System.out.println("第三次排序后的数组为 \n"+Arrays.toString(arr));
        */
    }

    /**
     *  插入排序
     */
    public void insertSort(int[] arr){
        int indexval = 0;
        int index = 0;
        //循环表达
        for(int i=1;i<arr.length;i++){//一共循环n-1次
            indexval = arr[i];//待插入的值
            index = i -1;
            while(index>=0&&indexval<arr[index]){
                arr[index+1]=arr[index];
                index--;//遍历所有的有序数组下标
            }
            arr[index+1]=indexval;

        }
        System.out.println("插入算法排序的数组为\n"+Arrays.toString(arr));
        /*
        //第一次循环
        //定义待插入的值
        int indexval = arr[1];
        //插入的索引
        int index = 1-1;
        //index>=0确定索引没有越界
        //arr[0]>arr[index+1]说明无序数组的值要插入有序数组前面
        while(index>=0&&indexval<arr[index]){
            arr[index+1]=arr[index];
            index--;
        }
        arr[index + 1] = indexval;
        System.out.println("第一轮后的数组为\n" + Arrays.toString(arr));

        //第二轮排序
        indexval = arr[2];
        //插入的索引
        index = 2-1;
        //index>=0确定索引没有越界
        //arr[0]>arr[index+1]说明无序数组的值要插入有序数组前面
        while(index>=0&&indexval<arr[index]){
            arr[index+1]=arr[index];
            index--;
        }
        arr[index+1] = indexval;
        System.out.println("第二轮后的数组为\n"+Arrays.toString(arr));

        //第三轮排序
        indexval = arr[3];
        //插入的索引
        index = 3-1;
        //index>=0确定索引没有越界
        //arr[0]>arr[index+1]说明无序数组的值要插入有序数组前面
        while(index>=0&&indexval<arr[index]){
            arr[index+1]=arr[index];
            index--;
        }
        arr[index+1] = indexval;
        System.out.println("第三轮后的数组为\n"+Arrays.toString(arr));
        */
    }
    public void shellSort(int[] arr){
        int temp = 0;//临时变量
        int count=0;
        //根据前面的分析，使用循环处理
        for(int gas=arr.length/2;gas>0;gas /=2){
            for(int i=gas;i<arr.length;i++){
                //遍历各组中所有的元素(共gap组，每组有个元素)，步长为gap
                for(int j=i-gas;j>=0;j-=gas){
                    //如果当前元素大于加上步长的元素，说明交换
                    if(arr[j]>arr[i]){
                        temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
            System.out.println("第"+(++count)+"轮后的数组为："+Arrays.toString(arr));
        }

        /*
        //第一次排序
        //步长为10/2
        //因为第一轮排序，将10个数据分成了5组
        for(int i=5;i<arr.length;i++){
        //遍历各组中所有的元素(共5组，每组有两个)，步长为5
            for(int j=i-5;j>=0;j-=5){
                if(arr[j]>arr[i]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("第一轮后的数组为："+Arrays.toString(arr));

        //第二次排序
        //步长为5/2取整数2
        for(int i=2;i<arr.length;i++){
            for(int j=i-2;j>=0;j-=2){
                if(arr[j]>arr[i]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("第二轮后的数组为："+Arrays.toString(arr));
        //第三次排序
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j-=1){
                if(arr[j]>arr[i]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        System.out.println("第三轮后的数组为："+Arrays.toString(arr));
        */
    }
    public void shellSort2(int[] arr){
        //增量gap，逐渐缩小增量
        for(int gap=arr.length;gap>0;gap/=2){
            for(int i=1;i<arr.length;i++){
                int j =i;
                int temp = arr[j];
                while(j -gap>=0&&temp<arr[j-gap]){
                    //移动
                    arr[j]=arr[j-gap];
                    j -=gap;
                }
                //退出while后,就给temp找到插入的位置
                arr[j]=temp;
            }
        }
        System.out.println("希尔移动法排序后的数组为："+Arrays.toString(arr));
    }
    //快速排序
    public void quickSort(int[] arrs,int left,int right){
//        if(left>=right)return;
        int l = left;
        int r = right;
        int pivot = arrs[(left+right)/2];
        int temp = 0;
        //while循环的目的是让比pivot值小的放左边，大的放右边
        while(l<r) {
            //遍历pivot左边和右边的值
            while (arrs[l] < pivot) {
                l += 1;
            }
            while (arrs[r] > pivot) {
                r -= 1;
            }
            //如果l>=r,说明pivot的左右两边的值已经按照
            //左边都是小于等于pivot的值，右边都是大于等于pivot的值
            if (l >= r) {
                break;
            }
            //交换pivot两边的值，小的去左边，大的去右边
            temp = arrs[l];
            arrs[l] = arrs[r];
            arrs[r] = temp;
            //如果交换完发现这个arr[l]与pivot相等，r--,前移
            if (arrs[l] == pivot) {
                r -= 1;
            }
            //
            if (arrs[r] == pivot) {
                l += 1;
            }
        }
            //如果l == r,必须l++，r--,否则出现栈溢出
            if (l == r) {
                l += 1;
                r -= 1;
            }

            //向左递归
            if(left<r){
                quickSort(arrs,left,r);
            }
            //向右递归
            if(right>l){
                quickSort(arrs,l,right);
            }

    }
    //归并排序
    //归并排序--分+合方法
    public void mergeSort(int[] arr,int left,int right){
        if(left!=right){
            //中间索引
            int mid = (left+right)/2;
            //            //左边
            mergeSort(arr,left,mid);
            //右边
            mergeSort(arr,mid+1,right);
            merge(arr,left,mid,right);
        }
    }
    //归并排序--第二部-合并
    /**
     *
     * @param arr 要排序的数组
     * @param left  左边有序序列的索引
     * @param mid   中间的索引
     * @param right   右边的索引
     */
    public void merge(int[] arr,int left,int mid,int right){
        int i = left;
        int j= mid +1;
        int[] temp = new int[right-i+1];//
        int index = 0;
        while(i<=mid&&j<=right){
            if(arr[i]>arr[j]) {
                temp[index++] = arr[j++];
            }else{
                temp[index++] = arr[i++];
            }
        }
        //左边还有元素
        while(i<=mid){
            temp[index++] = arr[i++];
        }
        //右边
        while(j<=right){
            temp[index++] =arr[j++];
        }
        index = 0;
        for(int k=left;k<=right;k++){
            arr[k] = temp[index++];
        }
    }

    public void quicksort(int[] arr,int left,int right){
        int i,j,temp,t;
        if(left>right){
            return;
        }
        i = left;
        j = right;
        temp = arr[left];
        while(i<j){
            while(temp<=arr[j]&&i<j){
                j--;
            }
            while(temp>=arr[i]&&i<j){
                i++;
            }
            if(i<j){
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = temp;
        quicksort(arr,left,j-1);
        quicksort(arr,j+1,right);
    }

    public  void quickSort2(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];
        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }


    void quickSort3(int[] arr,int left,int right){
        int l = left;
        int r = right;
        int midVal = arr[(l+r)/2];
        int temp = 0;
        while(l<r){
            while(arr[l]<midVal){
                l++;
            }
            while(arr[r]>midVal){
                r--;
            }
            if(l>=r){
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if(arr[l]==midVal){
                r --;
            }
            if(arr[r]==midVal){
                l++;
            }
        }
        if(l==r){
            l++;
            r--;
        }
        if(l<right){
            quickSort3(arr,l,right);
        }
        if(left<r){
            quickSort3(arr,left,r);
        }
    }

}


