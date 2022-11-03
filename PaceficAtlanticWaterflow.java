package Graphs;
//https://leetcode.com/problems/pacific-atlantic-water-flow/
import java.util.*;
public class PaceficAtlanticWaterflow {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(pacificAtlantic(heights));
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int row =  heights.length;
        int col = heights[0].length;
        /*
                  P A C E F I C
               P  1 2 2 3 5   A
               A  3 2 3 4 4   T
               C  2 4 5 3 1   L
               E  6 7 1 4 5   A
               F  5 1 1 2 4   N
               I                T
               C                I
                 A T L A N T I  C
         */

        if(row == 0 || col == 0 || heights == null)return res;

        boolean atlantic[][] = new boolean[row][col];
        boolean pacefic[][] = new boolean[row][col];

        //DFS
        //for top and bottom row
        for (int i = 0 ; i<col ; i++)
        {
            dfs(heights,0,i,Integer.MIN_VALUE,pacefic);
            dfs(heights,row-1,i,Integer.MIN_VALUE,atlantic);
        }
        //for left and right column
        for (int i = 0 ; i<row ; i++)
        {
            dfs(heights,i,0,Integer.MIN_VALUE,pacefic);
            dfs(heights,i,col-1,Integer.MIN_VALUE,atlantic);
        }
        //RESULT: WHERE BOTH ARE TRUE

        for (int i = 0 ; i<row ; i++)
            for (int j = 0 ; j<col ; j++)
            {
                if(atlantic[i][j] && pacefic[i][j])
                {
                    res.add(Arrays.asList(i,j));
                }
            }
        return res;

    }
    static void dfs(int[][] grid, int i , int j , int prev , boolean[][] vis)
    {
        if(i<0 || i>=grid.length || j>= grid[0].length || j<0 )return;
        if(vis[i][j] || grid[i][j] < prev)return;
        vis[i][j] = true;
        dfs(grid,i+1,j,grid[i][j],vis);
        dfs(grid,i-1,j,grid[i][j],vis);
        dfs(grid,i,j+1,grid[i][j],vis);
        dfs(grid,i,j-1,grid[i][j],vis);


    }
}
