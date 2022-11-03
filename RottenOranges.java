package Graphs;
//https://leetcode.com/problems/rotting-oranges/
import java.util.*;
public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},
                        {1,1,0},
                        {0,1,1}};
        System.out.println("Time Required to rotten all oranges is:"+ orangesRotting(grid));
    }
    public static int orangesRotting(int[][] grid){
        int frsh = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length , n =grid[0].length;
        for (int i = 0 ; i<m ; i++)
            for (int j = 0 ; j<n ; j++)
            {
                if(grid[i][j] == 1)frsh++;
                else if (grid[i][j] == 2)//2 means rotten
                {
                    q.add(new int[]{i,j});
                }
            }

        if(frsh == 0)return 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int time = 0;

        while (!q.isEmpty())
        {
            time++;
            int size = q.size();
            while (size-->0)
            {
                int curr[] = q.poll();
                for(int[] d:directions)
                {
                    int row = d[0] + curr[0];
                    int col = d[1] + curr[1];

                    if(row >= 0 && row<m && col>=0 && col<n && grid[row][col] == 1)
                    {
                        grid[row][col] = 2;
                        q.offer(new int[]{row,col});
                        frsh--;

                    }
                }

            }
        }
        if(frsh == 0)
        {
            if(time > 0)return time-1;
            else return 0;
        }else return -1;

    }
}
