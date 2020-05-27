package com.example.demo.sorting;

/**
 * @author AK
 * @ClassName: InsertionSort
 * @Description: 插入排序
 *      原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，
 *      通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，
 *      需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。
 * @date 2019/12/30 16:52
 */

@SuppressWarnings("unused")
public class InsertionSort {

    public static void main(String[] args) {

        int [] array = {3,1,4,2,7,5,9,6,0,8};

        int[] arr = insertSort2(array);
        for (int i=0;i<array.length;i++){
            System.out.println(arr[i]);
        }

    }


    /**
     * 1.从第一个元素开始，该元素可以认为已经被排序；
     * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 5.将新元素插入到该位置后；
     * 6.重复步骤2~5。
     *         int [] array = {3,1,4,2,7,5,9,6,0,8};
     */
    public static int[] insertSort(int[] array){
        if (array == null){
            return  null;
        }
        int index ;// 循环外面定义可以节省内存
        int current;
        for (int i = 0; i < array.length-1 ; i++) {
            index = i;
            current = array[i+1];
            while(index >= 0 && current < array[index]){
                array[index+1] = array[index]; // 元素向后挪动
                index--;
            }
            array[index + 1] = current;
        }
        return array;
    }



    /**
     * @param  arr = {3,1,4,2,7,5,9,6,0,8};
     */
    public static int[] writeInsertDemo(int [] arr) {
        if (arr == null) {
            return null;
        }
        for (int i = 0; i < arr.length-1; i++) {
            int index = i;
            int tem = arr[index+1];
            while (index >= 0 && arr[index] > tem){
                arr[index+1] = arr[index];//最大值往后面移动一位
                index--;
            }
            arr[index+1] = tem;
        }
        return arr;
    }

    public static int[] insertSort2(int[] array){
        if (array == null){
            return  null;
        }
        int index ;// 循环外面定义可以节省内存
        int current;
        for (int i = 1; i < array.length; i++) {
            index = i;
            current = array[i];
            while(index > 0 && current < array[index-1]){
                array[index] = array[index-1];
                index--;
            }
            array[index] = current;
        }
        return array;
    }


}
