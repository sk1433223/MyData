package com.example.demo.datastructure.linked;


/**
 * 单向链表的实现
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList single = new SingleLinkedList();
        single.addhead("A");
        single.addhead("B");
        single.addhead("C");
        single.addhead("D");

        single.disPlay();

        single.delect("A");

        single.disPlay();

    }
}

/**
 * 单向链表
 */
class SingleLinkedList {
    private int size;// 链表节点数
    private Node head;// head就是节点指针(引入Node类型)

    public SingleLinkedList() {
        size = 0;
        head = null;
    }

    /**
     * 内部类Node
     */
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
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

    public int getSize() {
        return size;
    }

    /**
     * 添加节点
     *
     * @param data
     * @return
     */
    public Object addhead(Object data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
        } else {
            // 把上一个头节点,付给新节点的指针
            newNode.next = head;
            // 把新节点付给头结点
            head = newNode;
        }
        size++;
        return newNode;
    }

    /**
     * 删除头节点
     *
     * @return
     */
    public Object delectHead() {
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    /**
     * 查找指定节点对象
     *
     * @param data
     * @return
     */
    public Node find(Object data) {
        Node curent = head;
        int tmpSize = size;
        while (tmpSize > 0) {
            if (data.equals(curent.data)) {
                return curent;
            } else {
                curent = curent.next;
            }
            tmpSize--;
        }
        return null;
    }

    /**
     * 链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 删除指定元素
     *
     * @param value
     * @return
     */
    public boolean delect(Object value) {
        if (isEmpty()) {
            return false;
        }
        Node curent = head;
        Node previous = head;
        while (!value.equals(curent.data)) {
            // 从头到尾没有找到
            if (curent.next == null) {
                return false;
            } else {
                // 扫描到当前节点往下一个节点移动
                previous = curent;
                curent = curent.next;
            }
        }
        // 循环终止后还执行语句,说明找到指定删除元素
        // 进行删除(判断是否头节点)
        if (curent == head) {
            head = head.next;
            size--;
        } else {
            previous.next = curent.next;
            size--;
        }
        return true;
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
