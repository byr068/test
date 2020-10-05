package com.duoxiancheng;

public class DieLock {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";
    public static void main(String[] args) {
        Lock1 l1 = new Lock1();
        Lock2 l2 = new Lock2();
        Thread a = new Thread(l1);
        Thread b = new Thread(l2);
        a.start();
        b.start();
    }
}
class Lock1 implements Runnable{

    @Override
    public void run() {
        try{
            System.out.println("Lock1 running");
            while(true){
                synchronized (DieLock.obj1){
                    System.out.println("Lock1 lock obj1");
                    Thread.sleep(3000);//获取obj1后先等一会，让Lock2有足够时间锁住obj2
                    synchronized (DieLock.obj2){
                        System.out.println("Lock1 lock obj2");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class Lock2 implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println("Lock2 is running");
            while(true){
                synchronized (DieLock.obj2){
                    System.out.println("Lock2 lock obj2");
                    Thread.sleep(3000);
                    synchronized (DieLock.obj1){
                        System.out.println("Lock2 lock obj1");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}