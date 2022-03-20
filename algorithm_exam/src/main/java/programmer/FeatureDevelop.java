package programmer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FeatureDevelop {

  public int[] solution(int[] progresses, int[] speeds) {
    List <Integer> list = new ArrayList<>();
    Queue<Integer> queue = new LinkedList();
    //작업 순서대로 큐에 적재
    for(int i = 0 ; i < progresses.length ; i++){
      queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
    }

    while(!queue.isEmpty()){
      int count = 1;
      int completeDay = queue.poll();
      while(!queue.isEmpty()&&queue.peek() <= completeDay){
          queue.poll();
          count++;
      }
      list.add(count);
    }
    return list.stream().mapToInt(Integer::intValue).toArray();
  }
  public static void main(String[] args) {
    FeatureDevelop  featureDevelop = new FeatureDevelop();

    int[] progresses = {95, 90, 99, 99, 80, 99};
    int[] speeds = {1, 1, 1, 1, 100, 100};
    int[] solution = featureDevelop.solution(progresses, speeds);
    for (int i : solution) {
      System.out.println("i = " + i);
    }
  }
}
