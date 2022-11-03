package Graphs;
//https://practice.geeksforgeeks.org/problems/course-schedule/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=course-schedule
import java.util.*;
public class CourseSchedule {
    public static void main(String[] args) {
        int n = 4, m = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        System.out.println(findOrder(n,m , prerequisites));

    }
//USING Topological Sorting
    private static int[]findOrder(int N, int M, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i<N ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i<pre.length; i++)
        {
            adj.get(pre[i][1]).add(pre[i][0]);
        }

        int[] indegree = new int[N];
        for(int i = 0 ; i<N ; i++)
        {
            for(Integer it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i <  N ; i++)
        {
            if(indegree[i] == 0)q.add(i);
        }
        ArrayList<Integer> topo = new ArrayList<>();
        int ifnull[] = {};
        while (!q.isEmpty())
        {
            int m = q.poll();
            topo.add(m);
            for (Integer a: adj.get(m))
            {
                indegree[a]--;
                if(indegree[a] == 0)q.add(a);
            }

        }
        if(topo.size() == N)return topo.stream().mapToInt(Integer::intValue).toArray();
        return ifnull;
    }
}
