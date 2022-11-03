package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectCycleUndirected_using_DFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0 ; i<4 ; i++)
        {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = hasCycle(4,adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }

    private static boolean hasCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited,false);
        for(int i = 0 ; i<V ; i++)
        {
            if(isCyclePresent(i , -1 , visited , adj))return true;

        }return false;
    }

    private static boolean isCyclePresent(int pos , int prev , boolean visited[] , ArrayList<ArrayList<Integer>> adj )
    {
        visited[pos] = true;
        for(Integer curr: adj.get(pos))
        {
            if(!visited[curr])
            {
                if(isCyclePresent(curr,pos,visited,adj))return true;
            } else if (curr != prev) {
                return true;
            }
        }return false;
    }
}
