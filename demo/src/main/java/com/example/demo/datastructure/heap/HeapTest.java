package com.example.demo.datastructure.heap;

/**
 * @author sk143
 * @Name：阿康
 * @Description：堆结构测试
 * @Date：2020/2/7 14:35
 */
public class HeapTest {
    public static void main(String[] args) {

        Heap heap = new Heap(100);
        heap.insert(55);
        heap.insert(33);
        heap.insert(66);
        heap.insert(11);
        heap.insert(22);
        heap.insert(99);
        heap.insert(8);

        heap.disPlayHeap();
        heap.remove();
        System.out.println();
        heap.disPlayHeap();

        heap.change(1,100);
        heap.disPlayHeap();
    }
}
