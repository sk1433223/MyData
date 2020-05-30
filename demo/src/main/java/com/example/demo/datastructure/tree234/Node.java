package com.example.demo.datastructure.tree234;

/**
 * @author sk143
 * @Name：阿康
 * @Description：234树封装的节点类
 * @Date：2020/2/1 17:17
 */
public class Node {

    /**
     * 最大节点数,定义一个常数
     */
    private static final int ORDER = 4;

    /**
     * 保存节点中含有的数据项个数
     */
    private int numItems;

    /**
     * 当前节点的父节点
     */
    private Node parent;

    /**
     * 保存当前节点的子节点数据
     */
    private Node[] childArray = new Node[ORDER];

    /**
     * 存放节点数据
     */
    private DataItem[] itemArray = new DataItem[ORDER - 1];

    /**
     * 连接子节点
     *
     * @param childNum
     * @param child
     */
    public void connectChild(int childNum, Node child) {
        childArray[childNum] = child;
        if (child != null) {
            child.parent = this;
        }
    }

    /**
     * 断开与子节点的连接,并返回该子节点
     *
     * @param childNum
     * @return
     */
    public Node disconnectChild(int childNum) {
        Node tempNode = childArray[childNum];
        childArray[childNum] = null;
        return tempNode;
    }

    /**
     * 得到节点的某个子节点
     *
     * @param childNum
     * @return
     */
    public Node getChild(int childNum) {
        return childArray[childNum];
    }

    /**
     * 得到父节点
     *
     * @return
     */
    public Node getParent() {
        return parent;
    }

    /**
     * 判断是否叶节点
     * 是:true 否:false
     *
     * @return
     */
    public boolean isLeaf() {
        return childArray[0] == null;
    }

    /**
     * 得到节点的某个数据项
     *
     * @return
     */
    public int getNumItems() {
        return numItems;
    }

    /**
     * 得到节点的某个数据项
     *
     * @param index
     * @return
     */
    public DataItem getItem(int index) {
        return itemArray[index];
    }

    /**
     * 判断节点的数据项是否满了
     *
     * @return
     */
    public boolean isFull() {
        return numItems == ORDER - 1;
    }

    /**
     * 找到数据项在节点的位置
     *
     * @param key
     * @return
     */
    public int findItem(long key) {
        for (int j = 0; j < ORDER - 1; j++) {
            if (itemArray[j] == null) {
                break;
            } else if (itemArray[j].data == key) {
                return j;
            }
        }
        return -1;
    }

    /**
     * 将数据项插入到节点
     *
     * @param newItem
     * @return
     */
    public int insertItems(DataItem newItem) {
        numItems++;
        long newKey = newItem.data;
        for (int j = ORDER - 2; j >= 0; j--) {
            // 判断末尾数据项是否为空
            if (itemArray[j] != null) {
                long itsKey = itemArray[j].data;
                if (newKey < itsKey) {
                    itemArray[j + 1] = itemArray[j];
                } else {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    /**
     * 移除末尾节点数据项
     *
     * @return
     */
    public DataItem removeItem() {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    /**
     * 打印节点所有数据项
     */
    public void displayNode() {
        for (int j = 0; j < numItems; j++) {
            itemArray[j].disPlayItem();
        }
        System.out.println("/");
    }


}
