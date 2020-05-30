package com.example.demo.advancedsort;

import java.util.Arrays;

/**
 * @author sk143
 * @Name：阿康
 * @Description：快速排序
 * @Date：2020/1/25 17:07
 */
public class AdvancedSortDemo2 {
    public static void main(String[] args) {
        int[] arr = {99, 98, 97, 96, 95, 94, 11, 10, 9, 8, 7, 6, 5, 4,};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] data, int left, int right) {
        // 应用递归思路,边界条件
        // 边界条件
        if (left < right) {
            // 递归之前把数组data分为两部分,前部分元素都小于后半部分
            int partition = partitionLR(data, left, right);

            quickSort(data, left, partition - 1);
            quickSort(data, partition + 1, right);
        }
    }

    /**
     * 实现具体的数组分割功能
     */
    private static int partitionLR(int[] data, int left, int right) {

        int i = left;
        int j = right + 1;
        // 定义基准值 为数组第一个元素
        int base = data[left];
        while (true) {
            while (i < right && data[++i] < base) {
            }
            while (j > left && data[--j] > base) {
            }
            if (i >= j) {
                break;
            } else {
                swap(data, i, j);
            }
        }
        swap(data, left, j);
        return j;
    }

    public static void swap(int[] data, int i, int j) {
        int temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

}
