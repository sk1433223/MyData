package com.example.demo.datastructure.tree234;

/**
 * @author sk143
 * @Name：阿康
 * @Description：封装数据项的类
 * @Date：2020/2/1 17:13
 * @注:为简化代码使用public修饰属性
 */
public class DataItem {

    /**
     * 节点具体的数值
     */
    public int data;

    public DataItem(int data) {
        this.data = data;
    }

    public void disPlayItem() {
        System.out.println("/" + data);
    }
}
