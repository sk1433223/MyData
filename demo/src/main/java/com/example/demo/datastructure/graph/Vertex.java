package com.example.demo.datastructure.graph;

/**
 * @author sk143
 * @Description: 顶点数据类(图节点)
 * @date 2020/2/8 11:51
 */
public class Vertex {

    /**
     * 节点(顶点)
     */
    public char label;

    /**
     * 判断(顶点)是否被访问
     */
    public boolean isVisited;

    public Vertex(char label) {
        this.label = label;
        isVisited = false;
    }

}
