package com.list_operation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Java8List2 {

    public static void main(String[] args) {
        List<MyToken1> fromVisa = new ArrayList<>(); // VISA
        fromVisa.add(new MyToken1("a", "a"));
        fromVisa.add(new MyToken1("b", "b"));
        fromVisa.add(new MyToken1("c", "c"));
        System.out.println("VISA: " + fromVisa);

        List<MyToken1> toImport = new ArrayList<>(); // DB
        toImport.add(new MyToken1("A", "A"));
        toImport.add(new MyToken1("b", "b"));
//        toImport.add(new MyToken1("B", "B"));
        toImport.add(new MyToken1("C", "C"));
        System.out.println("DB:   " + toImport);

        System.out.println("Import from Visa: " + exclude(fromVisa, toImport));
    }

    /**
     * К старой карте нет ниодного привязанного токена
     * to:   []
     *
     *
     * to:   [A, B, C]
     */
    static List<MyToken1> exclude(List<MyToken1> from, List<MyToken1> to) {
        for (MyToken1 t: to) {
            from = from.stream()
                    .filter(f -> !(f.refId.equals(t.refId) && f.requestorId.equals(t.requestorId)))
                    .collect(Collectors.toList());
        }
        return from;
    }
}


class MyToken1 {
    public MyToken1(String refId, String requestorId) {
        this.refId = refId;
        this.requestorId = requestorId;
    }

    public String refId;
    public String requestorId;

    @Override
    public String toString() {
        return "{" +
                refId +
                ", " + requestorId +
                '}';
    }
}