package dfs_bfs;

public class RouteNavigation {

  public static void main(String[] args) {
    RouteNavigation routeNavigation = new RouteNavigation();
    int arr [][] = {{1,2}, {1,3}, {1,4}, {2,1},{2,3},{2,5},{3,4},{4,2},{4,5}};
    int n = 5;
    solution(arr,n);
    System.out.println(answer);
  }

  static int n , m , answer = 0 ;
  static int [][] graph;
  static int [] ch;

  private static void solution(int[][] arr, int goal) {
    n = goal;
    ch = new int [n+1];
    graph = new int [n+1][n+1];
    m = graph.length;
    for(int i = 0; i < arr.length; i++){
      graph[arr[i][0]][arr[i][1]] = 1;
    }
    ch[1]= 1;
    dfs(1);
  }

  private static void dfs(int v) {
    if(v == n )answer++;
      else{
        for(int i = 1 ; i <=n ;i++){
            if(graph[v][i] ==1 && ch[i] ==0){
              ch[i] = 1;
              dfs(i);
              ch[i] = 0;
          }
        }
    }
  }
}
