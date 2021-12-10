package com.generic;

public class StringReplaceTest {

    public static void main(String[] args) {
        String value = "lsdnfls.d...gmrofms.f.vs";

        System.out.println("value = " + value);

        value = value.replace(".", "");
        System.out.println("value = " + value);
    }

}
