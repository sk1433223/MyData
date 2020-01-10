package com.example.demo.sorting;

import java.lang.reflect.Array;

/**
 * @Description: 选择排序
 *      原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中
 *      继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 * @author AK
 * @ClassName: SelectionSort
 * @date 2019/12/30 16:33
 */
public class SelectionSort {

    public static void main(String[] args) {

        int [] array = {3,1,4,2,7,5,9};

        int[] arr = selectSort(array);
        for (int i=0;i<array.length;i++){
            System.out.println(arr[i]);
        }

    }

    public static int[] selectSort(int[] array){
        if(array == null){
            return null;
        }
        for (int i=0;i<array.length;i++){
            int minIndex = i;
            for (int j=i;j<array.length;j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
