package com.cache_map.primitive_func;

public class PrimitiveTest1 {

    static String globalField = "";

    public static void main(String[] args) {
//        String globalField = "";

        System.out.println("1. '" + globalField + "'");
        func1(globalField);
        System.out.println("3. '" + globalField + "'");
        func2(globalField);
        System.out.println("5. '" + globalField + "'");
    }

    static void func1(String f) {
        f = "Aaaa";
        System.out.println("2. '" + f + "'");
    }

    static void func2(String f) {
        f = "Bbbb";
        System.out.println("4. '" + f + "'");
    }
}
