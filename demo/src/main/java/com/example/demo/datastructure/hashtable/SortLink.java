package com.example.demo.datastructure.hashtable;

/**
 * @author sk143
 * @Name：阿康
 * @Description：实现有序链表
 * @Date：2020/2/5 18:24
 */
public class SortLink {
    private LinkNode first;

    public SortLink() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 删除指定数据项
     *
     * @param key
     */
    public void delete(int key) {
        LinkNode previous = null;
        LinkNode current = first;
        if (isEmpty()) {
            System.out.println("Linked is Empty!!");
            return;
        }
        while (current != null && current.getKey() != key) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = first.next;
        } else {
            //
            assert current != null;
            previous.next = current.next;
        }
    }

    public void insert(LinkNode node) {
        int key = node.getKey();
        LinkNode previous = null;
        LinkNode current = first;
        while (current != null && current.getKey() < key) {
            previous = current;
            current = current.next;
        }
        if (previous == null) {
            first = node;
        } else {
            previous.next = node;
        }
        node.next = current;
    }

    public LinkNode find(int key) {
        LinkNode current = first;
        while (current != null && current.getKey() <= key) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void disPlayLink() {
        System.out.println("link disPlay!");
        LinkNode current = first;
        while (current != null) {
            current.disPlayLink();
            current = current.next;
        }
        System.out.println();

    }

}

/**
 * 封装链表数据项
 */
class LinkNode {

    private int data;

    /**
     * 下一个数据项
     */
    public LinkNode next;

    public LinkNode(int data) {
        this.data = data;
    }

    public int getKey() {
        return data;
    }

    public void disPlayLink() {
        System.out.println(data + " ");
    }
}
