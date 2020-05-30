package com.example.demo.sorting.advanced;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 阿康
 * @ClassName: BucketSort2
 * @Description:
 */
public class BucketSort2 {

    public static void main(String[] args) {

        Integer[] arr = {52, 72, 32, 52, 41, 81, 62, 24, 13, 12};
        int max = Collections.max(Arrays.asList(arr));
        System.out.println("arrMax=" + max);
        int[] array = {52, 72, 32, 52, 41, 81, 62, 24, 13, 12};
        BucketSort2 bs = new BucketSort2(100, array);
        bs.sort();
        bs.sortOut();//输出打印排序

    }


    private int[] buckets;
    private int[] array;

    /**
     * 定义的range会影响数组的值大小(即数组最大值不能大于range)
     *
     * @param range 定义桶大小
     * @param array 排序数组
     */
    public BucketSort2(int range, int[] array) {
        this.buckets = new int[range];
        this.array = array;
    }

    /* 排序 */
    public void sort() {
        if (array != null && array.length > 1) {
            for (int value : array) {
                buckets[value]++;
            }
        }
    }

    /* 排序输出 */
    public void sortOut() {
        // 倒序输出数据
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = 0; j < buckets[i]; j++) {
                System.out.print(i + "\t");
            }
        }
    }
}
