package com.example.demo.datastructure.tree;

/**
 * @author sk143
 * @Name：阿康
 * @Description：测试类
 * @Date：2020/1/30 15:11
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinTree bt = new BinTree();
        bt.insert(40);
        bt.insert(36);
        bt.insert(37);
        bt.insert(85);
        bt.insert(49);
        bt.insert(88);

        Node root = bt.find(40);

        bt.midOrder(root);
        System.out.println();
        bt.delete(85);
        bt.midOrder(root);



    }
}
