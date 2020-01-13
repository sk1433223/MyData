package com.example.demo.datastructure.iterator;


import java.util.Iterator;

public interface ListWithIteratorInterface<T> extends ListInterface<T> {

    /**
     * 获取迭代器方法
     */
    Iterator<T> getIterator();
}
