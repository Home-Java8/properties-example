package com.petrikainulainen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListContainsDemo {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    static void test1() {
        List<String> callServices = new ArrayList<>();
        callServices.add("NotYetAssigned-12");
        callServices.add("NotYetAssigned-34");
        callServices.add("DNblabla12");
        callServices.add("DNblabla34");

        System.out.println(callServices);

        System.out.println();

        Iterator<String> iCallServices = callServices.iterator();
        while (iCallServices.hasNext()) {
            String callService = iCallServices.next();
            if (callService.contains("NotYetAssigned") && !callService.contains("34")) iCallServices.remove();
        }
        System.out.println(callServices);
    }

    static void test2() {
//        List<String> list1 = Arrays.asList("a", "b", "c", "d");
//        List<String> list2 = Arrays.asList("A", "B", "C", "D");
//
//        for (String l1: list1) {
//            for (String l2: list2) {
//                System.out.println(l1 + " == " + l2);
//            }
//        }

        String tokenInfoMessage = "A";

        List<String> tokenResponseList = new ArrayList<>();
        List<String> tokens = new ArrayList();
        tokens.add("a");
        tokens.add("b");
        tokens.add("c");
        tokens.add("d");
        tokens.add("A");
        tokens.add("B");
        tokens.add("C");
        tokens.add("D");

        for (String token: tokens) {
            List<String> callServices = callService(tokenInfoMessage, token);

            Iterator<String> iCallServices = callServices.iterator();
            while (iCallServices.hasNext()) {
                String callService = iCallServices.next();
                if (!token.equals(callService)) iCallServices.remove();
            }
            tokenResponseList.addAll(callServices);
        }

        System.out.println("\n" + tokenResponseList);
    }

    static List<String> callService(String source, String token) {
        //response
        List<String> callServices = new ArrayList();
        callServices.add("A");
        callServices.add("B");
        callServices.add("C");
        callServices.add("D");

        for (String callService: callServices) {
            if (callService.equals(source)) {
                System.out.println(token + " < " + callService + source);
            } else {
                System.out.println(token + " < " + callService);
            }
        }

        return callServices;
    }
}
