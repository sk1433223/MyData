package com.example.demo.datastructure.iterator;

import java.util.Iterator;

/**
 * 实现有迭代器的链表
 *
 * @param <T>
 */
public class LinkedWithIterator<T> implements ListWithIteratorInterface<T> {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        private T data;
        private Node next;

        public Node(T data) {
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

    /**
     * 内部类的形式定义迭代器
     */
    private class IteratorForLinkedList implements Iterator<T> {

        private Node nextNode;

        public IteratorForLinkedList() {
            nextNode = head;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                Node rs = nextNode;
                nextNode = nextNode.next;
                return rs.data;
            } else {
                return null;
            }
        }
    }


    @Override
    public Iterator<T> getIterator() {
        return new IteratorForLinkedList();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void addHeader(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    @Override
    public void addTail(T data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }

    }
}
