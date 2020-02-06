package com.example.demo.datastructure.hashtable;

/**
 * @author sk143
 * @Name：阿康
 * @Description：链表地址法
 * @Date：2020/2/6 13:09
 */
public class HashChain {

    /**
     * 存放链表数组
     */
    private SortLink[] hashArray;

    /**
     * 数组长度
     */
    private int arraySize;

    /**
     * 初始化地址链表
     *
     * @param size
     */
    public HashChain(int size) {
        this.arraySize = size;
        hashArray = new SortLink[arraySize];
        // 创建每个数组的空链表
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortLink();
        }
    }

    public void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.println(i + " ");
            hashArray[i].disPlayLink();
        }
    }

    public int hashFunction(int key) {
        return key % arraySize;
    }

    /**
     * 实现链表地址值添加
     *
     * @param data
     */
    public void insert(LinkNode data) {
        int key = data.getKey();
        int hashVal = hashFunction(key);
        hashArray[hashVal].insert(data);
    }

    public LinkNode delete(int key) {
        int hashVal = hashFunction(key);
        LinkNode temp = find(key);
        hashArray[hashVal].delete(key);
        return temp;
    }

    /**
     * 查找制定数据项
     *
     * @param key
     * @return
     */
    public LinkNode find(int key) {
        int hashVal = hashFunction(key);
        // 查找目标哈希数组下标的链表里寻找制定数据项
        LinkNode node = hashArray[hashVal].find(key);
        return node;
    }

}
