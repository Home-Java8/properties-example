package com.cache_map.primitive_func;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CurrentTimeMillis {

    private static long currentTimeSeconds = 0;

    private static boolean separatorTimeSeconds = false;

    private static int numberConsecutiveMissedBeats = 0;

    public static void main(String[] args) throws InterruptedException {
//        test1();

//        System.out.println();
//        test21();
//
//        System.out.println();
//        test22();
//
//        System.out.println();
//        test23();
//
//        System.out.println();
//        test24();

        System.out.println();
        test3();
    }

    static void test1() throws InterruptedException {
        for (int i=0; i<30; i++) {
            long currentTimeSeconds = CurrentTimeMillis.getCurrentTimeSeconds(2);
            boolean separatorTimeSeconds = CurrentTimeMillis.getSeparatorTimeSeconds();
            if (separatorTimeSeconds) System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> (" + System.currentTimeMillis() + ") " + currentTimeSeconds);
            Thread.sleep(100L);
        }
    }

//    static void test21() throws InterruptedException {
//        for (int i = 0; i < 3; i++) {
//            if (isHsmShortHeartbeatMissedCritical(2,5)) {
//                CurrentTimeMillis.numberConsecutiveMissedBeats = 0;
//                return;
//            }
//            int numberConsecutiveMissedBeats = CurrentTimeMillis.getNumberConsecutiveMissedBeats();
//            System.out.println("########################################################## " + numberConsecutiveMissedBeats);
//            Thread.sleep(300L);
//        }
//        CurrentTimeMillis.numberConsecutiveMissedBeats = 0;
//    }
//
//    static void test22() throws InterruptedException {
//        for (int i = 0; i < 30; i++) {
//            if (isHsmShortHeartbeatMissedCritical(2,5)) {
//                CurrentTimeMillis.numberConsecutiveMissedBeats = 0;
//                return;
//            }
//            int numberConsecutiveMissedBeats = CurrentTimeMillis.getNumberConsecutiveMissedBeats();
//            System.out.println("########################################################## " + numberConsecutiveMissedBeats);
//            Thread.sleep(100L);
//        }
//        CurrentTimeMillis.numberConsecutiveMissedBeats = 0;
//    }
//
//    static void test23() throws InterruptedException {
//        for (int i = 0; i < 30; i++) {
//            if (isHsmShortHeartbeatMissedCritical(2,5)) {
//                CurrentTimeMillis.numberConsecutiveMissedBeats = 0;
//                return;
//            }
//            int numberConsecutiveMissedBeats = CurrentTimeMillis.getNumberConsecutiveMissedBeats();
//            System.out.println("########################################################## " + numberConsecutiveMissedBeats);
//            Thread.sleep(500L);
//        }
//        CurrentTimeMillis.numberConsecutiveMissedBeats = 0;
//    }
//
//    static void test24() throws InterruptedException {
//        for (int i = 0; i < 2; i++) {
//            if (isHsmShortHeartbeatMissedCritical(2,5)) {
//                CurrentTimeMillis.numberConsecutiveMissedBeats = 0;
//                return;
//            }
//            int numberConsecutiveMissedBeats = CurrentTimeMillis.getNumberConsecutiveMissedBeats();
//            System.out.println("########################################################## " + numberConsecutiveMissedBeats);
//            Thread.sleep(100L);
//        }
//        CurrentTimeMillis.numberConsecutiveMissedBeats = 0;
//    }

    static void test3() {
        String names[] = {"Aaa", "Bbb", "Ccc", "Aaa", "Bbb", "Ccc", "Ddd", "Eee"};

        Set<String> nameCryptoServices = new HashSet<>();
        for (String name: names) {
            boolean addName = nameCryptoServices.add(name);
            if (addName) System.out.println(name + " (" + addName + ")");
        }
    }

    static boolean isHsmShortHeartbeatMissedCritical(int intervalTimeSeconds, int hsmShortHeartbeatMissedCritical) {
//        CurrentTimeMillis.getCurrentTimeSeconds(intervalTimeSeconds);
//        if (CurrentTimeMillis.numberConsecutiveMissedBeats < hsmShortHeartbeatMissedCritical && !CurrentTimeMillis.getSeparatorTimeSeconds()) {
        if (CurrentTimeMillis.numberConsecutiveMissedBeats < hsmShortHeartbeatMissedCritical) {
            CurrentTimeMillis.numberConsecutiveMissedBeats++;
            return false;
        } else {
            CurrentTimeMillis.numberConsecutiveMissedBeats = 0;
            return true;
        }
    }

    public static int getNumberConsecutiveMissedBeats() {
        return numberConsecutiveMissedBeats;
    }

    public static synchronized long getCurrentTimeSeconds(int intervalTimeSeconds) {
        long currentTimeSeconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        if (CurrentTimeMillis.currentTimeSeconds == 0) CurrentTimeMillis.currentTimeSeconds = currentTimeSeconds;
        if (intervalTimeSeconds <= (currentTimeSeconds - CurrentTimeMillis.currentTimeSeconds)) {
            CurrentTimeMillis.currentTimeSeconds = currentTimeSeconds;
            CurrentTimeMillis.separatorTimeSeconds = true;
        } else {
            CurrentTimeMillis.separatorTimeSeconds = false;
        }
        return CurrentTimeMillis.currentTimeSeconds;
    }

    public static boolean getSeparatorTimeSeconds() {
        return separatorTimeSeconds;
    }

}
