package com.example.demo;

import javax.xml.bind.SchemaOutputResolver;


public class Demo {

    public static void main(String[] args) {
        System.out.println("我写了一句话");
        demoString1();
    }

    public static void demoString1() {
        String s1 = "";
        String s2 = null;
        System.out.println(s1.length());
        System.out.println(s2.length());
    }
}
