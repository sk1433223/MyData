package com.example.demo.datastructure.linked;

/**
 * 使用双端链表实现列队
 */
public class QueueDoubleLinkedListDemo {

    public static void main(String[] args) {

        QueueDoubleLinkedList queueList = new QueueDoubleLinkedList();
        queueList.insert(1);
        queueList.insert(2);
        queueList.insert(3);
        System.out.println(queueList.delete());
        queueList.disPlay();
    }
}

class QueueDoubleLinkedList {

    private DoubleLinkedList doubleLinkedList;

    public QueueDoubleLinkedList() {
        doubleLinkedList = new DoubleLinkedList();
    }

    public void insert(Object data) {
        doubleLinkedList.addTail(data);

    }

    public Object delete() {
        return doubleLinkedList.delectHead();
    }

    public boolean isEmpty() {
        return doubleLinkedList.isEmpty();
    }

    public int getSize() {
        return doubleLinkedList.getSize();
    }

    public void disPlay() {
        doubleLinkedList.disPlay();
    }

}


