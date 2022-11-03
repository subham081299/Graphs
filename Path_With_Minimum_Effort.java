package Graphs;
//https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-a-binary-maze
import java.util.*;
public class Path_With_Minimum_Effort {
    public static void main(String[] args) {
        int  grid[][] = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};
       int[] source = {0, 1};
       int[] destination = {2, 2};

        System.out.println(shortest(grid,source,destination));

    }

    private static int shortest(int[][] grid, int[] source, int[] destination) {

        if(source[0] == destination[0] && source[1] == destination[1])return 0;

        Queue<Tuple>  q = new LinkedList<>();
        q.add(new Tuple(0,source[0],source[1]));

        int m = grid.length;
        int n = grid[0].length;
        int dist[][] = new int[m][n];

        for (int i = 0; i<m ; i++)
            for (int j = 0 ; j <n ; j++)
            {
                dist[i][j] = (int)1e9;
            }
        dist[source[0]][source[1]] = 0;

        int row[] = {-1 , 1 , 0 , 0};
        int col[] = {0 , 0 , -1 , 1};

        while (!q.isEmpty())
        {
            Tuple t = q.poll();
            int distance = t.dist;
            int r = t.x;
            int c = t.y;

            for (int i = 0 ; i <4 ; i++)
            {
                int newrow = r + row[i];
                int newcol = c + col[i];

                while (newcol>=0 && newcol<n && newrow>=0 && newrow<m && grid[newrow][newcol] == 1 && 1 + distance <dist[newrow][newcol])
                {
                    dist[newrow][newcol] = 1 + distance;
                    if(newrow == destination[0] && newcol == destination[1])return 1+distance;
                    q.add(new Tuple(1+distance,newrow,newcol));
                }
            }
        }return -1;


    }
}
class Tuple
{
    int dist,x,y;
    public Tuple(int dist, int x ,int y)
    {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}