package com.cache_map.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @see http://java-online.ru/concurrent-executor.xhtml
 */
public class ExecutorServiceExample1 {

    SimpleDateFormat     sdf   = new SimpleDateFormat("HH:mm:ss.S");
    private  final  int  COUNT = 5;

    public static void main(String args[]) {
        new ExecutorServiceExample1();
    }

    ExecutorServiceExample1() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
//        CountDownLatch cdl1 = new CountDownLatch(COUNT);
//        CountDownLatch cdl2 = new CountDownLatch(COUNT);
//        CountDownLatch cdl3 = new CountDownLatch(COUNT);
//        CountDownLatch cdl4 = new CountDownLatch(COUNT);

//        System.out.println("Запуск потоков");
        executor.execute(new MyThread("Thread.1")); //executor.execute(new MyThread(new CountDownLatch(COUNT), "Thread.1")); //executor.execute(new MyThread(cdl1, "Thread.1"));
        executor.execute(new MyThread("Thread.2")); //executor.execute(new MyThread(new CountDownLatch(COUNT), "Thread.2")); //executor.execute(new MyThread(cdl2, "Thread.2"));
        executor.execute(new MyThread("Thread.3")); //executor.execute(new MyThread(new CountDownLatch(COUNT), "Thread.3")); //executor.execute(new MyThread(cdl3, "Thread.3"));
        executor.execute(new MyThread("Thread.4")); //executor.execute(new MyThread(new CountDownLatch(COUNT), "Thread.4")); //executor.execute(new MyThread(cdl4, "Thread.4"));

//        try {
//            cdl1.await();
//            cdl2.await();
//            cdl3.await();
//            cdl4.await();
//        } catch(InterruptedException exc) { }

        executor.shutdown();
        System.out.println("Завершение потоков");
    }

    //-------------------------------------------------
    void printMessage(final String templ) {
        String text = sdf.format(new Date()) + " : " + templ;
        System.out.println(text);
    }

    //-------------------------------------------------
    class MyThread implements Runnable {
        String         name;
//        CountDownLatch latch;
//        MyThread(CountDownLatch c, String n) {
//            latch = c;
//            name = n;
//            new Thread(this);
//        }

        MyThread(String n) {
            name = n;
            new Thread(this);
        }

        public void run() {
            try {
//                for(int i = 0; i < COUNT; i++) {
            printMessage(name + " - "); //printMessage(name + " - " + i);
//                    latch.countDown();
            Thread.sleep(2500); //Thread.sleep((long)(Math.random() * 1500));
//                }
//                printMessage(name + " completed");
            } catch (InterruptedException e) {}
        }
    }
}
