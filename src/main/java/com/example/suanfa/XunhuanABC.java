package com.example.suanfa;

import java.util.AbstractQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LingYin.Fan
 * @version 1.0.0
 * @ClassName XunhuanABC.java
 * @Description TODO
 * @createTime 2020年03月26日 15:13:00
 */
public class XunhuanABC {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        test2();
    }

    public static void test2() {
        AtomicInteger integer = new AtomicInteger();

        new Thread(() -> {
            while (integer.get() < 30) {
                if (integer.get() % 3 == 0) {
                    System.out.println("A");
                    integer.getAndIncrement();
                }
            }
        }).start();
        new Thread(() -> {
            while (integer.get() < 30) {
                if (integer.get() % 3 == 1) {
                    System.out.println("B");
                    integer.getAndIncrement();
                }
            }
        }).start();
        new Thread(() -> {
            while (integer.get() < 30) {
                if (integer.get() % 3 == 2) {
                    System.out.println("C");
                    integer.getAndIncrement();
                }
            }
        }).start();

    }

    public void test1() {
        Semaphore a = new Semaphore(1);
        Semaphore b = new Semaphore(0);
        Semaphore c = new Semaphore(0);

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    a.acquire();
                    System.out.println("a");
                    b.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    b.acquire();
                    System.out.println("b");
                    c.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                try {
                    c.acquire();
                    System.out.println("c");
                    a.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

}
