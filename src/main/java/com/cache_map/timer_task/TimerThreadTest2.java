package com.cache_map.timer_task;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * https://www.tutorialspoint.com/how-can-we-implement-a-timer-thread-in-java
 */
public class TimerThreadTest2 {

    static Timer taskManager = new Timer();
    static Timer mainTimer = new Timer();

    public static void main(String []args) {
        TimerTask execute = new ExecuteTimer();      //TODO: Запускаем крон и через 10-секунд с повторением в 5-секунд начинаем выполнять наши задачи...
        TimerTask cancelled = new CancelledTimer(taskManager);  //TODO: Ожидаем какое-то время в период которого будут выполнятся наши задачи... и после этого останавливаем крон
        TimerTask exit = new ExitTimer(mainTimer); //TODO: Дальше еще ожидаеи какое-то время чтобы закончить выполнение для последней задачи и уже выходим из системы...
        long taskManagerCancel = 30000;

        System.out.println("TimerTask >> started");
        taskManager.scheduleAtFixedRate(execute, 10000, 3000);  // TODO: каждые 3-секунд
        mainTimer.schedule(cancelled, taskManagerCancel);                  // TODO: через 30-секунд
        mainTimer.schedule(exit, taskManagerCancel+10000);           // TODO: через 10-секунд
    }
}


class ExecuteTimer extends TimerTask {

    @Override
    public void run() {
        System.out.print("          >> execute at: " + new Date() + " ... ");
        try {
            Thread.sleep(2000); //TODO: assuming it takes 2-secs to complete the task (2-секунды)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finished at: " + new Date());
    }
}

class CancelledTimer extends TimerTask {

    private Timer timer;

    public CancelledTimer(Timer timer) {
        this.timer = timer;
    }

    public void run() {
//        TimerTask execute = new ExecuteTimer();      //TODO: Запускаем крон и через 10-секунд с повторением в 5-секунд начинаем выполнять наши задачи...
//        timer.scheduleAtFixedRate(execute, 10000, 3000); //TODO: каждые 3-секунд

        timer.cancel();
        System.out.println("TimerTask << cancell");
    }
}

class ExitTimer extends TimerTask {

    private Timer timer;

    public ExitTimer(Timer timer) {
        this.timer = timer;
    }

    public void run() {
        timer.cancel();
//        System.out.println("TimerTask << cancell");
    }
}
