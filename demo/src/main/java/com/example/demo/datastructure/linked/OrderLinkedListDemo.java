package com.example.demo.datastructure.linked;


/**
 * 有序链表
 */
public class OrderLinkedListDemo {

    public static void main(String[] args) {
        OrderLinkedList order = new OrderLinkedList();
        order.insert(10);
        order.insert(8);
        order.insert(11);
        order.disPlay();
        order.delectHead();
        order.disPlay();

    }
}

/**
 * 有序链表的实现
 */
class OrderLinkedList {

    private Node head;
    private int size;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public OrderLinkedList() {
        head = null;
        size = 0;
    }

    /**
     * 有序链表
     *
     * @param data
     */
    public void insert(int data) {
        Node newNode = new Node(data);
        Node previous = null;
        Node curent = head;
        // 判断添加节点位置
        while (curent != null && data > curent.data) {
            previous = curent;
            curent = curent.next;
        }

        if (previous == null) {
            head = newNode;
            head.next = curent;
            size++;
        } else {
            newNode.next = curent;
            previous.next = newNode;
            size++;
        }
    }

    /**
     * 删除头节点
     */
    public Object delectHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    /**
     * 循环遍历
     */
    public void disPlay() {
        if (size > 0) {
            Node curent = head;
            int tmpsize = size;
            if (tmpsize == 1) {
                System.out.println("[" + head + "]");
                return;
            }
            while (tmpsize > 0) {
                if (curent == head) {
                    System.out.print("[" + curent.data + "->");
                } else if (curent.next == null) {
                    System.out.print(curent.data + "]");
                } else {
                    System.out.print(curent.data + "->");
                }
                tmpsize--;
                curent = curent.next;
            }
            System.out.println();
        } else {
            System.out.println("[]");
        }
    }

}
