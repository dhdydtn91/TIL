package Graph;

public class NumberOfIsland {

    public static void main(String[] args) {
         char grid[][] = {
                 {'1','1','0','0','0'},
                 {'1','1','0','0','0'},
                 {'1','1','1','0','0'},
                 {'0','0','0','1','1'}
         };

         NumberOfIsland a = new NumberOfIsland();
        System.out.println(a.solve(grid));
    }

    int m , n;
    int [][] dirs = {{-1, 0 }, {1, 0} , {0,1}, {0,-1}};
    int count = 0 ;
    public int solve(char grid[][]){
        if(grid == null || grid.length == 0 || grid[0].length ==0)
            return 0;
        m = grid.length;
        n = grid[0].length;

        for(int i =0 ; i<m ;i++){
            for(int j =0 ; j<n ; j++){
                if(grid[i][j] == '1'){
                    count ++;
                    dfs(grid, i , j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(i < 0 || i >= m || j< 0 || j >=n || grid[i][j] != '1'){
            return;
        }
        grid[i][j] ='X';

        for(int []a : dirs){
            dfs(grid,i+a[0], j+a[1]);
        }

    }
}
