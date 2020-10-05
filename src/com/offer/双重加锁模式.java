package com.offer;

public class 双重加锁模式 {
    public static void main(String[] args) {
        Singleton.getInstance();
        Singleton2.getInstance();
    }
}

/**
 * 双重检查锁
 */
class Singleton{
    private static volatile Singleton instance = null;
    private Singleton(){}
    static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

/**
 * 内部静态类
 */
class Singleton2{
    private Singleton2(){};
    private static class SingletonDemo{
        private static Singleton2 instance = new Singleton2();
    }
    static Singleton2 getInstance(){
        return SingletonDemo.instance;
    }

}