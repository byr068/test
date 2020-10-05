package com.company.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {
    private ArrayList<String> vertextList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接矩阵
    private int numOfEdges;//表示边的数目
    public static void main(String[] args){
        int n = 5;
        Graph graph = new Graph(5);
        String vertextValues[] = {"A","B","C","D","E"};
        for(String value : vertextValues){
            graph.addVertext(value);
        }
//        graph.addVertext("A");
//        graph.addVertext("B");
//        graph.addVertext("C");
//        graph.addVertext("D");
//        graph.addVertext("E");
        //添加边
        graph.addEdges(0,1,1);//a-b
        graph.addEdges(0,3,1);//a-d
        graph.addEdges(1,2,1);//b-c
        graph.addEdges(1,3,1);//b-d
        graph.addEdges(3,4,1);//d-e
        //边数
        System.out.println("图的边数"+graph.getNumOfEdges());
        //遍历邻接矩阵
        graph.bianli();

    }
    //构造器
    public Graph(int n){
        vertextList = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
    }
    //得到第一个邻接节点的下标w

    /**
     *
     * @param index
     * @return  存在就返回相应的坐标，否则就返回-1
     */
    public int getFirstNeighbor(int index){
        for(int j=0;j<vertextList.size();j++){
            if(edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }
//    public int getNextNeightbor(int v1,int v2){}
    //图中常用的方法
    //返回节点的个数
    public int getVertextNum(){
        return vertextList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回节点i(下标)所对应的数据0->"A" 1->"B"
    public String getVertextIndex(int i){
        return vertextList.get(i);
    }
    //返回v1和v2的权值

    /**
     *
     * @param i
     * @param j
     * @return
     */
    public int getEdgesValue(int i,int j){
        return edges[i][j];
    }
    //显示图对应的矩阵
    public void bianli(){
        for(int[] value : edges){
            System.out.println(Arrays.toString(value));
        }
    }
    //添加节点
    public void addVertext(String n){
        vertextList.add(n);
    }
    //添加边
    public void addEdges(int i,int j,int weight){
        edges[i][j] = weight;
        edges[j][i] = weight;
        numOfEdges++;//边的数目加一
    }


}
