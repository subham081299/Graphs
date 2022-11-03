package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
//Here in Directed Graph No Tension about Parent cuz it is one directional
//So here we will take 2 visited array
//cuz 3->5->7 will show Cycle in one visited but actually it is not cycle
// 3 -> 5 -> 7 -> 3 will show Cycle so that 2 visited array is required

public class DetectCycle_Directed_using_DFS {
    public static void main (String[] args) {

        int V= 6;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);

        //Vertex - 0
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 1
        neighbors = new ArrayList<Integer>();
        neighbors.add(2);
        neighbors.add(5);
        graph.add(neighbors);

        //Vertex - 2
        neighbors = new ArrayList<Integer>();
        neighbors.add(3);
        graph.add(neighbors);

        //Vertex - 3
        neighbors = new ArrayList<Integer>();
        neighbors.add(4);
        graph.add(neighbors);

        //Vertex - 4
        neighbors = new ArrayList<Integer>();
        neighbors.add(0);
        neighbors.add(1);
        graph.add(neighbors);

        //Vertex - 5
        neighbors = new ArrayList<Integer>();
        graph.add(neighbors);

        if(isCyclic(V, graph))
            System.out.println("Cycle detected");
        else
            System.out.println("No cycles detected");

    }

    private static boolean checkCycle(int node,  ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
        vis[node] = 1;
        dfsVis[node] = 1;

        for(Integer neighbor: adj.get(node)) {
            if(vis[neighbor] == 0) {
                if(checkCycle(neighbor, adj, vis, dfsVis) == true) {
                    return true;
                }
            } else if(dfsVis[neighbor] == 1) {
                return true;
            }
        }
        dfsVis[node] = 0;
        return false;
    }

    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[N];
        int dfsVis[] = new int[N];

        for(int i = 0;i<N;i++) {
            if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis) == true) return true;
            }
        }
        return false;
    }
}
