package com.duoxiancheng;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo implements Runnable {
    private ReentrantLock lock = new ReentrantLock();
    private Condition con = lock.newCondition();
    int i=0;
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        lock.lock();
        try{
            for(int j=0;j<10;j++){
                if(name.equals("B")){
                    while(i%3!=1){
                        con.await();
                    }
                }else if(name.equals("A")){
                    while(i%3!=0) {
                        con.await();
                    }
                }
                else if(name.equals("C")){
                    if(i%3!=2){
                        con.await();
                    }
                }
                System.out.println(name);
                i++;
                con.signalAll();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ThreadDemo thread = new ThreadDemo();
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        Thread t3 = new Thread(thread);
        t1.setName("A");
        t2.setName("B");
        t3.setName("C");
        t1.start();
        t2.start();
        t3.start();
    }
}
