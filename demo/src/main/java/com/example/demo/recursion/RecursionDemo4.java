package com.example.demo.recursion;

/**
 * @Name：阿康
 * @Description：双递归函数——实现汉诺塔
 * @Date：2020/1/19 13:48
 */
public class RecursionDemo4 {

    public static void main(String[] args) {

        move(3, "A", "B", "C");

    }

    /**
     * 汉诺塔问题
     *
     * @param dish 汉诺盘子个数
     * @param from 初始塔座
     * @param temp 中间塔座
     * @param to   目标塔座
     */
    public static void move(int dish, String from, String temp, String to) {
        // 边界条件
        if (dish == 1) {
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
        } else {
            move(dish - 1, from, to, temp);
            System.out.println("将盘子" + dish + "从塔座" + from + "移动到目标塔座" + to);
            move(dish - 1, temp, from, to);
        }
    }

}
