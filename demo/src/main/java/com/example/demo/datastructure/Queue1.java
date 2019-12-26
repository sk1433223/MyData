package com.example.demo.datastructure;

/**
 * @author AK
 * @ClassName: Queue
 * @Description: 单向队列（Queue）：只能在一端插入数据，另一端删除数据。
 * @date 2019/12/25 15:24
 */
public class Queue1 {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue(3);
        mq.insert(1);
        mq.insert(2);
        mq.insert(3);
        //mq = [1,2,3]
        //长度:3
        System.out.println("长度:" + mq.getSize());

        // 1
        System.out.println(mq.peekFront());
        mq.remove();
        // 2
        System.out.println(mq.peekFront());

        mq.insert(4);
        // mq=[4,2,3]
        mq.insert(6);
        // 队列已满

    }
}

class MyQueue {

    /**
     * @param queArray[]
     * @param maxSize 队列大小
     * @param front 队头
     * @param rear 队尾
     * @param nItems 实际数目
     */
    private Object[] queArray;
    private int maxSize;
    private int front;
    private int rear;
    private int nItems;

    /**
     * 初始化队列
     *
     * @param size
     */
    public MyQueue(int size) {
        this.maxSize = size;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * 入队
     *
     * @param value
     */
    public void insert(int value) {
        if (isFull()) {
            System.out.println("队列已满!");
        } else {
            if (rear == maxSize - 1) {
                rear = -1;
            }
            queArray[++rear] = value;
            nItems++;
        }
    }

    /**
     * 出队
     *
     * @return
     */
    public Object remove() {
        Object removeValue = null;
        if (!isEmpty()) {
            removeValue = queArray[front++];
            if (front == maxSize) {
                front = 0;
            }
            nItems--;
            return removeValue;
        }
        return null;
    }

    /**
     * 获取队头元素
     *
     * @return
     */
    public Object peekFront() {
        return queArray[front];
    }

    /**
     * 判断队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return (nItems == maxSize);
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return (nItems == 0);
    }

    /**
     * 返回队列大小
     *
     * @return
     */
    public int getSize() {
        return nItems;
    }

}
