package com.cache_map.timer_task;

import java.util.*;

/**
 * https://www.tutorialspoint.com/how-can-we-implement-a-timer-thread-in-java
 */
public class TimerThreadTest {

    static Timer timer = new Timer();

    public static void main(String []args) {
        System.out.println("[" + new Date() + "] System Start!");

        Task task1 = new Task("Task #1: executes for every 10 seconds");
        Task task2 = new Task("Task #2: executes for every 2 seconds");

//        timer.schedule(task1, 10000);             //TODO: выполнить через 10-секунд (1-раз)
//        timer.schedule(task2, 1000, 2000); //TODO: выполнить через 1-секунд и повторять каждые 2-секунды
        timer.schedule(task1, 3000);             //TODO: выполнить через 3-секунды только 1-раз
//        timer.schedule(task2, 3000, 1000); //TODO: выполнить через 3-секунд и повторять каждую 1-секунду

        System.out.println("[" + new Date() + "] System Stop!");
    }
}


class Task extends TimerTask {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("[" + new Date() + "] " + name);
        TimerThreadTest.timer.cancel();
    }
}
