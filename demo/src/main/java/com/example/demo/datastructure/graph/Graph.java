package com.example.demo.datastructure.graph;

/**
 * @author sk143
 * @Name：阿康
 * @Description：封装图实现
 * @Date：2020/2/8 11:58
 */
public class Graph {

    /**
     * 顶点个数
     */
    private final int MAX_VERT = 20;

    /**
     * 顶点数组
     */
    private Vertex[] vertexList;

    /**
     * 邻接矩阵储存"边"
     * 数组元素0表示无边界,数组1表示有边界
     */
    private int[][] adjMat;

    /**
     * 顶点个数
     */
    private int nVert;

    /**
     * 使用栈实现深度优先搜索
     */
    private Stack theStack;

    /**
     * 使用队列实现广度优先搜索
     */
    private Queue theQueue;

    /**
     * 图结构初始化
     */
    public Graph() {
        // 定点列表
        vertexList = new Vertex[MAX_VERT];
        // 邻接矩阵
        adjMat = new int[MAX_VERT][MAX_VERT];
        // 顶点个数
        nVert = 0;
        // 初始化邻接矩阵元素都为 0,即所有定点都没边
        for (int i = 0; i < MAX_VERT; i++) {
            for (int j = 0; j < MAX_VERT; j++) {
                adjMat[i][j] = 0;
            }
        }
        theStack = new Stack();
        theQueue = new Queue();
    }

    /**
     * 添加顶点到数组中
     */
    public void insert(char label) {
        vertexList[nVert++] = new Vertex(label);
    }

    /**
     * 邻接矩阵表示边是对称的,两部分都要赋值
     *
     * @param start
     * @param end
     */
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    /**
     * 打印某个顶点的值
     *
     * @param v
     */
    public void disPlayVertex(int v) {
        System.out.print(vertexList[v].label);
    }

    /**
     * 深度优先搜索法:
     * 1.用peek()方法检查栈顶的顶点
     * 2.用getAdjUnvisitedVertex()方法找到当前栈顶点邻接且未被访问的顶点
     * 3.第二部方法返回值不等于-1,则找到下一个未访问的邻接顶点,访问这个顶点,
     * 并入栈,返回-1则没有找到,出栈
     */
    public void depthFirstSearch() {
        // 从第一个顶点开始访问
        // 访问后标记未true
        vertexList[0].isVisited = true;
        // disPlayVertex(0);
        // 将第一个顶点放到栈中
        theStack.push(0);

        while (!theStack.isEmpty()) {
            // 找到未访问的邻接点
            int current = theStack.peek();
            int v = getAdjUnvisitedVertex(current);
            if (v == -1) {
                // 如果当前顶点为-1,表示没有邻接且未被访问出顶点
                theStack.pop();
            } else {
                vertexList[v].isVisited = true;
                disPlayVertex(current);
                disPlayVertex(v);
                System.out.println("  ");
                theStack.push(v);
            }
        }
        // 栈访问完毕,重置所有标记位置isVisited = false;
        for (int i = 0; i < nVert; i++) {
            vertexList[i].isVisited = false;
        }
    }

    /**
     * 找到与某一顶点邻接且未被访问的顶点
     *
     * @param v
     * @return
     */
    private int getAdjUnvisitedVertex(int v) {
        for (int i = 0; i < nVert; i++) {
            if (adjMat[v][i] == 1 && !vertexList[i].isVisited) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 广度优先搜索法:
     * 1.用remove()方法检查栈顶的顶点
     * 2.试图找到这个顶点未访问的邻接点
     * 3.如果没找到,该顶点出列
     * 4.如果找到,访问这个顶点,并放到队列中
     */

    public void breadthFirstSearch() {
        vertexList[0].isVisited = true;
        disPlayVertex(0);
        theQueue.insert(0);
        int v2;
        while (!theQueue.isEmpty()) {
            int v1 = theQueue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].isVisited = true;
                disPlayVertex(v2);
                theQueue.insert(v2);
            }
        }
        // 搜索完毕,初始化,便于下次搜索
        for (int i = 0; i < nVert; i++) {
            vertexList[i].isVisited = false;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.insert('A');
        graph.insert('B');
        graph.insert('C');
        graph.insert('D');
        graph.insert('E');

        graph.addEdge(0, 1); // AB
        graph.addEdge(1, 2); // BC
        graph.addEdge(0, 3); // AD
        graph.addEdge(0, 4); // DE

        System.out.println();
        graph.depthFirstSearch();// ABCDE

        System.out.println("-----------");

        graph.breadthFirstSearch(); // ABDCE
    }
}
