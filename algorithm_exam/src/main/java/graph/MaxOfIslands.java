package graph;

public class MaxOfIslands {


    public static void main(String[] args) {
        int [][]grid = {
                {1,1,0,1,1},
                {0,1,1,0,0},
                {0,0,0,0,0},
                {1,1,0,0,1},
                {1,0,0,0,1},
                {1,0,0,0,1}
        };
        MaxOfIslands a = new MaxOfIslands();
        System.out.println(a.solve(grid));
    }
    int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    int m =0;
    int n =0;

    private int solve(int[][] grid) {
        if(grid == null){
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ;j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid,i,j,0);
                    max = Math.max(max,area);
                }

            }
        }

        return max;
    }

    private int dfs(int[][] grid, int i, int j, int area) {
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1 ){
            return area;
        }
        area ++;
        grid[i][j] = 0;
        for (int [] dir : dirs){
           area= dfs(grid,dir[0] +i , dir[1] +j,area);
        }
        return area;
    }


}
