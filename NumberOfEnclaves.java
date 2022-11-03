package Graphs;

public class NumberOfEnclaves {
    public static void main(String[] args) {
        int mat[][] = {{0,0,0,0},
                      {1,0,1,0},
                      {0,1,1,0},
                      {0,0,0,0}};

        //  Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
        System.out.println(number(mat));
    }

    public static int number(int[][] grid)
    {
        int m = grid.length;
        int n = grid[0].length;

        //At first find out the one's in the boundaries and convert it and touching ones to zeroes

        for(int i = 0 ; i<m ; i++)
            for(int j = 0 ; j<n ; j++)
            {
                if(grid[i][j] == 1)
                {
                    if(i == 0 || j == 0 || i == m-1 || j == n-1)
                    {
                        dfs(grid,i , j);
                    }
                }
            }
        //Now count the remaining ones
        int one =  0;
        for(int i = 0 ; i<m ; i++)
            for(int j = 0 ; j<n ; j++)
            {
                if(grid[i][j] == 1)one++;
            }
        return one;
    }
    public  static  void dfs(int[][] grid , int i , int j)
    {
        if(i<0 || j< 0 || j>= grid[0].length || i >= grid.length || grid[i][j] == 0)return;
        grid[i][j] = 0;
        dfs(grid , i + 1 , j);
        dfs(grid , i - 1 , j);
        dfs(grid , i  , j + 1);
        dfs(grid , i  , j - 1);


    }
}
