package com.ohgiraffers.section02.abstractclass;

public abstract class Product {

    private int nonStaticField;
    private static int staticField;

    public void setNonStaticField(int nonStaticField) {
        this.nonStaticField = nonStaticField;
    }

    public int getNonStaticField() {
        return nonStaticField;
    }

    public static int getStaticField() {
        return staticField;
    }

    public static void setStaticField(int staticField) {
        Product.staticField = staticField;
    }

    public Product() {

    }

    public void nonStaticField() {
        System.out.println("Product 클래스의 nonStaticMethod 호출함...");
    }

    public static void staticMethod() {
        System.out.println("Product 클래스의 staticMethod 호출함...");
    }

    public abstract void abstractMethod();

}
