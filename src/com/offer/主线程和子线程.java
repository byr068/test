package com.offer;

public class 主线程和子线程 {

    public static void main(String[] args) throws Exception {
        MyThread mt = new MyThread();
        Thread th = new Thread(mt);
        th.start();
        th.join();
        System.out.println("world"); }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("hello");
    }

}
