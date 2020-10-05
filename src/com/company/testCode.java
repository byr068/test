package com.company;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class testCode implements Runnable {
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int flag = 0;
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        lock.lock();
        try{
            for(int i=0;i<10;i++){
                if(name.equals("A")){
                    while(flag%3!=0){
                        condition.await();
                    }
                }else if(name.equals("B")){
                    while(flag%3!=1){
                        condition.await();
                    }
                }else if(name.equals("C")){
                    while(flag%3!=2){
                        condition.await();
                    }
                }
                flag++;
                System.out.println(name);
                condition.signalAll();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        testCode temp = new testCode();
        Thread t1 = new Thread(temp);
        Thread t2 = new Thread(temp);
        Thread t3 = new Thread(temp);
        t1.setName("A");
        t2.setName("B");
        t3.setName("C");
        t1.start();
        t2.start();
        t3.start();
    }
}
