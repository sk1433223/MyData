package com.example.demo.datastructure.iterator;

import java.util.Iterator;

/**
 * 测试实现有迭代器的链表类的类
 */
public class IteratorLinkTest {

    public static void main(String[] args) {

        LinkedWithIterator<Integer> link = new LinkedWithIterator<>();
        link.addHeader(1);
        link.addHeader(2);
        link.addHeader(3);

        Iterator<Integer> iterator = link.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
