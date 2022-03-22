package hash;

import java.util.HashMap;
import java.util.Map;

public class ClassPresident {

  public static void main(String[] args) {
    ClassPresident a =new ClassPresident();
    String s = "BACBACCACCBDEDEBBC";
    String solution = a.solution(s);
    System.out.println(solution);
  }

  public String solution(String s) {
    String aws = "";
    Map<String,Integer> map =new HashMap<>();
    int max = Integer.MIN_VALUE ;
    for(int i = 0 ; i < s.length() ; i++){
      String substring = s.substring(i, i + 1);
      map.put(substring,map.getOrDefault(substring,0)+1);
      if(max < map.get(substring)){
        max =  map.get(substring);
        aws = substring;
      }
    }
    return aws;
  }
}
