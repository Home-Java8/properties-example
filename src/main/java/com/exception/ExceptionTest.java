package com.exception;

public class ExceptionTest {

    public static void main(String[] args) {

        Arithmetic arithmetic = new Arithmetic();

        System.out.println("1");
        try {
            System.out.println("2");
//            int a = 100 / 0;

//            Arithmetic.exception("ERR");
            System.out.println( arithmetic.plus(1,0) );

//            throw new ArithmeticException("ERR");
        } catch (ArithmeticException ex) {
            System.err.println("a + b = ");
        } catch (Arithmetic a) {
            System.err.println(a.getArg());
//            throw new Arithmetic("0");
        }
        System.out.println("3");

        // /////////////////////////
        System.out.println();

        try {
            System.out.println( plus(1, 1) );
        } catch (Arithmetic a) {
            System.err.println(a.getArg());
        }
    }

    public static int plus(int a, int b) throws Arithmetic {
        Arithmetic arithmetic = new Arithmetic();

        try {
            if (true) { //TODO:  true/false
                throw new Arithmetic("ERR");
            }
            System.out.println("00");
            return arithmetic.plus(a, b);
        } catch (Arithmetic e) {
            throw new Arithmetic("00");
        }
    }
}


class Arithmetic extends Exception {

    private String arg;

    public Arithmetic() {}

    public Arithmetic(String arg) {
        this.arg = arg;
    }

    public static void exception(String arg) {
        throw new ArithmeticException(arg);
    }

    public String getArg() {
        return arg;
    }

    //    public int plus(int a, int b) throws ArithmeticException {
    public int plus(int a, int b) throws Arithmetic {
        if (a==0 || b==0) {
//            throw new ArithmeticException("0");
            throw new Arithmetic("0");
        }
        System.out.print(a + " + " + b + " = ");
        return a + b;
    }

}