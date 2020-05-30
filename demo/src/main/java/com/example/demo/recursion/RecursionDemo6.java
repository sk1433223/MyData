package com.example.demo.recursion;

import java.util.Arrays;

/**
 * @Name：阿康
 * @Description：递归实现归并排序
 * @Date：2020/1/20 12:52
 */
public class RecursionDemo6 {

    public static void main(String[] args) {

        int[] c = {2, 4, 3, 7, 1, 9, 5};
        mergeSort(c, 0, c.length - 1);
        System.out.println(Arrays.toString(c));
    }

    public static void mergeSort(int[] c, int start, int last) {
        if (last > start) {
            // 数组分组
            int mid = start + (last - start) / 2;
            // 对左边数组排序
            mergeSort(c, start, mid);
            // 右边数组排序
            mergeSort(c, mid + 1, last);
            // 归并数组
            merge(c, start, mid, last);
        }
    }

    private static void merge(int[] c, int start, int mid, int last) {
        // 定义临时数组
        int[] temp = new int[last - start + 1];
        // 定义左边数组下标
        int i = start;
        // 定义右边数组下标
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= last) {
            if (c[i] < c[j]) {
                temp[k++] = c[i++];
            } else {
                temp[k++] = c[j++];
            }
        }

        // 把左边剩余数组元素移入到新数组中
        while (i <= mid) {
            temp[k++] = c[i++];
        }

        // 把右边剩余元素移到新数组中
        while (j <= last) {
            temp[k++] = c[j++];
        }

        // 把新数组中的数覆盖到c数组中
        if (temp.length >= 0) {
            System.arraycopy(temp, 0, c, start, temp.length);
        }
    }

}
