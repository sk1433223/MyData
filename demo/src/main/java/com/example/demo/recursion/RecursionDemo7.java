package com.example.demo.recursion;

/**
 * @Name：阿康
 * @Description：消除递归
 * @Date：2020/1/20 14:12
 */
public class RecursionDemo7 {

    public static void main(String[] args) {

        System.out.println(addn(100));
    }

    /**
     * 1+2+3+...+n的值
     * @param n
     * @return
     */
    public static int addn(int n){
        if (n == 1){
            return 1;
        }else{
            return n+addn(n-1);
        }
    }
}
