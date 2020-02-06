package com.example.demo.datastructure.hashtable;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * @author sk143
 * @Name：阿康
 * @Description：实现再哈希化
 * @Date：2020/2/5 14:38
 */
public class HashTableDouble {

    /**
     * DataItem类表示每个数据信息
     */
    private DataItem[] hashArray;

    /**
     * 数组初始大小
     */
    private int arraySize;

    /**
     * 数组实际储存数据项
     */
    private int itemNum;

    /**
     * 删除数据项
     */
    private DataItem delItem;

    public HashTableDouble() {
    }

    /**
     * 有参构造进行初始化
     *
     * @param size
     */
    public HashTableDouble(int size) {
        while (true) {
            if (isPrime(size)) {
                arraySize = size;
                break;
            }
            size++;
        }
        hashArray = new DataItem[arraySize];
        itemNum = 0;
        delItem = new DataItem(-1);
    }

    /**
     * 判断一个数是不是质数
     *
     * @param n
     * @return
     */
    private boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断数组是否满了
     *
     * @return
     */
    public boolean isFull() {
        return itemNum == arraySize;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return itemNum == 0;
    }

    /**
     * 打印内容
     */
    public void display() {
        System.out.println("HashTable:");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.print(hashArray[i].getData() + "  ");
            } else {
                System.out.print("**  ");
            }
        }
    }

    /**
     * 通过哈希函数得到下标
     *
     * @param key
     * @return
     */
    public int hashFunction1(int key) {
        return key % arraySize;
    }

    /**
     * 在哈希化
     *
     * @param key
     * @return
     */
    public int hashFunction2(int key) {
        return 5 - key % 5;
    }

    /**
     * 插入数据
     *
     * @param item
     */
    public void insert(DataItem item) {
        if (isFull()) {
            // 扩展哈希表
            System.out.println("哈希表已满,重新哈希化...");
            extendHashTable();
        }
        int data = item.getData();
        // 对data进行哈希化
        int hashVal = hashFunction1(data);
        // 再哈希化值
        int hashStep = hashFunction2(data);

        while (hashArray[hashVal] != null && hashArray[hashVal].getData() != -1) {
            // 进入循环则表示该哈希值处被占用,
            // 再哈希化
            hashVal += hashStep;
            hashVal = hashVal % arraySize;
        }
        // 循环结束后,表示找到哈希空位
        hashArray[hashVal] = item;
        itemNum++;
    }

    /**
     * 扩展数组
     */
    private void extendHashTable() {
        int num = arraySize;
        itemNum = 0;
        int temp = arraySize * 2;
        // 确保temp为一个质数
        while (true) {
            if (isPrime(temp)) {
                arraySize = temp;
                break;
            }
            temp++;
        }
        DataItem[] oldHashArray = hashArray;
        hashArray = new DataItem[arraySize];
        for (int i = 0; i < num; i++) {
            insert(oldHashArray[i]);
        }
    }

    /**
     * 删除数据项
     *
     * @param data
     * @return
     */
    public DataItem delete(int data) {
        if (isEmpty()) {
            System.out.println("Hash Table is Empty!");
            return null;
        }
        int hashVal = hashFunction1(data);
        int hashStep = hashFunction2(data);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == data) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = delItem;
                itemNum--;
                return temp;
            }
            hashVal += hashStep;
            hashVal = hashVal % arraySize;
        }
        return null;
    }

    /**
     * 查找指定数据项
     *
     * @param data
     * @return
     */
    public DataItem find(int data) {
        int hashVal = hashFunction1(data);
        int hashStep = hashFunction2(data);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == data) {
                return hashArray[hashVal];
            }
            hashVal += hashStep;
            hashVal = hashVal % arraySize;
        }
        return null;
    }

}
