package com.example.demo.recursion;

/**
 * 二分查找法
 */
public class RecursionDemo3 {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 9};
        int twoPoint = findTwoPoint(arr, 4);
        System.out.println(twoPoint);
        int search = search(arr, 4, 0, 5);
        System.out.println(search);

    }

    /**
     * 使用循环二分查找法
     *
     * @param arr 目标数组
     * @param key 查找元素
     */
    public static int findTwoPoint(int[] arr, int key) {
        int start = 0;
        int last = arr.length - 1;
        while (start <= last) {
            int mid = ((last - start) >> 1) + start;
            if (key == arr[mid]) {
                return mid;
            }
            if (key > arr[mid]) {
                start = mid + 1;
            }
            if (key < arr[mid]) {
                last = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归，二分查找法
     *
     * @param arr  目标数组
     * @param key  查找元素
     * @param low  下标
     * @param high 上标
     */
    public static int search(int[] arr, int key, int low, int high) {
        int mid = (high - low) / 2 + low;
        // 中间值为目标值则直接返回下标
        if (key == arr[mid]) {
            return mid;
        } else if (low > high) {
            return -1;
        } else {
            // 目标值比中间值小则更改范围
            if (key < arr[mid]) {
                return search(arr, key, low, mid - 1);
            }
            // 目标值比中间值大则更改范围
            if (key > arr[mid]) {
                return search(arr, key, mid + 1, high);
            }
        }
        return -1;
    }

}
