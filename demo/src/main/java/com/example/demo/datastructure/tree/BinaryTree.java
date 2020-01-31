package com.example.demo.datastructure.tree;

/**
 * @author sk143
 * @Name：阿康
 * @Description：二叉树基本结构
 * @红黑树
 * @Date：2020/1/28 17:14
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 查找某个节点
     * @param data
     * @return
     */
    public Node find(int data) {
        Node current = root;
        while (current != null) {
            // 查找判断左右子节点
            if (data < current.getData()) {
                current = current.getLeftChild();
            }else if (data > current.getData()){
                current = current.getRightChild();
            }else {
                return current;
            }
        }
        // 未找到
        return null;
    }

    /**
     * 插入节点
     * @param data
     */
    public void insert(int data) {
        Node newNode = new Node(true,data,null,null,null);
        // 如果二叉树为null,则把插入值作为根节点
        if (root == null) {
            root = newNode;
            root.setColor(false);
        }else {
            Node current = root;
            Node parentNode;
            while (current != null) {
                parentNode = current;
                if (data < current.getData()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parentNode.setLeftChild(newNode);
                        newNode.setParent(parentNode);
                    }
                }else {
                    current = current.getRightChild();
                    if (current == null) {
                        parentNode.setRightChild(newNode);
                        newNode.setParent(parentNode);
                    }
                }
            }
        }
        // 新的节点插入以后,可能会破坏树的平衡,检查红黑树规格
        insertFixUp(newNode);
    }

    /**
     * 实现红黑树的自我修正
     * @param node
     */
    private void insertFixUp(Node node) {
        Node parent;
        Node grandFather;
        Node uncle;

        // 修正违反红黑树规则的节点
        while (((parent= node.getParent()) != null) && parent.getColor()) {
                // 拿到父节点的父节点
            grandFather = parent.getParent();

            // 判断node是父节点的左,右子节点
            if (parent == grandFather.getLeftChild()) {
                // 拿到叔叔节点
                uncle = grandFather.getRightChild();

                // 情况(1)parent是红的,uncle是红
                if(uncle != null && uncle.getColor()) {
                    parent.setColor(false);
                    uncle.setColor(false);
                    grandFather.setColor(true);
                    node = grandFather;
                    continue;
                }

                // (2)parent是红的,uncle是黑的,node在parent的右边
                if (node == parent.getRightChild()) {
                    // 以当前节点的父节点为支点,进行左旋
                    leftRotate(parent);
                    Node temp = parent;
                    parent = node;
                    node = temp;
                }

                // (3)parent是红的,uncle是黑的,node在parent的左边
                parent.setColor(false);
                grandFather.setColor(true);
                rightRotate(grandFather);

            } else {
                uncle = grandFather.getLeftChild();

                // 情况(1)parent是红的,uncle是红
                if(uncle != null && uncle.getColor()) {
                    parent.setColor(false);
                    uncle.setColor(false);
                    grandFather.setColor(true);
                    node = grandFather;
                    continue;
                }

                // (2)parent是红的,uncle是黑的,node在parent的左边
                if (node == parent.getLeftChild()) {
                    // 以当前节点的父节点为支点,进行右旋
                    rightRotate(parent);
                    Node temp = parent;
                    parent = node;
                    node = temp;
                }

                // (3)parent是红的,uncle是黑的,node在parent的右边
                parent.setColor(false);
                grandFather.setColor(true);
                leftRotate(grandFather);
            }
        }
    }

    /**
     * 二叉树中序遍历
     * 注:中序遍历:左子树——>根节点——>右子树
     * @param current
     */
    public void midOrder(Node current) {
        if (current != null) {
            midOrder(current.getLeftChild());
            System.out.print(current.getData()+"\t");
            midOrder(current.getRightChild());
        }
    }

    /**
     * 前序遍历
     * 注:前序遍历:根节点——>左子树——>右子树
     * @param current
     */
    public void preOrder(Node current) {
        if (current != null) {
            System.out.print(current.getData()+"\t");
            preOrder(current.getLeftChild());
            preOrder(current.getRightChild());
        }
    }

    /**
     * 后序遍历
     * 注:左子树——>右子树——>根节点
     * @param current
     */
    public void postOrder (Node current) {
        if (current != null) {
            postOrder(current.getLeftChild());
            postOrder(current.getRightChild());
            System.out.print(current.getData()+"\t");
        }
    }

    /**
     * 找到最大值
     * @return
     */
    public Node findMax() {
        Node current = root;
        Node maxNode = current;
        while (current != null) {
            // 可以交换下位置试一试
            maxNode = current;
            current = current.getRightChild();

        }
        return  maxNode;
    }

    /**
     * 找到最小值
     * @return
     */
    public Node findMin() {
        Node current = root;
        Node minNode = current;
        while (current != null) {
            // 可以交换下位置试一试
            minNode = current;
            current = current.getLeftChild();
        }
        return  minNode;
    }

    /**
     * 二叉树实现删除节点
     * @param data
     * @return
     */
    public boolean delete(int data) {
        // 找到删除节点
        Node current = root;
        Node parent = null;
        // 判断当前节点其父节点的左还是右节点
        boolean isLeftChild = false;
        while (current.getData() != data) {
            parent = current;
            if (data < current.getData()) {
                current = current.getLeftChild();
                isLeftChild = true;
            }else {
                current = current.getRightChild();
                isLeftChild = false;
            }
            // 没有要删除的节点,直接结束方法
            if (current == null) {
                return false;
            }
        }

        /**
         * 循环正常结束,表示找到删除节点,current
         */
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            // 1.无左右子节点的节点
            if (current == root) {
                root = null;
            }else {
                if (isLeftChild) {
                    parent.setLeftChild(null);
                }else {
                    parent.setRightChild(null);
                }
            }
            return true;
        }else if (current.getLeftChild() != null && current.getRightChild() == null) {
            // 2.只有左节点的节点
            if (current == root) {
                root = current.getLeftChild();
            }else {
                if (isLeftChild) {
                    parent.setLeftChild(current.getLeftChild());
                }else {
                    parent.setRightChild(current.getLeftChild());
                }
            }
        }else if (current.getLeftChild() == null && current.getRightChild() != null) {
            // 2.只有右节点的节点
            if (current == root) {
                root = current.getRightChild();
            }else {
                if (isLeftChild) {
                    parent.setLeftChild(current.getRightChild());
                }else {
                    parent.setRightChild(current.getRightChild());
                }
            }
        }else {
            // 4.删除有两个子节点的节点
            Node replaceNode = getReplaceNode(current);

            if (current == root) {
                root = replaceNode;
            }else {
                if (isLeftChild) {
                    parent.setLeftChild(replaceNode);
                }else {
                    parent.setRightChild(replaceNode);
                }
            }
            replaceNode.setLeftChild(current.getLeftChild());
            return true;
        }
        // 程序意外终止
        return false;
    }

    /**
     * 寻找子树最小节点
     * @param delNode
     * @return
     */
    private Node getReplaceNode(Node delNode) {
        // 目标节点
        Node replaceNode = delNode;
        Node replaceNodeParent = delNode;
        // 替换目标子树根节点
        Node grnCurrent = delNode.getRightChild();
        while (grnCurrent != null) {
            replaceNodeParent = replaceNode;
            replaceNode = grnCurrent;
            grnCurrent = grnCurrent.getLeftChild();
        }
        if (replaceNode != delNode.getRightChild()) {
            // 删除替换节点
            replaceNodeParent.setLeftChild(replaceNode.getRightChild());
            // 改变替换节点
            replaceNode.setRightChild(delNode.getRightChild());
        }

        // 寻找到的右子树的最小目标节点
        return replaceNode;
    }

    /**
     * 实现红黑树左旋转
     * @param x
     */
    private void leftRotate(Node x) {
        // 1.把y节点的左子节点变为x的右子节点
        // 拿到y节点
        Node y = x.getRightChild();
        // 把y节点的左节点赋值给x的右节点上
        x.setRightChild(y.getLeftChild());
        if (y.getLeftChild() != null) {
            y.getLeftChild().setParent(x);
        }

        // 2.x的父节点和y的父节点互换
        y.setParent(x.getParent());
        if (x.getParent() == null) {
            root = y;
        }else {
            if (x == x.getParent().getLeftChild()) {
                x.getParent().setLeftChild(y);
            }else {
                x.getParent().setRightChild(y);
            }
        }

        // 3.y的左子节点变x,y变为x的父节点
        y.setLeftChild(x);
        x.setParent(y);
    }

    /**
     * 实现红黑树右旋转
     * 1.将x的右节点赋值给y的左子节点,并将y赋值给x右节点的父节点
     * 2.将y的父节点p赋值给x的父节点,更新p的子节点为x
     * 3.将x的右节点设为y,将y的父节点设为x
     * @param y
     */
    private void rightRotate(Node y) {
        // 1.将x的右节点赋值给y的左子节点,并将y赋值给x右节点的父节点
        Node x = y.getRightChild();
        y.setLeftChild(x.getRightChild());
        if (x.getRightChild() != null) {
            x.getRightChild().setParent(y);
        }

        // 2.
        x.setParent(y.getParent());
        if (y.getParent() == null) {
            this.root = x;
        }else {
            if (y == y.getParent().getLeftChild()) {
                y.getParent().setLeftChild(x);
            }else {
                y.getParent().setRightChild(x);
            }
        }

        // 3.
        x.setRightChild(y);
        y.setParent(x);
    }

}
