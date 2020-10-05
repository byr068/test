package com.company.search;

import java.util.ArrayList;
import java.util.List;

//使用前提---使用二分查找的数组必须是有序的
public class BinarySearch {
    public static void main (String[] args){
        int arr[] = {1,8,10,89,1000,1134};
        int index = binarySearch(arr,0,arr.length-1,111);
//        int arr[] = {1,8,10,89,1000,1000,1000,1134};
//        List<Integer> index = binarySearch2(arr,0,arr.length-1,10);
        System.out.println(index);
    }

    /**
     *
     * @param arr 要查找的数组
     * @param left 左边的索引值
     * @param right 右边的索引值
     * @param val 要查找的值
     * @return 如果找到就返回下标，没找到返回-1
     */
    public static int binarySearch(int[] arr,int left,int right,int val){
        int mid = (left+right)/2;
        int midValue = arr[mid];
        if(left>right){//说明递归完整个数组也没找到value
            return -1;
        }
        if(val<midValue){
            return binarySearch(arr,left,mid-1,val);//向左递归遍历
        }else if(val>midValue){
            return binarySearch(arr,mid+1,right,val);//向右递归遍历
        }else{
            return mid;
        }
    }
    //{1,8,10,89,1000,1000,1000,1134}
    //有多个相同值时，将所有的数值都查到，比如这里的1000

    /**
     * 1.找到mid不要直接返回
     * 2.向mid的做左边扫描，将所有满足1000的元素的下标加入到ArrayList
     * 3.向mid的做右边扫描，将所有满足1000的元素的下标加入到ArrayList
     * 4.将ArrayList返回
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int val){
        int mid = (left+right)/2;
        int midValue = arr[mid];
        if(left>right){//说明递归完整个数组也没找到value
            return new ArrayList<>();
        }
        if(val<midValue){
            return binarySearch2(arr,left,mid-1,val);//向左递归遍历
        }else if(val>midValue){
            return binarySearch2(arr,mid+1,right,val);//向右递归遍历
        }else{
            List<Integer> indexList = new ArrayList<>();
            int temp = mid -1;//定义一个临时变量
            while(true){
                if(temp <left ||arr[temp]!=val){//退出
                    break;
                }
                //否则temp装入到ArrayList

                indexList.add(temp);
                temp -=1;
            }
            indexList.add(mid);
            //向右循环
            temp = mid + 1;//定义一个临时变量
            while(true){
                if(temp > arr.length-1 ||arr[temp]!=val){//退出
                    break;
                }
                //否则temp装入到ArrayList
                indexList.add(temp);
                temp +=1;
            }
            return  indexList;
        }
    }
}
