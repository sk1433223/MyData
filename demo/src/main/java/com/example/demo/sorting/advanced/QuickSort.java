package com.example.demo.sorting.advanced;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] array = {3,1,4,2,7,5,9,6,0,8};
        quickSort(array);
        for (int i : array) {
            System.out.print(array[i]+"  ");
        }

    }

    /**
     * 算法实现
     */

    private static void recQuickSort (int[] array , int left,int right) {
        if(right <= left){
            return;
        }else {
            int partition = partitionIt(array, left, right);
            recQuickSort(array, left, partition-1);
            recQuickSort(array,partition+1,right);

        }
    }
    /**
     * {3,1,4,2,7,5,9,6,0,8};
     */
    private static int partitionIt(int[] array,int left,int right) {
        int i = left;
        int j = right+1;
        int pivot = array[left]; // 基准元素(头元素)
        while (true) {
            while (i < right && array[++i] < pivot){
                System.out.print("");
            }
            while (j > 0 && array[--j] > pivot) {
                System.out.print("");
            }
            if (i >= j){
                break;
            }else {
                swap(array,i,j);
            }
        }
        swap(array,left,j); // 基准元素交换
        return j;
    }

    public static void quickSort(int [] array) {
        recQuickSort(array,0,array.length -1);
    }

    /**
     *
     * 数组中两个元素交换
     * @param array 排序数组
     * @param i 交换下标
     * @param j 交换下标
     */
    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
