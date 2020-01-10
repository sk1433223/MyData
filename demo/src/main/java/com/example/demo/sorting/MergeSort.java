package com.example.demo.sorting;

import java.util.Arrays;

/**
 * @author AK
 * @ClassName: MergeSort
 * @Description: 归并排序
 * @date 2019/12/30 18:03
 */
public class MergeSort {


    public static void main(String[] args) {
        int [] array = {3,1,4,2,7,5,9};

        int[] arr = MergeSort(array);

        for (int i=0;i<array.length;i++){
            System.out.println(arr[i]);
        }
    }

    /**
     * 归并排序
     *
     * @param array
     * @return
     */
    public static int[] MergeSort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(MergeSort(left), MergeSort(right));
    }
    /**
     * 归并排序——将两段排序好的数组结合成一个排序数组
     *
     * @param left
     * @param right
     * @return
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
