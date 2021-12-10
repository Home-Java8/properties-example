package com.cache_map.threadlocal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @see http://java-online.ru/concurrent-executor.xhtml
 */
public class ExecutorServiceExample2 {
    static int COUNT = 10;

    public static void main(String args[]) {
        ExecutorServiceExample2 example2 = new ExecutorServiceExample2();

        List<String> list = new ArrayList();
        example2.executorParallelCallService(list);
        System.out.println(list);
    }

    public void executorParallelCallService(List<String> list) {
        System.out.println(new SimpleDateFormat("HH:mm:ss.S").format(new Date()) + " : " + "Запуск потоков");
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for(int i = 0; i < COUNT; i++) executor.execute(new ParallelCallService("Thread." + i, list));

        executor.shutdown();

        while (!executor.isTerminated()) { }
        System.out.println(new SimpleDateFormat("HH:mm:ss.S").format(new Date()) + " : " + "Завершение потоков");
    }

    void parallelCallService(String name, List<String> list) throws InterruptedException {
        System.out.println(new SimpleDateFormat("HH:mm:ss.S").format(new Date()) + " : " + name);
        Thread.sleep(2500);
//        list.add(name);

        List<String> names = new ArrayList();
        names.add(name);
        list.addAll(names);
    }

    class ParallelCallService implements Runnable {
        String name;
        List<String> list;

        ParallelCallService(String name, List<String> list) {
            this.name = name;
            this.list = list;
            new Thread(this);
        }

        public void run() {
            try {
                parallelCallService(name, list);
            } catch (InterruptedException e) {}
        }
    }
}


