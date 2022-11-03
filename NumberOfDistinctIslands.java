package Graphs;

import java.util.*;

public class NumberOfDistinctIslands {
    static int Row[] = {0 , 0 , 1, -1};

    static int Col[] = {1 , -1 , 0 ,0};
    static int D[] = {1 , 2 , 3 , 4};
    public static void main(String[] args) {
        int mat[][] = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};

        //  Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
        System.out.println(countDistinct(mat));
    }
    static int countDistinct(int[][] grid)
    {

        Set<String> set = new HashSet<>();
        for(int i = 0 ; i< grid.length;i++)
            for (int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == 1)
                {
                    set.add(Layout(grid,i,j));
                }
            }
        return set.size();
    }

    static String Layout(int grid[][] , int i , int j) {
        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new LinkedList<>();
        int size, current[], nR, nC;
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size != 0) {
                size--;
                 current = queue.poll();
                for (int k = 0; k < Row.length; k++) {
                    nR = current[0] + Row[k];
                    nC = current[1] + Col[k];
                    if (nR < 0 || nR == grid.length || nC < 0 ||
                            nC == grid[0].length || grid[nR][nC] != 1) {
                        sb.append(0);
                        continue;
                    }
                    if (grid[nR][nC] == 1) {
                        queue.add(new int[]{nR, nC});
                        grid[nR][nC] = 2;
                        sb.append(D[k]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
