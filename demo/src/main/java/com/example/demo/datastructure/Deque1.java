package com.example.demo.datastructure;


/**
 * @author AK
 * @ClassName: Deque1
 * @Description: 双向队列（Deque）：每一端都可以进行插入数据和删除数据操作。
 * @date 2019/12/26 15:20
 */
public class Deque1 {
    public static void main(String[] args) {

        // 1.把双端当栈使用
        // 2.把双端队列当普通栈使用

        MyDeQue myDeQue = new MyDeQue();
        myDeQue.addFirst(1);
        myDeQue.addFirst(2);
        myDeQue.addlast(3);
        myDeQue.addlast(4);
        myDeQue.addlast(5);
        myDeQue.addlast(6);
        myDeQue.addlast(7);
        myDeQue.addlast(48);
        myDeQue.addlast(9);
        myDeQue.addlast(0);
        myDeQue.addlast(11);
        myDeQue.addlast(12);
        myDeQue.addlast(412);
        myDeQue.addlast(413);
        myDeQue.addlast(414);
        myDeQue.addlast(4155);
        myDeQue.addlast(416);
        myDeQue.addlast(417);

        while (!myDeQue.isEmpty()) {
            System.out.println(myDeQue.removeFirst());
        }


    }
}

class MyDeQue {

    /**
     * 内部封装数组
     */
    private Object[] elements;

    /**
     * 队列默认的容量大小
     * 2^2^2 = 16
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 扩容基数
     */
    private static final int EXPAND_BASE = 2;

    private int maxSize;

    /**
     * 头部下标
     */
    private int head;

    /**
     * 尾部下标
     */
    private int tail;

    /**
     * 构造方法初始化
     */
    public MyDeQue() {
        this.elements = new Object[DEFAULT_CAPACITY];
        maxSize = 16;
        head = 0;
        tail = 0;
    }

    /**
     * 取模计算,实现指针循环
     *
     * @param index 下标
     * @return
     */
    public int getMod(int index) {
        if (index < 0) {
            index = index + maxSize;
        }
        if (index >= maxSize) {
            index = index - maxSize;
        }
        return index;
    }

    /**
     * 头部插入
     *
     * @param data
     */
    public void addFirst(Object data) {
        //head = getMod(head-1);
        head = (head - 1) & (maxSize - 1);
        elements[head] = data;
        if (head == tail) {
            expand();
        }
    }

    /**
     * 尾部插入
     *
     * @param data
     */
    public void addlast(Object data) {
        elements[tail] = data;
        tail = getMod(tail + 1);
        if (tail == head) {
            expand();
        }
    }

    /**
     * 头部移除
     *
     * @return
     */
    public Object removeFirst() {
        Object removeObj = null;
        if (head != tail) {
            removeObj = elements[head];
            elements[head] = null;
            head = getMod(head + 1);
        }
        return removeObj;
    }

    /**
     * 实现尾部移除
     */
    public Object removeLast() {
        Object removeObj = null;
        if (head != tail) {
            tail = getMod(tail - 1);
            removeObj = elements[tail];
            elements[tail] = null;
        }
        return removeObj;
    }

    /**
     * 获取头部元素
     */
    public Object peekFirst() {
        if (tail != head) {
            return elements[head];
        } else {
            return null;
        }
    }

    /**
     * 获取尾部元素
     */
    public Object peekLast() {
        if (tail != head) {
            return elements[getMod(tail - 1)];
        } else {
            return null;
        }
    }

    public void expand() {
        int newSize = maxSize << 1;
        Object[] newObject = new Object[newSize];

        // 获取前端插入数据个数
        int n = maxSize - head;
        // 获取后端插入数据个数==head

        // 将arr1数组里从索引为2的元素开始, 复制到数组arr2里的索引为5的
        // 位置, 复制的元素个数为10个.
        System.arraycopy(elements, head, newObject, 0, n);
        System.arraycopy(elements, 0, newObject, n, head);

        head = 0;
        tail = maxSize;

        this.maxSize = newSize;
        this.elements = newObject;
    }

    // 取出元素个数
    public int getSize() {
        return getMod(tail - head);
    }

    //
    public boolean isEmpty() {
        return (tail == head);
    }

}
