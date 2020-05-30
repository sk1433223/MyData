package com.example.demo.sorting.advanced;

import java.util.Arrays;

/**
 * @author AK
 * @ClassName: MergeSort
 * @Description: 归并排序算法实现
 * @date 2019/12/30 18:03
 */
public class MergeSort {


    /**
     * 测试
     */
    public static void main(String[] args) {
        int[] array = {3, 1, 4, 2, 7, 5, 9, 6, 0, 8};
        int[] arr = mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(arr[i]);
        }

    }

    /**
     * 归并排序
     *
     * @param array 排序数组
     * @return array
     * <p>
     * Arrays.copyOfRange(T[ ] original,int from,int to)
     * 将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组
     * (注意这里包括下标from，不包括上标to)
     * 这个方法在一些处理数组的编程题里很好用，效率和clone基本一致，都是native method，比利用循环复制数组效率要高得多。
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 归并排序 —— 将两段排序好的数组结合成一个新排序数组
     *
     * @param left  左数组
     * @param right 右数组
     * @return result
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }
        return result;
    }
}
