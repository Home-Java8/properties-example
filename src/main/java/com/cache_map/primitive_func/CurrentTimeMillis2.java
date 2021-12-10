package com.cache_map.primitive_func;

public class CurrentTimeMillis2 {

    public static void main(String[] args) {
        for (int session=0; session<10; session++) {
            count1 ++;
            if (count1<3) {
                System.out.println("######################");
            }
        }
        System.out.println();
        for (int session=0; session<10; session++) {
            count1 ++;
            if (count1<3) {
                System.out.println("######################");
            }
        }
        System.out.println();
        count1 = 0;
        for (int session=0; session<10; session++) {
            count1 ++;
            if (count1<3) {
                System.out.println("######################");
            }
        }
    }

    static int count1 = 0;

}
