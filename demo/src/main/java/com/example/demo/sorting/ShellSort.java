package com.example.demo.sorting;

import java.util.Arrays;

/**
 * @author sk143
 * @Name：阿康
 * @Description：希尔排序算法
 * @Date：2020/1/23 15:02
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {99,98,97,96,95,94,11,10,9,8,7,6,5,4,};
        int[] ints = ShellSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] ShellSort(int[] array) {
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
