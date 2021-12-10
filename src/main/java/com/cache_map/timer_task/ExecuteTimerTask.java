package com.cache_map.timer_task;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * https://www.journaldev.com/1050/java-timer-timertask-example
 */
public class ExecuteTimerTask extends TimerTask {

    public static void main(String args[]) {
        Timer taskManager = new Timer(true); //TODO: running timer task as daemon thread
        TimerTask executeTimerTask = new ExecuteTimerTask();
        System.out.println("TimerTask >> started");

        // Запускаем крон и через 10-секунд с повторением в 5-секунд начинаем выполнять наши задачи...
        taskManager.scheduleAtFixedRate(executeTimerTask, 10000, 3000); //TODO: каждые 3-секунд

        // Ожидаеи какое-то время, в период которого будут выполнятся наши задачи... и после этого останавливаем крон
        try {
            Thread.sleep(30000); //TODO: (30-секунд)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        taskManager.cancel();
        System.out.println("TimerTask << cancelled");

        // Дальше еще ожидаеи какое-то время чтобы закончить выполнение для последней задачи и уже выходим из системы...
        try {
            Thread.sleep(10000); //TODO: (10-секунд)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.print("          >> execute at: " + new Date() + " ... ");
        executeTask();
        System.out.println("finished at: " + new Date());
    }

    private void executeTask() {
        try {
            Thread.sleep(2000); //TODO: assuming it takes 2-secs to complete the task (2-секунды)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
