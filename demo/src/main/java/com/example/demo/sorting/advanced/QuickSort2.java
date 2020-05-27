package com.example.demo.sorting.advanced;

/**
 * @ClassName: QuickSort2
 * @Description: 快速排序(了解)
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int [] array = {3,1,4,2,7,5,9,6,0,8};
        int[] arr = quickSort(array, 0, array.length - 1);
        if (arr != null) {
            for (int i : arr) {
                System.out.print(arr[i]+"  ");
            }
        }
    }

    /**
     * 快速排序方法
     * @param array 排序数组
     * @param start 头下标
     * @param end 尾下标
     *            (array.length < 1 || start < 0 || end >= array.length || start > end)
     *                                (start < 0 || end >= array.length || start > end)
     */
    public static int[] quickSort(int[] array, int start, int end) {
        if (start < 0 || end >= array.length || start > end) {
            return null;
        }

        int smallIndex = partition(array, start, end);
        if (smallIndex > start) {
            quickSort(array, start, smallIndex - 1);
        }
        if (smallIndex < end) {
            quickSort(array, smallIndex + 1, end);
        }
        return array;
    }
    /**
     * 快速排序算法——partition
     * @param array 排序数组
     * @param start 头下标
     * @param end 尾下标
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = (int) (start + Math.random() * (end - start + 1));
        int smallIndex = start - 1;
        swap(array, pivot, end);
        for (int i = start; i <= end; i++)
            if (array[i] <= array[end]) {
                smallIndex++;
                if (i > smallIndex)
                    swap(array, i, smallIndex);
            }
        return smallIndex;
    }

    /**
     * 交换数组内两个元素
     * @param array 排序数组
     * @param i 交换元素下标
     * @param j 交换元素下标
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
