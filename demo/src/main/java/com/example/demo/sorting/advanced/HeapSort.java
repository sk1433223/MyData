package com.example.demo.sorting.advanced;

import java.util.Arrays;

/**
 * 堆排序是一种选择排序,他的平均复杂度为O(n Log n)
 * 思路步骤:
 * a.将无序列构建成一个堆,根据要求选择大顶堆和小顶堆;
 * b.将堆顶元素与末尾元素交换,将堆顶元素"沉"到数组末端;
 * c.重新调整结构,使其满足堆定义,继续交换堆顶元素与当前末尾元素交换,反复执行交换步骤,直到整个序列有序
 *
 * @author 阿康
 * @ClassName: HeapSort
 * @Description: 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] array = {3, 1, 4, 2, 7, 5, 9, 6, 0, 8};
        sort(array);
        System.out.println(Arrays.toString(array));

    }

    public static void sort(int[] arr) {
        for (int i = (arr.length >> 1) - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            swap(arr, 0, j);
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 调整大顶堆
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }

    /**
     * 数组元素交换
     */
    @SuppressWarnings("SameParameterValue")
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
