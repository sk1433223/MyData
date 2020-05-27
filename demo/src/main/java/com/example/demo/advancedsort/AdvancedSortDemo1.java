package com.example.demo.advancedsort;


import java.util.Arrays;

/**
 * @author sk143
 * 希尔排序
 */
public class AdvancedSortDemo1 {

    public static void main(String[] args) {

        int[] arr1 = {99,98,97,96,95,94,11,10,9,8,7,6,5,4,};
        int[] arr2 = {99,88,77,66,55,44,33,22,11,9,8,7,6,5,4,3,2,1};
        shellSort1(arr1);
        shellSort1(arr2);

    }

    /**
     * 插入排序实现
     */
    public static void insertSort(int[] data){
        System.out.println("排序前"+ Arrays.toString(data));
        // 外边界
        int outer;
        // 内边界
        int inner;
        // 临时变量
        int temp;

        for (outer=1;outer<data.length;outer++) {
            inner = outer;
            temp = data[outer];
            while (inner > 0 && temp < data[inner-1]) {
                data[inner] = data[inner-1];
                inner--;
            }
            data[inner] = temp;
        }
        System.out.println("排序后"+ Arrays.toString(data));
    }

    /**
     * 希尔排序
     * @param data 数组
     */
    public static void shellSort1(int[] data) {
        System.out.println("排序前"+ Arrays.toString(data));
        // 外边界
        int outer;
        // 内边界
        int inner;
        // 临时变量
        int temp;
        // 数组长度
        int len = data.length;

        for (int step = (int) (len/2.2); step > 0; step= (int) (step/2.2)) {
            for (outer = step;outer < len;outer++) {
                inner = outer;
                temp = data[outer];
                while (inner-step >= 0 && temp < data[inner-step]) {
                    data[inner] = data[inner-step];
                    inner = inner - step;
                }
                data[inner] = temp;
            }
            System.out.println("间隔数为"+step+"时的数组"+ Arrays.toString(data));
        }
        System.out.println("排序后"+ Arrays.toString(data));
    }
}
