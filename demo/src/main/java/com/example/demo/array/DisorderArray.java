package com.example.demo.array;


/**
 * 无序数组实现
 */
public class DisorderArray {

    public static void main(String[] args) {
        //创建数组添加元素
        ArrayClass arrayClass = new ArrayClass(20);
        arrayClass.insert(22);
        arrayClass.insert(21);
        arrayClass.insert(2);
        arrayClass.insert(12);

        //遍历无序数组
        arrayClass.display();

        //查询指定元素所在索引
        System.out.println(arrayClass.find(2));

        //删除元素
        //arrayClass.delete(12);

        // 排序
        arrayClass.bubbleSort();

        //遍历数组
        arrayClass.display();
    }

}

class ArrayClass {
    private long[] arr;
    private int nElems;

    /**
     * 创建数组大小,长度为零
     *
     * @param size
     */
    public ArrayClass(int size) {
        arr = new long[size];
        nElems = 0;
    }

    /**
     * 插入元素,数组长度加一
     *
     * @param value
     */
    public void insert(long value) {
        arr[nElems] = value;
        nElems++;
    }

    /**
     * 遍历数组
     */
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 查找元素值,如果没找到返回-1,找到了返回1元素下标值
     *
     * @param value
     * @return
     */
    public int find(long value) {
        int i;
        for (i = 0; i < nElems; i++) {
            if (value == arr[i]) {
                break;
            }
        }
        if (i == nElems) {
            return -1;
        } else {
            return i;
        }
    }

    /**
     * 输出指定元素
     *
     * @param value
     */
    public void delete(long value) {
        int i = find(value);
        if (i < 0) {
            System.out.println("未找到需要删除的元素值");
        } else {
            for (int j = i; j < nElems; j++) {
                arr[j] = arr[j + 1];
            }
        }
        nElems--;
        System.out.println("已删除" + value);
    }

    /**
     * 无序数组实现冒泡排序
     */
    public void bubbleSort() {
        for (int outer = nElems - 1; outer > 1; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (arr[inner] > arr[inner + 1]) {
                    long temp = arr[inner];
                    arr[inner] = arr[inner + 1];
                    arr[inner + 1] = temp;
                }
            }
        }
    }


}
