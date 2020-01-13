package com.example.demo.datastructure.linked;

/**
 * 双向链表
 */
public class DoubleWayLinkedListDemo {

    public static void main(String[] args) {


    }
}

/**
 * 双向链表实现
 */
class DoubleWayLinkedList{
    private int size;
    private Node head;
    private Node tail;

    public DoubleWayLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * 内部类Node
     */
    private class Node{
        private Object data; // 节点数据
        private Node next; // 节点指针,指向下一个节点
        private Node prev; // 节点指针,指向上一个节点

        public  Node(Object data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }
    public int getSize(){
        return size;
    }

    /**
     * 添加添加头部节点
     * @param data
     * @return
     */
    public Object addhead(Object data){
        Node newNode = new Node(data);
        if(size == 0){
            head = newNode;
            tail = newNode;
            newNode.next = null;
            newNode.prev = null;
        }else {
            // 把上一个头节点,付给新节点的指针
            newNode.next = head;
            // 双向链表节点
            newNode.prev = null;
            head.prev = newNode;

            // 把新节点付给头结点
            head = newNode;
        }
        size++;
        return newNode;
    }

    /**
     * 添加尾部节点
     * @param data
     * @return
     */
    public Object addTail(Object data){
        Node newNode = new Node(data);
        if(size == 0){
            head = newNode;
            tail = newNode;
            newNode.next = null;
            newNode.prev = null;
        }else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return newNode;
    }

    /**
     * 实现链表头节点删除，默认有节点
     * @return
     */
    public Object delectHead(){
        Object object = null;
        if (size == 0){
            return  null;
        }else if (size == 1){
            object = head.data;
            head = null;
            tail = null;
            size--;
        }else {
            object = head.data;
            head.prev = null;
            head = head.next;
            size--;
        }
        return object;
    }

    /**
     * 删除指定节点
     * @param value
     * @return
     */
    public boolean delect(Object value){
        if(isEmpty()){
            return false;
        }
        Node curent = head;
        Node previous = head;
        // 结束循环:1.链表从头到尾未扫描到
        //          2.找到节点
        while (!value.equals(curent.data)){
            if (curent.next == null){
                return false;
            }else {
                // 扫描当前节点往下一个节点移动
                previous =curent;
                curent = curent.next;
            }
        }
        // 循环终止，还继续执行语句则说明找到指定节点
        // 对节点进行删除
        if(size == 1){
            head = null;
            tail = null;
        }else if (curent == head){
            head = head.next;
            head.prev = null;
            size--;
        }else  if (curent == tail){
            previous.next = null;
            tail = previous;
            size--;
        }else {
            previous.next = curent.next;
            curent.next.prev = previous;
            size--;
        }
        return  true;
    }

    /**
     * 循环遍历
     */
    public void disPlay(){
        if (size > 0){
            Node curent = head;
            int tmpsize = size;
            if (tmpsize==1){
                System.out.println("["+head+"]");
                return;
            }
            while (tmpsize > 0){
                if (curent == head){
                    System.out.print("["+curent.data+"->");
                }else if (curent.next==null){
                    System.out.print(curent.data+"]");
                }else {
                    System.out.print(curent.data+"->");
                }
                tmpsize--;
                curent = curent.next;
            }
            System.out.println();
        }else{
            System.out.println("[]");
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }


}

