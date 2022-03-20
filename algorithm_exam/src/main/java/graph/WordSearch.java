package graph;

public class WordSearch {

    public static void main(String[] args) {
       char grid[][] = {
               {'A','B','C','E'},
               {'S','F','C','S'},
               {'A','D','E','E'}
       } ;
       String word = "SEE";

        WordSearch wordSearch = new WordSearch();
        boolean solve = wordSearch.solve(grid, word);
        System.out.println(solve);

    }

    int [][]dirs = {{-1,0}, {0,-1}, {1,0},{0,1}};
    int m ,n ;
    public boolean solve(char[][] grid, String word) {
        if(grid == null || grid.length ==0) return false;
        m = grid.length;
        n = grid[0].length;
        int depth = 0;
        for(int i = 0; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == word.charAt(depth)){
                    depth = dfs(grid, i , j , word, depth);
                    if(depth == word.length() -1){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private int dfs(char[][] grid, int i, int j, String word, int depth) {
        if(depth == word.length() -1 || grid == null) {
            return depth;
        }

        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != word.charAt(depth)){
            return depth;
        }
        depth ++;
        for(int[] dir : dirs){
            depth = dfs(grid , i+dir[0] , j+dir[1], word,depth);
        }
        return depth;
    }


}
