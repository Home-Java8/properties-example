package com.cache_map.primitive_func;

public class PrimitiveTest2 {

    static MyClazz globalClazz = new MyClazz();

    public static void main(String[] args) {
//        MyClazz globalClazz = new MyClazz();

        System.out.println("1. '" + globalClazz.getField() + "'");
        func1(globalClazz);
        System.out.println("3. '" + globalClazz.getField() + "'");
        func2(globalClazz);
        System.out.println("5. '" + globalClazz.getField() + "'");
    }

    static void func1(MyClazz o) {
        o.setField("Aaaa");
        System.out.println("2. '" + o.getField() + "'");
    }

    static void func2(MyClazz o) {
        o.setField("Bbbb");
        System.out.println("4. '" + o.getField() + "'");
    }
}

class MyClazz {
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}