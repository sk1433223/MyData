package com.example.demo.datastructure.iterator;

/**
 * 实现迭代器的接口规范
 * @Describe
 */
public interface ListInterface<T> {

    /**
     * 返回当前链表的节点个数
     */
    int getSize();

    /**
     * 链表头部添加新节点
     */
    void addHeader(T data);

    /**
     * 链表尾部添加新节点
     */
    void addTail(T data);
}
