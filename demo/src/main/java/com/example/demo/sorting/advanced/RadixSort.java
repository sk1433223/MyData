package com.example.demo.sorting.advanced;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 阿康
 * @ClassName: RadixSort
 * @Description: 基数排序
 * 基数排序是非比较的排序算法，对每一位进行排序，从最低位开始排序，复杂度为O(kn),为数组长度，k为数组中的数的最大的位数；
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] array = {23, 21, 24, 22, 27, 25, 29, 26, 20, 28};
        int[] ints = radixSort(array);
        System.out.println(Arrays.toString(ints));

    }

    /*
     * 算法描述:
     * 取得数组中的最大数，并取得位数；
     * arr为原始数组，从最低位开始取每个位组成radix数组；
     * 对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     */

    /**
     * 基数排序
     */
    public static int[] radixSort(int[] array) {
        if (array == null || array.length < 2)
            return array;
        // 1.先算出最大数的位数；
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            bucketList.add(new ArrayList<>());
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int value : array) {
                int num = (value % mod) / div;
                bucketList.get(num).add(value);
            }
            int index = 0;
            for (ArrayList<Integer> integers : bucketList) {
                for (Integer integer : integers) array[index++] = integer;
                integers.clear();
            }
        }
        return array;
    }
}
