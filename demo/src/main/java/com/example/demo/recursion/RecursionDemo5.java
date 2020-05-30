package com.example.demo.recursion;

import java.util.Arrays;

/**
 * @Name：阿康
 * @Description：
 * @Date：2020/1/19 16:04
 */
public class RecursionDemo5 {


    public static void main(String[] args) {

        int[] a = {1, 3, 5, 6, 9};
        int[] b = {2, 4, 7};
        int[] sort = sort(a, b);
        System.out.println(Arrays.toString(sort));
    }

    /**
     * 归并两个有序数组
     *
     * @param a 第一个数组
     * @param b 第二个数组
     * @return
     */
    public static int[] sort(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int aNum = 0, bNum = 0, cNum = 0;
        // 判断比照元素个数
        while (aNum < a.length && bNum < b.length) {
            if (a[aNum] > b[bNum]) {
                c[cNum++] = b[bNum++];
            } else {
                c[cNum++] = a[aNum++];
            }
        }

        // 如果数组a全部赋值到c数组了，但是b还有元素，则将b剩下的全放到c数组
        while (aNum == a.length && bNum < b.length) {
            c[cNum++] = b[bNum++];
        }

        // 如果数组b全部赋值到c数组了，但是a还有元素，则将a剩下的全放到c数组
        while (bNum == b.length && aNum < a.length) {
            c[cNum++] = a[aNum++];
        }
        return c;
    }

}
