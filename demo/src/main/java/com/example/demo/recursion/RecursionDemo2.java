package com.example.demo.recursion;

import java.util.Scanner;

/**
 * @Name：阿康
 * @Description：递归实现数字三角的路径
 * @Date：2020/1/17 17:25
 */
public class RecursionDemo2 {
    // 存放三角形数字
    private static int[][] data;
    // 三角形数字行数
    private static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字三角形的高度：");
        n = sc.nextInt();
        // 实例化二维数组
        data = new int[n][n];
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print("输入第"+i+"行，第"+j+"列数字");
                data[i-1][j-1] = sc.nextInt();
            }
        }
        System.out.println("-----------------数字三角行显示---------------------");
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print(data[i-1][j-1]+"\t");
            }
            System.out.println();
        }
        System.out.println("-----------------最终显示结果---------------------");
        int rs = maxSum(1,1);
        System.out.println("结果："+ rs);

    }

    /**
     * 使用递归实现
     * @param i
     * @param j
     * @return
     */
    public static int maxSum(int i,int j){
        if(i == n){
            return  data[i-1][j-1];
        }else {
            int x = maxSum(i+1,j);
            int y = maxSum(i+1,j+1);
            return Math.max(x,y)+data[i-1][j-1];
        }
    }

}
