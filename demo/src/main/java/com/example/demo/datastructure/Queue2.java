package com.example.demo.datastructure;

import java.util.Deque;

/**
 * @author AK
 * @ClassName: Queue2
 * @Description: 双向队列（Deque）：每一端都可以进行插入数据和删除数据操作。
 * @date 2019/12/26 15:20
 */
public class Queue2 {
    public static void main(String[] args) {

        Deque deque;
    }
}

class MyDeQue2 {

    /**
     * 内部封装数组
     */
    private Object[] elements;

    /**
     * 队列默认的容量大小
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 扩容基数
     */
    private static final int EXPAND_BASE = 2;

    /**
     * 头部下标
     */
    private int head;

    /**
     * 尾部下标
     */
    private int tail;

    public MyDeQue2() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

}
