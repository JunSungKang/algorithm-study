package programmers_web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 문제 제목
 * 2022 KAKAO BLIND RECRUITMENT : 신고 결과 받기 : Level 1
 *
 * 문제 URL
 * https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
 */
public class Exam20220308 {

    // 반환 값 -1: 일치하는 아이디 없음
    // 반환 값이 -1이 아닌 경우: 일치하는 아이디의 index 값
    public static int searchIdIdx(String[] id_list, String id) {
        for (int i=0; i<id_list.length; i++) {
            if (id_list[i].equals(id)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 문제 풀이 시작 : 2022-03-08 22:45
     * 문제 풀이 실제 완료 시간 : 2022-03-06 23:25
     * 문제 풀이 목표 완료 시간 : 2022-03-06 23:45
     */
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        // key: 신고 당한자, value: 신고한 자
        Map<String, Set<String>> target = new HashMap<>();

        // 신고한 사람과 신고 당한사람 정리
        for (int i=0; i<report.length; i++) {
            // user[0]: 신고한 자(value)
            // user[1]: 신고 당한자(key)
            String[] user = report[i].split(" ");

            // 최초 신고자인 경우를 위해 Set 생성
            Set<String> init = new HashSet<>();
            init.add(user[0]);

            target.merge(user[1], init, (users1, users2) -> {
                users1.addAll(users2);
                return users1;
            });
        }

        // 알림메일 받는 횟수 측정
        for (Entry<String, Set<String>> data : target.entrySet()) {
            int count = data.getValue().size();

            if (count >= k) {
                // 신고 허용수치를 초과하는 경우
                for (String id : data.getValue()) {
                    int idx = searchIdIdx(id_list, id);
                    if (idx < 0) {
                        // 일치하는 아이디가 없을 때
                        continue;
                    }

                    // 알림메일 받는 횟수 증가
                    answer[idx]++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = {2,1,1,0};

        /*String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;
        int[] result = {0,0};*/

        int[] answer = solution(id_list, report, k);

        // 문제 풀이에서 나온 답
        String testResult = Arrays.toString(answer);
        // 실제 정답
        String realResult = Arrays.toString(result);

        System.out.println("- 문제 풀이를 통한 정답 : " +testResult);
        System.out.println("- 실제 정답안 : " +realResult);
        System.out.println( realResult.equals(testResult) );
    }
}
