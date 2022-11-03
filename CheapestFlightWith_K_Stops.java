package Graphs;
//https://practice.geeksforgeeks.org/problems/cheapest-flights-within-k-stops/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=cheapest-flights-within-k-stops
import java.util.*;
public class CheapestFlightWith_K_Stops {
    public static void main(String[] args) {
        int n = 4 , src = 0,  dst = 3 ,k = 1;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};

        System.out.println(CheapestFLight(n,flights,src,dst,k));

    }
    public static int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for (int i =0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1] , flights[i][2]));
        }

        Queue<Tri> q = new LinkedList<>();
        q.add(new Tri(0,src,0));
        int[] dist = new int[n];
        Arrays.fill(dist,(int) 1e9);
        dist[src] = 0;

        while (!q.isEmpty())
        {
            Tri t = q.poll();
            int stops = t.stops;
            int node = t.node;
            int weight = t.dist;

            if(stops > k)continue;
            for(Pair it: adj.get(node))
            {
                int adjacent_node = it.first;
                int edW = it.second;

                if(weight + edW < dist[adjacent_node] && stops<=k)
                {
                    dist[adjacent_node] = weight + edW;
                    q.add(new Tri(stops + 1 , adjacent_node , weight + edW));
                }
            }
        }return dist[dst] == (int) 1e9?-1 : dist[dst];
    }
}
class Tri{
    int stops,node,dist;
    public Tri(int stops,int node , int dist)
    {
        this.stops = stops;
        this.node = node;
        this.dist = dist;
    }
}