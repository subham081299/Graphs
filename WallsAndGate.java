package Graphs;
//https://www.codingninjas.com/codestudio/problems/walls-and-gates_1092887?leftPanelTab=1
import java.util.*;
public class WallsAndGate {

    public static void main(String[] args) {
        int[][] grid = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(grid);
        for (int i = 0 ; i<grid.length ; i++)
        {
            for (int j = 0 ; j<grid[0].length ; j++)
            {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
        public static void wallsAndGates(int[][] rooms) {
            // write your code here
            int m = rooms.length;
            int n = rooms[0].length;

            //Queue will store the indexes of 0s
            Queue<int[]> q = new LinkedList<>();
            for(int i = 0 ; i<m ; i++)
            {
                for(int j = 0 ; j<n ; j++)
                {
                    if(rooms[i][j] == 0)
                    {
                        q.add(new int[]{i,j});
                    }
                }
            }

            int level = 0 ;
            int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

            while(!q.isEmpty())
            {
                level++;
                int size =  q.size();
                while(size-->0)
                {
                    int[] arr = q.poll();

                    for(int[] dir:directions)
                    {
                        int row = dir[0]+arr[0];
                        int col = dir[1] + arr[1];

                        if(row>=0 && row<m && col>=0 && col<n && rooms[row][col] != -1 && rooms[row][col] != 0)
                        {
                            if(rooms[row][col] > level)
                            {
                                rooms[row][col] = level;
                                q.add(new int[]{row,col});
                            }
                        }
                    }
                }
            }
        }
    }

