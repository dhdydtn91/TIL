package programmer;

import java.util.*;
import java.util.stream.Collectors;

//카카오 블라인드 2022 신고 결과 받기
public class BanResultSend
{
    public static void main(String[] args) {
        String str1[] = {"muzi", "frodo", "apeach", "neo"};
        String str2[] = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] eee = eee(str1, str2, k);

        for(int i = 0 ; i < eee.length ; i++){
            System.out.println(eee[i]);
        }
    }

    public static int [] eee(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 신고한 사람과 신고당한 사람들을 묶는 맵 (문자열, 리스트)
        Map <String ,List<String>> map = new HashMap <String, List<String>>();

        // 신고 누적 갯수를 가지고 있는 맵(문자열 , 숫자)
        Map <String ,Integer> map2 = new HashMap <String, Integer>();

        List<String> names = Arrays.stream(report)
                .distinct().collect(Collectors.toList());

        for(int i = 0 ; i < names.size() ; i++){
            String users = names.get(i);
            // 신고한 사람과 신고당한 사람을 나눈다.
            String usernames [] = users.split(" ");

            // 맵에 Key 신고한 사람과 Value 신고 당한 사람을 넣는다.
            String user1 = usernames[0];
            String user2 = usernames[1];
            List<String> list = map.getOrDefault(user1, new ArrayList<>());
            list.add(user2);
            map.put(user1,list);

            // 맵에 신고 누적을 기록한다.
            map2.put(user2, map2.getOrDefault(user2, 0)+1);
        }

        for(int i = 0 ; i < id_list.length ; i++){
            String user = id_list[i];
            List<String> strings = map.get(user);
            int count = 0 ;
                if(strings != null) {
                    for (int j = 0; j < strings.size(); j++) {
                        // 신고한 사람 기준으로 신고당한 사람을 뽑는다.
                        String name = strings.get(j);
                        //신고 누적갯수를 뽑아서 k보다 큰지 비교
                        if (map2.get(name) >= k) {
                            count++;
                        }

                    }
                }
            // 결과 만들기
            answer[i] = count;
        }
        return answer;
    }
}
