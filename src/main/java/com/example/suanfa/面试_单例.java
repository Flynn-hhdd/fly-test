package com.example.suanfa;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName 面试_单例.java
 * @Description TODO
 * @createTime 2020年04月15日 09:43:00
 */
public class 面试_单例 {

    /**
     * 饿汉
     */
    static class Singleton1{
        private static Singleton1 singleton1 = new Singleton1();
        private Singleton1(){

        }
        public static Singleton1 getSingleton1(){
            return singleton1;
        }
    }
    /**
     * 懒汉
     */
    static class Singleton2{
        private static Singleton2 singleton2;
        private Singleton2(){

        }
        public static Singleton2 getSingleton2(){
            if(singleton2 == null){
                singleton2 = new Singleton2();
            }
            return singleton2;
        }

    }

    /**
     * 双重检测
     */
    static class Singleton3{
        private static volatile Singleton3 singleton3;
        private Singleton3(){

        }
        public static Singleton3 getSingleton3(){
            if(singleton3 == null){
                synchronized (Singleton3.class){
                    if(singleton3 == null){
                        singleton3 = new Singleton3();
                    }
                }
            }
            return singleton3;
        }

    }



}
