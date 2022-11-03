package Graphs;
//https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.*;

public class Minimum_Spanning_Tree {

    static class pair{
        int node,distance;
    public pair(int node,int distance)
        {
            this.node = node;
            this.distance = distance;
        }
    }
    /*
       Spanning Tree -  The tree with N nodes and N-1 edges and all the nodes are reachable from one another
       Minimum Spanning Tree or MST is out of the spanning trees the tree having the lowest sum is MST
     */


    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(prims(graph,V));
    }

    private static void createGraph(ArrayList<Edge> graph[])
    {
        for (int i = 0 ; i<graph.length ; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));
    }
    //Prim's Algorithm
    static int prims(ArrayList<Edge> graph[],int V)
    {
        // Add your code here
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y)-> x.distance - y.distance);

        boolean[] vis = new boolean[V];
        pq.add(new pair(0,0));//node,distance
        int sum = 0;
        while (!pq.isEmpty())
        {
            pair curr = pq.remove();
            int wt = curr.distance;
            int node = curr.node;


            if(vis[node])continue;
            vis[node] = true;
            sum+=wt;

            for (int i = 0; i<graph[node].size();i++)
            {
                Edge edge = graph[node].get(i);
                pq.add(new pair(edge.dest,edge.wt));
            }


        }return  sum;
    }
}

class Edge {
    int src , dest , wt;
    public Edge(int s , int d , int w)
    {
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
}