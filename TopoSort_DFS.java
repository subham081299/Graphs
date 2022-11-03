package Graphs;
import  java.util.*;
public class TopoSort_DFS {

    public static void main(String[] args) {
        int[][] grid = {{},{0},{0},{0}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<grid.length; i++){
            adj.add(new ArrayList<Integer>());
            for(int j = 0; j<grid[i].length; j++)
                adj.get(i).add(grid[i][j]);
        }

        int[] ans = topoSort(4,adj);

        for (int i = 0 ; i<4 ; i++)
        {
            System.out.print(ans[i] + " ");
        }
    }
    static Stack<Integer> stk = new Stack<>();
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        boolean[] vis = new boolean[V];
        for(int i = 0 ; i<  V ; i++)
        {
            if(!vis[i])
            {
                check(vis , adj , i);
            }
        }

        int[] topo = new int[V];
        int i = 0 ;
        while(!stk.isEmpty())
        {
            topo[i++] = stk.pop();
        }
        return topo;
    }

    static void check(boolean[] vis, ArrayList<ArrayList<Integer>> adj , int idx)
    {
        vis[idx] = true;
        for(Integer a:adj.get(idx))
        {
            if(!vis[a])
            {
                check(vis,adj,a);
            }
        }
        stk.push(idx);
    }
}
