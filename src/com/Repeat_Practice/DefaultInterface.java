package com.Repeat_Practice;


/**
 * Created by anuj.jain02 on 1/8/17.
 */

interface Drawable{
    void draw();
    static void msg(){
        System.out.println("default method");
    }
}

abstract class A{
    abstract void a();
    abstract void b();
    abstract void c();
}

abstract class B extends A{
    @Override
    void a() {
        System.out.println("Anuj");
    }
}

class C extends B{

    @Override
    void b() {
        System.out.println("Binit");
    }

    @Override
    void c() {
        System.out.println("Charul");
    }
}

class Rectangle implements Drawable{

    @Override
    public void draw() {
        System.out.println("drawing rectangle");
    }

}
public class DefaultInterface {
    public static void main(String[] args) {
        //A a = new A(); abstract class cannot be instantiated
        Drawable rectangle = new Rectangle();
        rectangle.draw();
        Drawable.msg();

        C c = new C();
        c.a();
        c.b();
        c.c();
    }
}
