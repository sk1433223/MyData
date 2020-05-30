package com.example.demo.sorting.advanced;

import java.util.ArrayList;

/**
 * @author 阿康
 * @ClassName: BucketSort
 * @Description:
 */
public class BucketSort {

    public static void main(String[] args) {
        //int[] array = {1,7,1,5,4,1,8,1,1,9,9,19,19,91,9,9};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(13);
        arr.add(23);
        arr.add(25);
        arr.add(25);
        arr.add(27);
        arr.add(20);
        arr.add(29);
        arr.add(23);
        ArrayList<Integer> integers = bucketSort(arr, 10);
        for (Integer integer : integers) {
            System.out.print(integer + " ");
        }
    }

    /**
     * 桶排序
     */
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) {
            return array;
        }
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (Integer value : array) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<>());
        }
        for (Integer integer : array) {
            bucketArr.get((integer - min) / bucketSize).add(integer);
        }
        for (int i = 0; i < bucketCount; i++) {
            // 如果带排序数组中有重复数字时
            if (bucketSize == 1) {
                resultArr.addAll(bucketArr.get(i));
            } else {
                if (bucketCount == 1) {
                    bucketSize--;
                }
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                resultArr.addAll(temp);
            }
        }
        return resultArr;
    }
}
