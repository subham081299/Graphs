package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPath {

    public static int[] dijkstra(int V, ArrayList<ArrayList<Node>> adj, int S)
    {
        int dist[] = new int[V];
        Arrays.fill(dist,(int)1e9);//At first fill the array with infinite value(large value) then check shortest path
        dist[S] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y)->x.dist-y.dist);
        pq.add(new Node(S,0));

        while (!pq.isEmpty())
        {
            Node n = pq.poll();
            int node = n.node;
            int distance = n.dist;

            for(Node it: adj.get(node))
            {
                int weight = it.dist;
                int adjacent_node = it.node;
                if(distance + weight < dist[adjacent_node])
                {
                    dist[adjacent_node] = distance + weight;
                    pq.add(new Node(adjacent_node,distance+weight));
                }
            }

        } return dist;
    }
}