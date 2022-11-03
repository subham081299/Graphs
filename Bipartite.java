package Graphs;
//USING BFS
//https://practice.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph
import java.util.*;
import java.io.*;
public class Bipartite {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            boolean ans =isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
        }
    }

    static boolean isBipartite(int n , ArrayList<ArrayList<Integer>> adj)
    {
        int colors[] = new int[n];
        for (int i = 0 ; i<n ; i++)
        {
            Queue<Integer> q = new LinkedList<>();
            q.offer(i);
            colors[i] = 1;
            //Now color its adjacent vertices
            while (!q.isEmpty())
            {
                int curr = q.poll();
                for (Integer idx : adj.get(curr))
                {
                    if(colors[idx] == 0)
                    {
                        //color in opposite color
                        colors[idx] = -colors[curr];
                        q.add(idx);
                    } else if (colors[idx] == colors[curr]) {
                        return false;
                    }
                }
            }
        }return true;
    }
}
