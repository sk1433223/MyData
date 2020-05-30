package com.example.demo.datastructure;


/**
 * 优先级队列
 */
public class PriQueue {

    public static void main(String[] args) {

        MyPriQueue my = new MyPriQueue(15);
        my.insert(1);
        my.insert(19);
        my.insert(9);

        while (!my.isEmpty()) {
            System.out.println(my.remove());
        }

    }
}

class MyPriQueue {

    private int maxSize;
    private int[] priQueArr;
    private int nElems;

    public MyPriQueue(int size) {
        priQueArr = new int[size];
        maxSize = size;
        nElems = 0;
    }

    /**
     * 插入数据(实现有序组合)
     *
     * @param value
     */
    public void insert(int value) {
        int j;
        if (nElems == 0) {
            priQueArr[nElems++] = value;
        } else {
            j = nElems - 1;
            while (j >= 0 && value > priQueArr[j]) {
                priQueArr[j + 1] = priQueArr[j];
                j--;
            }
            priQueArr[j + 1] = value;
            nElems++;
        }
    }

    /**
     * 获取顶端的值
     *
     * @return
     */
    public int peek() {
        if (nElems != 0) {
            return priQueArr[nElems - 1];
        } else {
            return -1;
        }
    }

    /**
     * 删除元素
     *
     * @return
     */
    public int remove() {
        int value = -1;
        if (nElems != 0) {
            value = priQueArr[nElems - 1];
            priQueArr[nElems - 1] = -1;
            nElems--;
        }
        return value;
    }

    public boolean isEmpty() {
        return nElems == 0;
    }
}
