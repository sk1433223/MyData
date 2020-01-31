package com.example.demo.datastructure.tree;

/**
 * @author sk143
 * @Name：阿康
 * @Description：定义节点类
 * @Date：2020/1/28 17:10
 */
public class Node {

    /**
     * 节点数据
     */
    private int data;

    /**
     * 左节点
     */
    private Node leftChild;

    /**
     * 右节点
     */
    private Node rightChild;

    /**
     * 红黑树颜色属性,true表示红色,false代表黑色
     */
    private boolean color;

    /**
     * 该节点的父节点
     */
    private Node parent;


    public Node(int data) {
        this.data = data;
    }

    public Node(boolean color, int data, Node leftChild, Node rightChild, Node parent) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.color = color;
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", color=" + color +
                ", parent=" + parent +
                '}';
    }
}
