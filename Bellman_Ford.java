package Graphs;
import java.util.*;
public class Bellman_Ford {


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int vertices = 2;
        for(int i = 0 ; i <vertices-1 ; i++) // edges is Vertices -1
        {
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(0);
            tmp.add(1);
            tmp.add(9);
            adj.add(tmp);
        }




        int[] arr = bellman_ford(vertices,adj,0);
        for (int i:arr)
            System.out.print(i + " ");
    }
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[S] = 0;

        //Time Complexity = O(V*E)
        for (int i = 0 ; i<V-1 ; i++)
        {
            for (ArrayList<Integer> it: edges)
            {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != (int)1e8 && dist[u] + wt < dist[v])
                {
                    dist[v] = dist[u] + wt;
                }

            }

            //it will run for V-1 times but if it still continues even after V-1 then it is sure the graph has negative cycle

            for (ArrayList<Integer> it: edges)
            {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != (int)1e8 && dist[u] + wt < dist[v])
                {
                    int temp[] = new int[1];
                    temp[0] = -1;
                    return  temp;
                }
            }

        } return dist;
    }
}
