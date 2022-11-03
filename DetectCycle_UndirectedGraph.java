package Graphs;
import java.util.*;
public class DetectCycle_UndirectedGraph {
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

        boolean ans = isCycle(4,adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
    public static  boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean vis[] = new boolean[V];
        int parent[] = new int[V];
        Arrays.fill(parent,-1);
        Arrays.fill(vis,false);
        for (int i  = 0 ; i<V ; i++)
        {
            if(checkCycle(adj , i , vis , parent))return true;
        }return false;
    }
    public  static  boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int pos , boolean[] vis , int[] parent) {
        /*
           So the question is why there is a need to store a parent
           The answer is suppose a node 3 which is comming from 1 ie. 1 is parent .
           So the adjacent nodes of 3 is 1 and 4 but if parent is not stored it will show that 1 is already visited then there must be a cycle
           Parent nodes are always adjacent nodes but we have to ignore them
         */

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(pos, -1));
        vis[pos] = true;
        while (!q.isEmpty()) {
            int curr = q.peek().first;
            int par = q.poll().second;

            for (Integer it : adj.get(curr)) {
                if (!vis[it]) {
                    q.add(new Pair(it, curr));
                    vis[it] = true;
                } else if (it != par) {
                    return true;
                }
            }


        }
        return false;
    }


}
class Pair{
    int first,second;
    public Pair(int first,int second)
    {
        this.first = first;
        this.second = second;
    }
}

