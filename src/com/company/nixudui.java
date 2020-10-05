package com.company;

public class nixudui {

        public static void main(String[] args) {
            Main1 main = new Main1();
            int nums[] = new int[]{364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,
                    418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,
                    746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,
                    583,523,697,478,147,795,380,973,958,115,773,870,259,655,446, 863,735,784,3,671,433,630,
                    425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
            int total = main.InversePairs(nums);
            System.out.println(total);
        }

//    public static void main(String[] args) {
//        Test test = new Test();
//        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        int i = test.inversePairs(arr);
//        System.out.println(i);
//    }

}
class Main1{
//    private int reversePair = 0; // 统计数组中的逆序对
//
//    public int inversePairs(int[] array) {
//        if (array == null) { //数组为null返回0
//            return 0;
//        }
//        int len = array.length;
//
//        if (len == 0) { //数组长度为0返回0
//            return 0;
//        }
//        sort(array, 0, len - 1); //进行排序
//        return reversePair;
//    }
//    private void sort(int[] arr, int start, int end) {
//        if (start < end) { //利用归并排序的思想
//            int mid = (start + end) >>1;
//            sort(arr, start, mid);
//            sort(arr, mid + 1, end);
//            merger(arr, start, mid, mid + 1, end);
//        }
//    }
//    private void merger(int[] arr, int start1, int end1, int start2, int end2) { //归并排序
//        int len = end2 - start1 + 1;
//        int [] nums = new int[len];
//        int k = end2 - start1 + 1;
//        int i = end1;
//        int j = end2;
//        while(i >= start1 && j >= start2){
//            if(arr[i] > arr[j]){
//                nums[--k] = arr[i--];
//                reversePair = reversePair + (j - start2 + 1);
//            }else{
//                nums[--k] = arr[j--];
//            }
//        }
//        for( ; i >= start1; i--){
//            nums[--k] = arr[i];
//        }
//        for( ; j >= start2; j--){
//            nums[--k] = arr[j];
//        }
//        for(int m =0; m < len; m++){
//            arr[start1++] = nums[m];
//        }
//    }
    private long sum;
    public int InversePairs(int [] array) {
        sum = 0;
        int l = 0;
        int r = array.length - 1;
        device(l,r,array);
        return (int)(sum%1000000007);
    }
    private void device(int l,int r,int[] array){
        if(l!=r ){
            int mid = (l+r)>>1;
            device(l,mid,array);
            device(mid+1,r,array);
            merge(l,r,mid,array);
        }
    }
    private void merge(int l,int r,int mid,int[] array){
        int i=l;//左区间起点
        int j=mid+1;//右区间
        int[] temp = new int[r-l+1];
        int index=0;
        while(i<=mid && j<=r){
            if(array[i]>array[j]){
                temp[index++] = array[j++];
                sum += mid-i+1;
            }else{
                temp[index++]=array[i++];
            }
        }
        while(i<=mid){
            temp[index++]=array[i++];
        }
        while(j<=r){
            temp[index++]=array[j++];
        }
        index=0;
        for(int k=l;k<=r;k++){
            array[k]=temp[index++];
        }
    }
}

