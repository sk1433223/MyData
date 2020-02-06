package com.example.demo.datastructure.hashtable;

/**
 * @author sk143
 * @Name：阿康
 * @Description：基于线性探测实现Hash表
 * @Date：2020/2/4 14:17
 */
public class MyHashTable {

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

    /**
     * 初始化
     *
     * @param arraySize
     */
    public MyHashTable(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        itemNum = 0;
        // 删除的数据项下标为-1
        delItem = new DataItem(-1);
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
        System.out.println("HashTable");
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
    public int hashFunction(int key) {
        return key % arraySize;
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
        int hashVal = hashFunction(data);

        while (hashArray[hashVal] != null && hashArray[hashVal].getData() != -1) {
            // 进入循环则表示该哈希值处被占用,
            // 进行"线性探索",寻找响铃的空位
            ++hashVal;
            hashVal %= arraySize;
        }
        // 循环结束后,表示找到哈希空位
        hashArray[hashVal] = item;
        itemNum++;
    }

    /**
     * 对数组进行扩容操作
     * 注:数组有固定大小,不能扩展,扩展只是新创建一个更大的数组,
     * 把旧数组的数移到新数组中实现扩展原理
     * 但是哈希表是根据数组大小给定数据的位置,所以这些数据项的哈希位置需要重新计算,而不能使用简单的拷贝
     * 这个过程叫做重新哈希化.这是一个耗时的过程,但实行扩展是必须的.
     */
    private void extendHashTable() {
        int num = arraySize;
        itemNum = 0;
        arraySize *= 2;
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
        int hashVal = hashFunction(data);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == data) {
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = delItem;
                itemNum--;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
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
        int hashVal = hashFunction(data);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == data) {
                return hashArray[hashVal];
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

}

/**
 * 定义数据项类
 */
class DataItem {

    /**
     * 数据项值
     */
    private int data;

    public DataItem(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
