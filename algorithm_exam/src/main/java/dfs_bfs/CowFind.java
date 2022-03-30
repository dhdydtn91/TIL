package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class CowFind {

  int dir[] = {1, -1, 5};

  public static void main(String[] args) {
    CowFind cowFind = new CowFind();
    int person = 5;
    int cow = 14;
    int solution = cowFind.solution(person, cow);
    System.out.println(solution);
  }

  private int solution(int person, int cow) {
    int[] ch = new int[1001];
    ch[person] = 1;
    Queue<Integer> q = new LinkedList<>();
    q.offer(person);
    int count = 0;
    while (!q.isEmpty()) {
      int len = q.size();
      for (int i = 0; i < len; i++) {
        Integer point = q.poll();
        for (int num : dir) {
          int nx = point + num;
          if (nx == cow) {
            return count;
          }
          if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
            ch[nx] = 1;
            q.offer(nx);
          }
        }
      }
      count++;
    }
    return count;
  }
}
