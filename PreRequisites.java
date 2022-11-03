package Graphs;
//https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prerequisite-tasks
import java.util.*;
public class PreRequisites {
    public static void main(String[] args) {
        int[][] pre = {{1,0},{2,1},{3,2}};
        System.out.println(isPossible(4,pre));
    }
    static  public boolean isPossible(int N, int[][] pre)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i<N ; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        int m = pre.length;
        for(int i = 0 ; i<m ; i++)
        {
            adj.get(pre[i][0]).add(pre[i][1]);
        }

        int[] indegree = new int[N];
        for(int i = 0 ; i< N ; i++)
        {
            for(Integer idx : adj.get(i))
            {
                indegree[idx]++;
            }
        }Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i<N ; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while(!q.isEmpty())
        {
            int node = q.poll();
            topo.add(node);
            for(Integer a:adj.get(node))
            {
                indegree[a]--;
                if(indegree[a] == 0)
                {
                    q.add(a);
                }
            }

        }
        if(topo.size() == N)return true;
        return false;
    }
}
