package programmer;

public class KakaoColoringBook {

  static int dirs[][] = {{-1,0}, {0,-1}, {1,0},{0,1}};

  public static int[] solution(int m, int n, int[][] picture) {
    int[] answer = new int[2];

    int numberOfArea = 0;  //색칠해져 있는 영역갯수
    int maxSizeOfOneArea = 0; // 가장 큰 영역의 칸수
    if(m == 0 || n == 0){
      answer [0] = 0;
      answer [1] = 0;

      return answer;
    }

    for(int i = 0; i < m ; i++){
      for(int j = 0 ; j < n ; j++){
        if(picture[i][j] != 0){
          numberOfArea++;
          int count = 0;
          int tmpNum = picture[i][j];
          int dfs = dfs(i, j, m, n, picture, count , tmpNum);
          maxSizeOfOneArea = Math.max(maxSizeOfOneArea,dfs);
        }
      }
    }
    answer[0] = numberOfArea;
    answer[1] = maxSizeOfOneArea;


    return answer;
  }

  private static int dfs(int i, int j, int m, int n, int[][] picture ,int count , int tmpNum) {
    if(i >= m || j >=n || i < 0 || j < 0 || picture[i][j] != tmpNum){
      return count;
    }
    picture[i][j] =0;
    count++;
    for(int []dir : dirs){
      count = dfs(i+dir[0], j+dir[1], m , n ,picture, count , tmpNum);
    }
    return count;
  }

  public static void main(String[] args) {
    int input[][] =
      {   {1, 1, 1, 0},
          {1, 1, 1, 0},
          {0, 0, 0, 1},
          {0, 0, 0, 1},
          {0, 0, 0, 1},
          {0, 0, 0, 1}};
    int m = 6;
    int n = 4;
    int[] solution = solution(m, n, input);

    for (int i : solution) {
      System.out.println(i);
    }
  }
}
