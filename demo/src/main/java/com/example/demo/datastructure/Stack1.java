package com.example.demo.datastructure;

/**
 * @author AK
 * @ClassName: stack
 * @Description: 栈
 * @date 2019/12/25 13:55
 */
public class Stack1 {
    public static void main(String[] args) {

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

class LowerStack{

    private long [] elemData;
    private int maxSize;
    private int top;

    /**
     * 初始化栈
     * @param size
     */
    public LowerStack(int size){
        this.maxSize=size;
        elemData = new long[size];
        top = -1;
    }

    /**
     * 实现压栈,添加(进栈)
     * @param data
     */
    public void push(long data){
        if(top != maxSize-1){
            elemData[++top] = data;
        }
    }

    /**
     * 出栈,弹栈
     * @return
     */
    public long pop(){
        if(top == -1){
            return top;
        }
        return elemData[top--];
    }

    /**
     * 读栈,返回顶端元素
     * @return
     */
    public long peek(){
        if(top == -1 ){
            return top;
        }
        return elemData[top];
    }

    /**
     * 空栈判断
     * @return
     */
    public boolean isEmpty(){
        return (top == -1);
    }

    /**
     * 满栈判断
     * @return
     */
    public boolean isFull(){
        return (top == maxSize-1);
    }
}
