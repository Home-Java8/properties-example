package com.list_operation;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8List1 {

    public static void main(String[] args) {
        List<String> aList = Arrays.asList("l","e","t","'","s");
        List<String> bList = Arrays.asList("g","o","e","s","t");

        System.out.println( new ArrayList<>(CollectionUtils.subtract(aList, bList)) );
    }

}
