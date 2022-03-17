package programmer;

import java.util.LinkedList;
import java.util.Queue;

public class KaKaoColoringBook_BFS {

  public static void main(String[] args) {
    int input[][] =
{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
    int m = 6;
    int n = 4;
    KaKaoColoringBook_BFS a = new KaKaoColoringBook_BFS();
    int[] solution = a.solution(m, n, input);

    for (int i : solution) {
      System.out.println(i);
    }
  }
  static int dirs[][] = {{-1,0}, {0,-1}, {1,0},{0,1}};
  static Queue<int[]> q = new LinkedList();
  static boolean[][] visited;

  public int[] solution(int m, int n, int[][] picture) {
    int[] answer = new int[2];

    int numberOfArea = 0;  //색칠해져 있는 영역갯수
    int maxSizeOfOneArea = 0; // 가장 큰 영역의 칸수
    visited = new boolean[m][n];
    for(int i = 0; i < m ; i++){
      for(int j = 0 ; j < n ; j++) {
        if(picture[i][j] != 0 && !visited[i][j]){
          numberOfArea++;
          int tmp = picture[i][j];
          int count  = 1;
          int max = bfs(picture, tmp, i, j, count);
          maxSizeOfOneArea = Math.max(maxSizeOfOneArea,max);
        }
      }
    }
    answer [0] = numberOfArea;
    answer [1] = maxSizeOfOneArea;
    return answer;
  }

  public int bfs(int[][] input, int tmp, int i, int j,int count) {
    visited[i][j] = true;
    q.offer(new int[]{i, j});
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      for (int[] dir : dirs) {
        int x1 = cur[0] + dir[0];
        int y1 = cur[1] + dir[1];
        if (x1 >= 0 && y1 >= 0 && x1 < input.length && y1 < input[0].length
            && !visited[x1][y1] && tmp == input[x1][y1]) {
          q.offer(new int[]{x1,y1});
          visited[x1][y1] = true;
          count++;
        }
      }
    }
    return count;
  }
}
