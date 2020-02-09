package com.example.demo.datastructure.heap;

/**
 * @author sk143
 * @Name：阿康
 * @Description：实现堆的结构
 * @Date：2020/2/6 21:39
 */
public class Heap {

    /**
     * 堆数组
     */
    private Node[] heapArray;

    /**
     * 数组最大长度
     */
    private int maxSize;

    /**
     * 数组数据长度
     */
    private int currentSize;

    /**
     * 构造函数初始化
     * @param size
     */
    public Heap (int size) {
        maxSize = size;
        currentSize = 0;
        heapArray = new Node[size];
    }

    public boolean isEmpty () {
        return currentSize == 0;
    }

    public boolean isFull () {
        return currentSize == maxSize;
    }

    public boolean insert (int key) {
        if (isFull()) {
            System.out.println("堆数组已满!");
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }
    /**
     * 向上取整
     */
    private void trickleUp(int index) {
        // 获取目标节点父节点索引
        int parent = (index-1) / 2;
        // 保存新加的尾节点
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getData() < bottom.getData()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove () {
        Node node = heapArray[0];
        // 使数组最后一个元素替换第一个元素
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return node;
    }

    /**
     * 向下调整
     * @param index
     */
    private void trickleDown(int index) {
        Node top = heapArray[index];
        int largeChildIndex;
        // currentSize/2表示是否到达叶子节点
        while (index < currentSize/2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            if (rightChildIndex < currentSize &&
                heapArray[leftChildIndex].getData() < heapArray[rightChildIndex].getData()) {
                largeChildIndex = rightChildIndex;
            }else {
                largeChildIndex = leftChildIndex;
            }
            if (top.getData() >= heapArray[largeChildIndex].getData()) {
                break;
            }
            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;
        }
        heapArray[index] = top;
    }

    /**
     * 改变数据
     * @param index 索引值
     * @param newValue 数据值
     * @return
     */
    public boolean change (int index,int newValue) {
        if (index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getData();
        heapArray[index].setData(newValue);
        if (oldValue < newValue) {
            trickleUp(index);
        }else {
            trickleDown(index);
        }
        return  true;
    }

    public void disPlayHeap () {
        System.out.println("heapArray format(遍历堆[数组]):");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getData()+"  ");
            }else {
                System.out.print("--");
            }
        }
    }

}

/**
 * 封装类
 */
class Node {

    private int data;

    /**
     * 构造初始化
     * @param key
     */
    public Node (int key) {
        data = key;
    }

    public int getData () {
        return data;
    }

    public void setData (int key) {
        data = key;
    }
}


