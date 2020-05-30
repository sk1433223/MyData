package com.example.demo.datastructure.linked;

/**
 * 使用单向链表实现栈
 */
public class StackLinkedList {
    public static void main(String[] args) {
        StackSingleLinkedList stack = new StackSingleLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
    }
}

class StackSingleLinkedList {
    private SingleLinkedList link;

    public StackSingleLinkedList() {
        link = new SingleLinkedList();
    }

    /**
     * 压栈
     *
     * @param data
     */
    public void push(Object data) {
        link.addhead(data);
    }

    /**
     * 弹出栈顶元素
     *
     * @return
     */
    public Object pop() {
        return link.delectHead();
    }

    /**
     * 判断空栈
     *
     * @return
     */
    public boolean isEmpty() {
        return link.isEmpty();
    }

    /**
     * 遍历
     */
    public void display() {
        link.disPlay();
    }
}

