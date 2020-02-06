package com.example.demo.datastructure.hashtable;

/**
 * @author sk143
 * @Name：阿康
 * @Description：线性探测测试
 * @Date：2020/2/5 13:49
 */
public class HashTableTest {

    public static void main(String[] args) {
        MyHashTable my = new MyHashTable(100);
        my.insert(new DataItem(12));
        my.insert(new DataItem(200));
        my.insert(new DataItem(120));
        my.insert(new DataItem(30));
        my.insert(new DataItem(50));

        my.display();

        DataItem dataItem = my.find(12);
        System.out.println();
        System.out.println(dataItem.getData());

        my.delete(12);
        System.out.println();

    }
}
