package com.company;


import org.junit.Test;

import javax.xml.soap.Node;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ByteDance {
    public static void main(String[] args){
        CheckSame checkSame = new CheckSame();
//        checkSame.ifSame();

        int[] arr = {1,2,3,4,5,6,7};
//        Arrays.sort(arr);
//        System.out.println("原数组为："+Arrays.toString(arr));
//          int a = checkSame.searchInsert(arr,4);
//          System.out.println("插入的下标为："+a);
//        System.out.println("现在数组为："+Arrays.toString(arr));

//          checkSame.getCount();
        //返回连续公共字符串
//        String s1 = "abcdeabcegfabcdef";
//        String s2 = "abcd";
//        String same = checkSame.maxSubstring(s1,s2);
//        System.out.println(same);

        //给定一个值，判断数组中是否有两个数的和等于这个值
//        int[] arr = {3,4,5,6,7,8};
//        int num = 8;
//        int[] cur = checkSame.getIndex(arr,num);
//        System.out.println("cur[0]"+cur[0]+"cur[1]"+cur[1]);

//        //求一个整数的阶乘末尾0的个数
//        checkSame.getZeroInFactorial();

        //进制转换
//        checkSame.convert(1000,5);

        //将数组后k个元素转移到数组前面
        checkSame.reverseArray(arr,3);
        int[] arr2 ={1,2,3,4,5,6,7};
        checkSame.reverseArray2(arr2,3);
    }
}
//1、判断一个数组中是否含有重复的元素 set
class CheckSame{
    Integer[] s={1,2,4,5,4};

    public void ifSame(){
        //List<Integer> list = new ArrayList<Integer>();
        //System.out.println("s:"+s.toSt);
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<s.length;i++){
            set.add(s[i]);
        }
        System.out.println("数组中重复的元素的个数:"+(s.length-set.size()));
        System.out.println("数组中不重复的元素:"+set);
    }
//2、向一组有序的数中插入一个数；保证插入后数据还是有序的。显示插入数据的下标位置
    public int searchInsert(int[] arr,int num){
        int temp = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>num){
                temp=i;
                for(int j=arr.length-1;j>i;j--){
                    arr[j]=arr[j-1];

                }
                arr[i]=num;
                break;
            }
        }
        System.out.println("数组为："+Arrays.toString(arr));
        return temp;
    }
    //3、统计字符串中每个字符出现的次数
    public void getCount(){
        String s = "adcaddvds";
        Map<Character,Integer> map = new HashMap<>();
        char[] chr = s.toCharArray();
        for(int i=0;i<chr.length;i++){
            int count = 1;
            if(!map.containsKey(chr[i])){
                map.put(chr[i],1);
            }else{
                count++;
                map.put(chr[i],count);
            }
        }
        StringBuilder sb = new StringBuilder();

        Set<Character> tms = map.keySet();
        for(Character key : tms){

            sb.append(key).append("(").append(map.get(key)).append(")");
        }
        System.out.println(sb.toString());
       /*//定义一个字符串
        String s = "adcaddvds";
        //定义一个treemap集合
        TreeMap<Character,Integer> tm = new TreeMap<Character,Integer>();

        //将字符串转换成字符数组
//        char[] chs = line.toCharArray();
        char[] chs = s.toCharArray();
        //遍历字符串数组
        for(char ch : chs){
            //自动装箱,拿字符作为键去集合中去找值
            Integer i = tm.get(ch);
            //i=null说明集合中没有这个变量
            if(i == null){
                tm.put(ch,1);
            }else{
                i++;
                tm.put(ch,i);
            }
        }
        //创建字符串缓冲区变量
        StringBuilder sb = new StringBuilder();

        Set<Character> tms = tm.keySet();
        for(Character key : tms){
            Integer value =tm.get(key);
            sb.append(key).append("(").append(value).append(")");
        }
        System.out.println(sb.toString());*/

    }

    /**
     *  返回最大连续公共的字符串
     * @param strOne 字符串1
     * @param strTwo 字符串2
     * @return
     */
    public String maxSubstring(String strOne, String strTwo){
        // 参数检查
        if(strOne==null || strTwo == null){
            return null;
        }
        if(strOne.equals("") || strTwo.equals("")){
            return null;
        }
        // 二者中较长的字符串
        String max = "";
        // 二者中较短的字符串
        String min = "";
        if(strOne.length() < strTwo.length()){
            max = strTwo;
            min = strOne;
        } else{
            max = strTwo;
            min = strOne;
        }
        String current = "";
        // 遍历较短的字符串，并依次减少短字符串的字符数量，判断长字符是否包含该子串
        for(int i=0; i<min.length(); i++){
            for(int begin=0, end=min.length()-i; end<=min.length(); begin++, end++){
                current = min.substring(begin, end);
                if(max.contains(current)){
                    return current;
                }
            }
        }
        return null;
    }
    /**
     * 求一个整数的阶乘末尾0的个数
     * 任何一个整数都可以分解为几个素因数的乘积，根据算术基本定理，这个分解是唯一的，所以我们对阶乘数中每一个数都分解成素因数的乘积的形式
     * 例如：4=2*2 6=2*3.....
     * 这样6！=1*2*3*4*5*6=1*2*3*(2*2)*5*(2*3)，然后我们重新排列，6！=（2*5）*1*3*2*2*2*3
     * 这样只要有一对2*5结尾就会有一个0，因为2*5=10，任何数乘以10末尾一定有一个零，这样问题就转化成一个阶乘数中有多少对2*5,阶乘数末尾就有多少个0
     *
     * 使用java程序实现，就是对每一个阶乘的整数因子，求解他的2因子和5因子的个数，然后累加，最后比较2和5个数的多少，少的一方就是0的个数
     *
     */

    public void getZeroInFactorial(){
        int num = 10;
        //int count2 = 0;
        int count5 = 0;
        for (int i = 1; i<=num; i++){
            //count2 += countDivisor(i,2);
            count5 += countDivisor(i,5);
        }
//        System.out.println(num + "的阶乘末尾有" + (count2>count5?count5:count2) + "个0！");
        System.out.println(num + "的阶乘末尾有" + count5 + "个0！");
    }

    /**
     * 统计数字num的因子divisor的个数
     * @return
     */
    private int countDivisor(int num,int divisor){
        //统计个数
        int temp = 0;
        for (int i = 0; i < num; i++) {
            if (num%divisor==0){
                num /= divisor;
                temp++;
            }else {
                break;
            }

        }
        return temp;
    }

    /**
     *  二叉树的层序遍历（广度优先遍历）
     * @param root 根节点
     */
    public void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node front = queue.poll();
            System.out.println(front.getValue());
//            if (front.left != null) {
//                queue.add(front.left);
//            }
//            if (front.right != null) {
//                queue.add(front.right);
//            }
        }
    }

    /**
     *  数组中是否有两个数的和等于val
     * @param arr 目标数组
     * @param val 两个数的和
     * @return
     */
    public int[] getIndex(int[] arr,int val){
        int[] cur = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(val-arr[i])){
                cur[0]=map.get(val-arr[i]);
                cur[1]=i;
            }
            map.put(arr[i],i);
        }

        return cur;
    }

    /**
     *
     * @param num1  10进制的数
     * @param num2  5进制
     */
    public void convert(int num1,int num2) {
        Stack<Integer> s1 = new Stack<>();
        while (num1 > 0) {
            s1.push(num1 % num2);
            num1 /= num2;
        }
        while (!s1.isEmpty()) {
            System.out.print(s1.pop());
        }
    }

    /**
     *    {1,2,3,4,5,6}---{5,6,1,2,3,4}
     * @param array 需要反转的数组
     * @param k      k个元素需要前置
     */
    public void reverseArray(int[] array,int k){
        //倒置所有的元素
        reverse(array,0,array.length-1);
        //倒置前k个元素
        reverse(array,0,k-1);
        //倒置后len-k个元素
        reverse(array,k,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    public void reverse(int[] array,int begin,int end){
        int len = end-begin+1;
        int half=len/2;
        for(int i=0;i<half;i++){
            int temp = array[begin];
            array[begin]=array[end];
            array[end]=temp;
            end--;
            begin++;
        }
    }
    //方法二：将数组所有的元素前移k轮
    public void reverseArray2(int[] arr, int k){
        int len = arr.length;
        int cur = k%len;
        int temp = 0;
        for(int i=0;i<cur;i++){
            //数组最后一个元素不能前移
            temp = arr[len-1];
            for(int j=len-2;j>=0;j--){
                arr[j+1] = arr[j];
            }
            //每一轮最后一个元素移到数组的第一个位置，一共cur轮
            arr[0]=temp;
        }
        System.out.println(Arrays.toString(arr));
    }

}
