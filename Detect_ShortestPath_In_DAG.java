package Graphs;
//https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=direct-acyclic-graph
import java.util.*;
public class Detect_ShortestPath_In_DAG {
    static Stack<Integer> stk;
    public static void main(String[] args) {
        int n = 6, m= 7;
        int[][] edge={{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};

        int[] dist = shortestPath(n,m,edge);

        for (int a:dist)
        {
            System.out.print(a + " ");
        }
    }
    public static int[] shortestPath(int N,int M, int[][] edges) {

        //Now at first create adjacency list
        //Now here there are three elements in edges 1st is the parent second is the child third is the weight of the path
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0 ;i<N ; i++)
        {
            ArrayList<int[]> tmp = new ArrayList<>();
            adj.add(tmp);
        }

        for(int i = 0 ; i <M ; i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v,wt});
        }

         stk = new Stack<Integer>();

        boolean visited[] = new boolean[N];
        for (int i = 0 ; i <N ; i++)
        {
            if(!visited[i])
            {
                topoSort(i,adj,visited);
            }
        }
        int dist[] = new int[N];
        Arrays.fill(dist,(int)(1e9));
        dist[0] = 0;

        while (!stk.isEmpty())
        {
            int node = stk.pop();
            for (int k = 0 ; k<adj.get(node).size() ; k++)
            {
                int[] arr = adj.get(node).get(k);
                int v = arr[0];
                int wt = arr[1];
                if(dist[node] + wt <dist[v])
                {
                    dist[v] = dist[node] + wt;
                }
            }
        }
        //If there is any remaining then change its value to -1

        for (int i = 0 ; i < N ; i++)
        {
            if(dist[i] == (int)(1e9))
            {
                dist[i] = -1;
            }
        }
        return dist;
    }

    private static void topoSort(int i, ArrayList<ArrayList<int[]>> adj, boolean[] visited) {
        visited[i] = true;
        for (int j = 0 ; j<adj.get(i).size() ; j++)
        {
            int[] arr = adj.get(i).get(j);
            int v = arr[0];
            if(!visited[v])
            {
                topoSort(v,adj,visited);
            }
        }
        stk.push(i);
    }
}
