package com.example.demo.array;

/**
 * 有序数组
 */
public class OrderArray {

    public static void main(String[] args) {

        // 创建数组添加元素
        OrderArr orderArr = new OrderArr(50);
        orderArr.insert(23);
        orderArr.insert(13);
        //orderArr.insert(23);
        orderArr.insert(31);
        orderArr.insert(3);

        // 遍历查询
        orderArr.display();

        // 单个查询
        System.out.println(
                orderArr.find(23) + "\t" +
                        orderArr.find(3)
        );

        // 删除
        orderArr.delect(3);
        orderArr.display();


    }

}

class OrderArr {
    private long[] arr;
    private int nElems;

    /**
     * 有参构造
     *
     * @param manSize
     */
    public OrderArr(int manSize) {
        arr = new long[manSize];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    /***
     * 添加元素
     * @param value
     */
    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (arr[j] > value) {
                break;
            }
        }
        //元素位置向前移动
        for (int k = nElems; k > j; k--) {
            arr[k] = arr[k - 1];
        }
        arr[j] = value;
        nElems++;
    }

    /**
     * 遍历
     */
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 查询(二分查找法)
     *
     * @param searchKey
     * @return
     */
    public int find(long searchKey) {
        int lowerBound = 0;//起始位置索引值
        int upperBound = nElems - 1;//末尾位置索引值
        int curIn;//中间位置值索引
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (arr[curIn] == searchKey) {
                return curIn;
            } else if (lowerBound > upperBound) {
                return nElems;//未找到
            } else {
                if (arr[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }

    /**
     * 删除元素
     *
     * @param value
     * @return
     */
    public boolean delect(long value) {
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                arr[k] = arr[k + 1];
                nElems--;
            }
            return true;
        }
    }
}
