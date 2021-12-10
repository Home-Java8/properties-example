//package com.generic;
//
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.google.gson.Gson;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.IOException;
//
//public class GenericTest {
//
//    static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
//
//    public static void main(String[] args) {
//        A a = new A();
//        a.setF1("Hello");
//        a.setF2("1000");
//
//        String strA = new Gson().toJson(a);
//        System.out.println(fun1(a));
//        System.out.println(fun2(a));
//
//    }
//
//    public static <T> T fromJson(String string, Class<T> clazz) throws IOException, JsonMappingException {
//        return OBJECT_MAPPER.readValue(string, clazz);
//    }
//
//    static String fun1(A a) {
//        return new Gson().toJson(a);
//    }
//
//    static <T> String fun2(T a) {
//        return new Gson().toJson(a);
//    }
//}
//
//class A {
//
//    private String F1;
//
//    private String F2;
//
//    public String getF1() {
//        return F1;
//    }
//
//    public void setF1(String f1) {
//        F1 = f1;
//    }
//
//    public String getF2() {
//        return F2;
//    }
//
//    public void setF2(String f2) {
//        F2 = f2;
//    }
//}