package com.example.demo.sorting;


/**
 * 冒泡排序
 */
public class BubbleSort {


    public static void main(String[] args) {
        int [] array = {3,1,4,2,7,5,9,6,0,8};
        int[] ints = writeDemo(array);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    /**
     * 冒泡排序
     */
    @SuppressWarnings("unused")
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }


    public static int[] writeDemo(int [] arr) {
        if(arr == null) {
            return null;
        }
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i; j < arr.length - i -1 ; j++) {
                if(arr[j] > arr[j+1]){
                    int tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;
                }
            }
        }
        return arr;
    }

}
