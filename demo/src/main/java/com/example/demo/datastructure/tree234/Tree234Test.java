package com.example.demo.datastructure.tree234;

/**
 * @author sk143
 * @Name：阿康
 * @Description：
 * @Date：2020/2/3 16:00
 */
public class Tree234Test {

    public static void main(String[] args) {
        Tree234 tree234 = new Tree234();
        tree234.insert(20);
        tree234.insert(22);
        tree234.insert(15);
        tree234.insert(98);
        tree234.insert(45);
        tree234.insert(6);

        tree234.displayTree();

        int i = tree234.find(45);
        System.out.println(i);

    }
}
