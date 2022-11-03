package Graphs;
import java.util.*;
public class Floyd_Warshall {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,43},{1,0,6},{-1,-1,0}};
        floydWarshall_shortest_ways(matrix);
        int n = matrix.length;
        for (int i = 0 ; i<n ; i++)
            for (int j = 0 ; j<n ; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
        System.out.println();

    }

    private static void floydWarshall_shortest_ways(int[][] matrix) {

        //change all the negative ones which shows path not possible
        int n = matrix.length;
        for (int i = 0 ; i<n ; i++)
            for (int j = 0 ; j<n ; j++)
            {
                if (matrix[i][j] == -1)
                {
                    matrix[i][j] = (int) 1e9;
                }
                if (i==j)
                {
                    matrix[i][j] = 0; //diagonally not possible
                }
            }
        for (int view = 0 ; view<n ; view++)
            for (int i = 0 ; i<n ; i++)
                for (int j = 0 ; j<n ; j++)
                {
                    matrix[i][j] = Math.min(matrix[i][j] , matrix[i][view] + matrix[view][j]);
                }

        for (int i = 0 ; i<n ; i++)
            for (int j = 0 ; j<n ; j++) {
                if (matrix[i][j] == (int) 1e9) {
                    matrix[i][j] = -1;
                }
            }
    }
}
