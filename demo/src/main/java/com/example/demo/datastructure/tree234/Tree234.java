package com.example.demo.datastructure.tree234;

/**
 * @author sk143
 * @Name：阿康
 * @Description：
 * @Date：2020/2/2 13:00
 */
public class Tree234 {

    private Node root;

    /**
     * 初始化一个空的234树
     */
    public Tree234() {
        root = new Node();
    }

    /**
     * 实现搜索234树
     * 找到指定的节点数据,并返回这个数据在节点的数据项数组中的索引,无返回-1
     *
     * @param key
     * @return
     */
    public int find(int key) {
        Node current = root;
        int childNumber;
        while (true) {
            if ((childNumber = current.findItem(key)) != -1) {
                // 在234树中找到了key
                return childNumber;
            } else if (current.isLeaf()) {
                // 如果到达叶子节点则说明无指定数据
                return -1;
            } else {
                current = getNextNode(current, key);
            }
        }
    }

    /**
     * @param theNode
     * @param theValue
     * @return
     */
    private Node getNextNode(Node theNode, int theValue) {
        int i;
        int numItems = theNode.getNumItems();
        for (i = 0; i < numItems; i++) {
            if (theValue < theNode.getItem(i).data) {
                return theNode.getChild(i);
            }
        }
        return theNode.getChild(i);
    }

    /**
     * 插入数据项
     *
     * @param insValue
     */
    public void insert(int insValue) {
        Node current = root;
        DataItem tempItem = new DataItem(insValue);
        while (true) {
            // 如果节点满了则进行分裂
            if (current.isFull()) {
                split(current);
                current = current.getParent();
                current = getNextNode(current, insValue);
            } else if (current.isLeaf()) {
                //当前节点是叶节点
                break;
            } else {
                current = getNextNode(current, insValue);
            }
        }
        current.insertItems(tempItem);
    }

    /**
     * 实现节点分裂
     *
     * @param theNode
     */
    private void split(Node theNode) {
        // 数据项 B,C
        DataItem itemB;
        DataItem itemC;
        // 第三个子节点,第四个子节点
        Node child2;
        Node child3;
        // 当前节点的父节点
        Node parent;

        // 把上面四个单位分离出来
        itemC = theNode.removeItem();
        itemB = theNode.removeItem();
        child2 = theNode.disconnectChild(2);
        child3 = theNode.disconnectChild(3);

        // 在右边新建一个新的节点
        Node rightNewNode = new Node();

        if (theNode == root) {
            // 根节点分裂
            root = new Node();
            parent = root;
            root.connectChild(0, theNode);
        } else {
            // 不是根节点分裂
            parent = theNode.getParent();
        }

        // 分裂节点
        // 首先把分裂节点B数据项插入到父节点
        int itemBinParentIndex = parent.insertItems(itemB);

        // 考虑父节点有两个数据项,改动原本子节点对应的索引值
        // B节点插入父节点后数据项的个数
        int n = parent.getNumItems();
        Node temp;
        for (int i = n - 1; i > itemBinParentIndex; i--) {
            temp = parent.disconnectChild(i);
            parent.connectChild(i + 1, temp);
        }

        // 移除右边新节点
        // itemC放到新节点
        rightNewNode.insertItems(itemC);
        parent.connectChild(itemBinParentIndex + 1, rightNewNode);
        rightNewNode.connectChild(0, child2);
        rightNewNode.connectChild(1, child3);
    }

    /**
     * 使用递归打印输出
     *
     * @param thisNode
     * @param level
     * @param childNum
     */
    public void recursionDisPlayTree234(Node thisNode, int level, int childNum) {
        System.out.println("level=" + level + " child:" + childNum);
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        for (int i = 0; i < numItems + 1; i++) {
            Node childNode = thisNode.getChild(i);
            // 递归边界条件
            if (childNode == null) {
                return;
            } else {
                recursionDisPlayTree234(childNode, level + 1, i);
            }
        }
    }

    public void displayTree() {
        recursionDisPlayTree234(root, 0, 0);
    }

}
