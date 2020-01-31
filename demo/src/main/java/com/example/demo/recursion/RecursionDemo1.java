package com.example.demo.recursion;

import java.util.Scanner;

/**
 * @Name：阿康
 * @Description：递归实现阶乘
 * @Date：2020/1/17 13:57
 */
public class RecursionDemo1 {

    public static void main(String[] args) {

        System.out.println("请输入一个整数：");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 循环方法
        int rs = getFactorialFor(n);
        //递归方法
        getFactorial(n);

        System.out.println(n+"!是"+rs);

    }

    /**
     * 计算阶乘（循环方式）
     * @return
     */
    public static int getFactorialFor(int n){
        int temp = 1;
        if (n >= 0){
            for (int i = 1; i <= n ; i++) {
                temp = temp*i;
            }
        }else{
            return -1;
        }
        return temp;
    }

    /**
     * 使用递归实现阶乘
     * @param n
     * @return
     */
    public static int getFactorial(int n) {
        if (n >= 0) {
            if (n == 0) {
                System.out.println(n + "!=0");
                return 1;
            } else {
                System.out.println(n);
                int temp = n * getFactorial(n - 1);
                System.out.println(n + "!=" + temp);
                return temp;
            }
        }
        return -1;
    }
}




