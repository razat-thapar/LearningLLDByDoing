package Wissen;

import java.util.LinkedList;
import java.util.Queue;

public class Paint {
    //grid.
    //0-> white ,  1 -> black.
    private final int[][] grid;
    public Paint(int[][] grid){
        this.grid = grid;
    }
    private class Cell{
        int x;
        int y;
        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public void paintAll(int x, int y){
        //BFS algorithm.
        // each cell is node
        // we have an edge with all 4 adjacent nodes.
        //color only nodes that are white adjacent nodes.
        int n = grid.length;
        int m = grid[0].length;
//        int[] dx = {1,1,0,-1,-1,-1,0,1};
//        int[] dy = {0,1,1,1,0,-1,-1,-1};
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<Cell> q = new LinkedList<>();
        //push src.
        q.add(new Cell(x,y));
        Cell front ;
        int nbr_x, nbr_y;
        while(!q.isEmpty()){
            //get front.
            front = q.peek();
            q.remove();
            //mark visited.
            fill(front.x,front.y);
            //visit all unvisited neighbors
            for(int d=0;d<dx.length;d++){
                nbr_x = front.x+dx[d];
                nbr_y = front.y+dy[d];
                //check out of bounds and isVisited.
                if(nbr_x >=0 && nbr_x<n && nbr_y>=0 && nbr_y<m && !isFilled(nbr_x,nbr_y)){
                    //push into queue.
                    q.add(new Cell(nbr_x,nbr_y));
                }
            }
        }
    }
    public boolean isFilled(int x, int y){
        if(grid[x][y]==0){
            return false;
        }
        return true;
    }

    public void fill(int x, int y){
        grid[x][y]=1;
    }

}
