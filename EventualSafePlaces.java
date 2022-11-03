package Graphs;
//https://leetcode.com/problems/find-eventual-safe-states/
import java.util.*;
public class EventualSafePlaces {
    public static void main(String[] args) {
        int[][] grid = {{1,2},{2,3},{5},{0} ,{5},{},{}};
        System.out.println(safePlaces(grid));
    }

    static List<Integer> safePlaces(int[][] grid)
    {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<grid.length; i++){
            adj.add(new ArrayList<Integer>());
            for(int j = 0; j<grid[i].length; j++)
                adj.get(i).add(grid[i][j]);
        }

        int V = grid.length;
        int visited[] = new int[V];
        int pathvisited[] = new int[V];
        boolean hasCycle[] = new boolean[V];

        for(int i = 0 ; i < V ; i++)
        {
            if(visited[i] == 0)
            {
                checkCycle(adj,visited,pathvisited,hasCycle,i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0 ; i< V ; i++)
        {
            if(!hasCycle[i])ans.add(i);
        }
        return ans;
    }

    static boolean  checkCycle(List<List<Integer>> adj , int[] vis , int[] pathvis , boolean[] hasCycle , int idx)
    {
        vis[idx] = 1 ;
        pathvis[idx] = 1;
        for (Integer x : adj.get(idx))
        {
            if(vis[x] == 0)
            {
                if(checkCycle(adj,vis,pathvis,hasCycle,x))
                {
                    return hasCycle[idx] = true;
                }
            } else if (vis[x] == 1 && pathvis[x] == 1) {
                return hasCycle[idx] = true;
            }
        }
        pathvis[idx] = 0;
        return false;
    }
}
