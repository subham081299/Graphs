package Graphs;
//https://practice.geeksforgeeks.org/problems/alien-dictionary/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=alien-dictionary
import java.util.*;
public class AlienDictionary {
    public static void main(String[] args) {
      int N = 3, K = 3;
      String[]  dict = {"caa","aaa","aab"};
        System.out.println(alienDictionary(N,K,dict));
    }

    private static String alienDictionary(int n, int k, String[] dict) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0 ; i < k ; i++)
        {
            adj.add(new ArrayList<>());
        }

        for (int i = 0 ; i <n-1 ; i++)
        {
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s2.length(),s1.length());

            for (int j = 0 ; j <len ; j++)
            {
                if(s2.charAt(j)!= s1.charAt(j))
                {
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }

        }
        int[] topo = topoSort(k,adj);
        String ans ="";
        for(Integer it:topo)
        {
            ans = ans + (char)(it + (int)('a'));
        }
        return ans;
    }
    static int[] topoSort(int N,ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[N];

        for (int i = 0 ; i <N ; i++)
        {
            for (Integer it:adj.get(i))
            {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i<N ; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        int ifnull[] = {};
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty())
        {
            int node = q.poll();
            topo.add(node);
            for(Integer a:adj.get(node))
            {
                indegree[a]--;
                if(indegree[a] == 0)q.add(a);
            }
        }
        if(topo.size() == N)return topo.stream().mapToInt(Integer::intValue).toArray();
        return ifnull;
    }
}
