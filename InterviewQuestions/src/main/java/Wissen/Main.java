package Wissen;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,1,0,0,1,0},{0,1,0,0,1,0},{0,1,1,1,1,0},{0,0,0,0,0,0}};
        System.out.println("Current grid");
        printGrid(grid);
        Paint p = new Paint(grid);
        p.paintAll(0,0);
        System.out.println("after painting!");
        printGrid(grid);
    }
    public static void printGrid(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.printf("%d ",grid[i][j]);
            }
            System.out.println();
        }
    }
}
