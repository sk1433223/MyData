package com.example.demo.sorting.advanced;

import java.util.Arrays;

/**
 * @author sk143
 * 希尔排序算法
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {99, 98, 97, 96, 95, 94, 11, 10, 9, 8, 7, 6, 5, 4,};
        int[] ints = shellSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 希尔排序
     *
     * @param array 排序数组
     * @return array
     */
    public static int[] shellSort(int[] array) {
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = array[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                array[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        return array;
    }
}
