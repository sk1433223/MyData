package com.example.demo.arraylist;

import java.util.Arrays;

/**
 * ArrayList的实现()
 * @return OK
 */
public class MyArrayList {


    public static void main(String[] args) {
        ArrayListClass arrayListClass = new ArrayListClass();
        arrayListClass.add("1");
        arrayListClass.add("2");
        arrayListClass.add("3");
        arrayListClass.add("4");
        arrayListClass.add("5");
        arrayListClass.add("6");
        arrayListClass.add("7");
        arrayListClass.add("8");
        arrayListClass.add("9");
        arrayListClass.add("10");
        arrayListClass.add("11");

        arrayListClass.display();

        arrayListClass.find(11);

        arrayListClass.delete("10");
        arrayListClass.display();

    }

}

class ArrayListClass{

    private Object [] arr;
    private int nElems;

    public ArrayListClass(){
        arr = new Object[10];
        nElems = 0;
    }

    /***
     * 添加元素
     * @param o
     */
   public void add(Object o){
        if(nElems == arr.length){
            arr = Arrays.copyOf(arr,arr.length+(arr.length >> 1));
        }
        arr[nElems++] = o;
   }

    /**
     * 查找元素,有值返回索引值;无值返回 -1
     * @param o
     * @return
     */
   public int find(Object o){
       int i;
       for(i = 0;i <nElems;i++){
           if(o.equals(arr[i])){
               break;
           }
       }
       if(i < nElems){
           return i;
       }else{
           return -1;
       }
   }

    /**
     * 遍历数组
     */
    public void display(){
        for (int i = 0;i<nElems;i++){
            System.out.print(arr[i]+"\t");
        }
        System.out.println();
    }

    /**
     * 删除指定元素
     * @param o
     */
   public void delete(Object o){
       int i = find(o);
       if(i != -1){
           System.arraycopy(arr,i+1,arr,i,nElems-i-1);
           nElems--;
       }
   }
}
