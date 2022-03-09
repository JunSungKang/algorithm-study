package programmers_web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문제 제목
 * 2021 Dev-Matching: 웹 백엔드 개발 : 로또의 최고 순위와 최저 순위 : Level 1
 *
 * 문제 URL
 * https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
 */
public class Exam20220309 {

    /**
     * 문제 풀이 시작 : 2022-03-09 11:30
     * 문제 풀이 실제 완료 시간 : 2022-03-10 00:10
     * 문제 풀이 목표 완료 시간 : 2022-03-10 00:30
     */
    public static int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> win_nums_list = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        final int[] zeroCount = {0};
        long winnerCount = Arrays.stream(lottos)
            .filter( lotto -> {
                if (lotto == 0) {
                    zeroCount[0]++;
                    return false;
                }
                return true;
            })
            .filter( lotto -> win_nums_list.contains(lotto) )
            .count();

        // 정답
        int rank = 0;
        int[] answer = new int[2];

        // 최고 등수 (0인 숫자가 모두 당첨인 경우)
        rank = 7-((int)winnerCount+zeroCount[0]);
        answer[0] = rank > 5 ? 6 : rank;

        // 최저 등수 (0인 숫자가 모두 낙첨인 경우)
        rank = 7-(int)winnerCount;
        answer[1] = rank > 5 ? 6 : rank;

        return answer;
    }

    public static void main(String[] args){
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        int[] result = {3, 5};

        /*int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        int[] result = {1, 6};*/

        /*int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};
        int[] result = {1, 1};*/

        /*int[] lottos = {1, 2, 3, 4, 5, 6};
        int[] win_nums = {11, 12, 13, 14, 15, 16};
        int[] result = {6, 6};*/

        int[] answer = solution(lottos, win_nums);

        // 문제 풀이에서 나온 답
        String testResult = Arrays.toString(answer);
        // 실제 정답
        String realResult = Arrays.toString(result);

        System.out.println("- 문제 풀이를 통한 정답 : " +testResult);
        System.out.println("- 실제 정답안 : " +realResult);
        System.out.println( realResult.equals(testResult) );
    }
}
