package Graphs;

public class DisJointSet {
    static int n = 8;
    static int parent[] = new int[n];
    static int[] rank = new int[n];

    public static void inIt()
    {
        for (int i = 0 ; i <n ; i++)
            parent[i] = i;
    }
    public static int find(int x) // O(constant) = O(1)
    {
        if(parent[x] == x)return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a , int b)// O(constant) = O(1)
    {
        int partA = find(a);
        int partB = find(b);

        if(rank[partA] == rank[partB]) //if both have same rank then either one of them can become parent
        {
            parent[partB] = partA;
            rank[partA]++;
        } else if (rank[partA]<rank[partB]) {
            parent[partA] = partB;
        }
        else{
            parent[partB] = partA;
        }
    }

    public static void main(String[] args) {
        inIt();
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);

    }
}
