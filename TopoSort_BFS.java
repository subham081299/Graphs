package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopoSort_BFS {
    public static void main(String[] args) {
        int[][] grid = {{}, {0}, {0}, {0}};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            adj.add(new ArrayList<Integer>());
            for (int j = 0; j < grid[i].length; j++)
                adj.get(i).add(grid[i][j]);
        }

        int[] ans = topoSort(4, adj);

        for (int i = 0; i < 4; i++) {
            System.out.print(ans[i] + " ");
        }
    }
/*
   Steps:
   Indegree array
   Add the elements in Queue with indegree 0 ie there is no other elements before them
   after that add the adjacent nodes after their indegree gets reduced to zero
 */
    private static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int indegree[] = new int[V];
        for (int i = 0 ; i < V; i++)
            for (int j :adj.get(i))
            {
                indegree[j]++;
            }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i < V ; i++)
        {
            if(indegree[i] == 0)
                q.add(i);
        }

        int[] topo = new int[V];
        int idx = 0;
        while (!q.isEmpty())
        {
            Integer node = q.poll();
            topo[idx++] = node;
            for (Integer a:adj.get(node))
            {
                indegree[a]--;
                if(indegree[a] == 0)
                    q.add(a);
            }
        }
        return topo;
    }


}
