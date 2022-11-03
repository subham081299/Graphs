package Graphs;
//https://leetcode.com/problems/surrounded-regions/
import java.util.*;
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] grid = {{'X','X','X','X'},
                         {'X','O','O','X'},
                         {'X','X','O','X'},
                         {'X','O','X','X'}};
        solve(grid);
        for(int i = 0 ; i<grid.length;i++) {
            for(int j = 0 ; j<3 ; j++)
            {
                System.out.print(grid[i][j]+" ");
            }System.out.println();
        }


    }
    public static void solve(char[][] grid)
    {
        int m = grid.length;
        int n =  grid[0].length;

        //only borders O will not change
        /*
          So we are at first checking the loation of zeroes in the border and  we are marking them #
          after wards we will change the entire members to X leaving the #
          then change the # to 0
         */
        for(int i = 0 ; i<m ; i++)
        {
            if(grid[i][0] == 'O')dfs(grid,i,0);
            if(grid[i][n-1] == 'O')dfs(grid,i,n-1);
        }

        for(int i = 0 ; i<n ; i++)
        {
            if(grid[0][i] == 'O')dfs(grid, 0 , i);
            if(grid[m-1][i] == 'O')dfs(grid,m-1 , i);
        }
        for(int i = 0 ; i<m ; i++)
            for(int j = 0 ; j < n ; j++)
            {
                if(grid[i][j]=='#')
                {
                    grid[i][j] = 'O';
                }
                else{
                    grid[i][j] = 'X';
                }
            }

    }
    static void dfs(char[][] grid,int i , int j)
    {
        if(i>= grid.length || j>= grid[0].length || j<0 || i<0)return;
        if(grid[i][j] == 'O')
        {
            grid[i][j] = '#';
            dfs(grid , i+1 , j);
            dfs(grid , i-1 , j);
            dfs(grid , i , j+1);
            dfs(grid , i , j-1);

        }
    }
}
