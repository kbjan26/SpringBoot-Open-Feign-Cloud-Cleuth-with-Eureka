package com.example.springbootsleuthzipkin;

public class ExceptionExample {

    public static void main(String[] args) {
        try {
            exceptionthrow();
            System.out.println("Nothing happened");
        }catch(Exception e){
            System.out.println("Elegantly caught");
        }
    }

    public static String exceptionthrow() {

        exceptionthrowCaller();
        return new String();
    }

    public static void exceptionthrowCaller() {
        try {
            Integer num1 = 4;
            Integer num2 = 4;
            Integer num3 = num1 / num2;
        } catch (Exception e) {
            throw new RuntimeException("Exception thrown from caller");
        }

    }
}
