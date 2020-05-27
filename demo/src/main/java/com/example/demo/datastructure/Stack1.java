package com.example.demo.datastructure;

import java.util.Stack;

/**
 * @author AK
 * @ClassName: stack
 * @Description: 栈
 * @date 2019/12/25 13:55
 */
public class Stack1 {
    public static void main(String[] args) {

        /* JDK栈 */
        Stack<String> stack = new Stack<>();
        stack.push("11");
        stack.push("22");
        stack.push("33");
        System.out.println(stack);

        /* 个人栈 */
        LowerStack ls = new LowerStack(3);

        ls.push(1);
        ls.push(2);
        ls.push(3);

        System.out.println(ls.peek());

        while (!ls.isEmpty()){
            System.out.println(ls.pop());
        }

        System.out.println(ls.isFull());
    }
}

/**
 * 实现简单的栈
 * 详:栈遵守元素 先进后出 ,不遵守就不是栈
 */
class LowerStack{

    /*
     * 利用数组实现栈
     * elemData 存放数组
     * maxSize 初始化栈大小
     * top 栈顶元素
     */
    private long [] elemData;
    private int maxSize;
    private int top;

    /**
     * 初始化栈
     * @param size 长度
     * maxSize 栈长度
     * elemData 数组大小
     * top 栈顶元素(-1代表空栈)
     */
    public LowerStack(int size){
        this.maxSize = size;
        elemData = new long[size];
        top = -1;
    }

    /**
     * 实现压栈,添加(进栈)
     * @param data 元素
     */
    public void push(long data){
        if(top != maxSize-1){
            elemData[++top] = data;
        }
    }

    /**
     * 出栈,弹栈
     */
    public long pop(){
        if(top == -1){
            return top;
        }
        return elemData[top--];
    }

    /**
     * 读栈,返回顶端元素
     */
    public long peek(){
        if(top == -1 ){
            return top;
        }
        return elemData[top];
    }

    /**
     * 空栈判断
     *
     *
     */
    public boolean isEmpty(){
        return (top == -1);
    }

    /**
     * 满栈判断
     */
    public boolean isFull(){
        return (top == maxSize-1);
    }
}
