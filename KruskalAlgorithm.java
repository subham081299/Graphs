package Graphs;

import java.util.ArrayList;
import java.util.Collections;

//Time Complexity - O(V + E log E)
public class KruskalAlgorithm { // used to detect cycle in a MST just like Prims algo

    static  class Edge implements Comparable<Edge>{
        int src , dest , wt;
        public Edge(int s , int d , int w)
        {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.wt-o.wt;
        }
    }/*
       Step 1: Sort all the edges
       Step 2: Find the minimum cost edge
     */
    static int n = 4;
    static int parent[] = new int[n];
    static int[] rank = new int[n];

    public static void inIt() {
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public static int find(int x) // O(constant) = O(1)
    {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b)// O(constant) = O(1)
    {
        int partA = find(a);
        int partB = find(b);

        if (rank[partA] == rank[partB]) //if both have same rank then either one of them can become parent
        {
            parent[partB] = partA;
            rank[partA]++;
        } else if (rank[partA] < rank[partB]) {
            parent[partA] = partB;
        } else {
            parent[partB] = partA;
        }
    }

    private static void createGraph(ArrayList<Edge> graph) {

        graph.add(new Edge(0, 1, 10));
        graph.add(new Edge(0, 2, 15));
        graph.add(new Edge(0, 3, 30));
        graph.add(new Edge(1, 3, 40));
        graph.add(new Edge(2, 3, 50));


    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>  graph = new ArrayList<>();
        createGraph(graph);
        kruskal(graph,V);
    }

    public static void kruskal(ArrayList<Edge> graph , int V)
    {
        inIt();
        Collections.sort(graph);
        int count = 0;
        int mstCost = 0;
        for (int i =0 ; count < V-1 ; i++)
        {
            Edge e = graph.get(i);
            //(src,dest,wt)
            int partA = find(e.src);
            int partB= find(e.dest);

            if(partA != partB) // then there will be no cycle
            {
                union(e.src,e.dest);
                mstCost+= e.wt;
                count++;
            }
        }
        System.out.println(mstCost);
    }
}
