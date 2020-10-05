package com.company;

import static java.lang.System.out;

public class Circlequeue {
    public static void main(String[] args){
        CircleTest circleTest = new CircleTest(5);
        circleTest.add(2);
        circleTest.add(4);
        circleTest.add(5);
        circleTest.add(7);
        System.out.printf("添加元素----------------------\n");
        circleTest.bianliQueue();
        System.out.printf("取出元素----------------------\n");
        circleTest.getQueue();
        circleTest.bianliQueue();


    }

}
class CircleTest{
    private int maxSize;
    private int front = 0;//队列头
    private int rear = 0;
    private int[] arr;
    public CircleTest(int arrSize){
        maxSize = arrSize;
        arr = new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    //添加元素
    public void add(int n){
        if(isFull()){
            out.println("队列已经满了");
            return;
        }
        //直接添加数据
        arr[rear] = n;
        //rear向后移一位
        rear = (rear+1)%maxSize;
    }
    //获取队列的数据，出队列
    public int getQueue()  {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front+1)%maxSize;
        return value;
    }

    //遍历所有元素
    public void bianliQueue(){
        if(isEmpty()){
            out.println("队列为空");
            return;
        }
        //思路：从哪开始遍历，遍历多少个元素
        for(int i =0;i<size();i++){
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    private int size() {
        return (rear+maxSize-front)%maxSize;
    }

}
