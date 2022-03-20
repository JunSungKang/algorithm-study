package programmers_web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문제 제목
 * 스택/큐 : 기능개발 : Level 2
 *
 * 문제 URL
 * https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
 */
public class Exam20220321 {

    /**
     * 문제 풀이 시작 : 2022-03-21 01:15
     * 문제 풀이 실제 완료 시간 : 2022-03-21 02:30
     * 문제 풀이 목표 완료 시간 : 2022-03-21 02:15
     */
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> progresse = new LinkedList<>();
        Arrays.stream(progresses).forEach( i -> progresse.add(i) );

        int completeTotal = 0;
        while(progresse.size() > 0) {

            for (int i=0; i<progresse.size(); i++) {
                if (progresse.get(i) >= 100) {
                    continue;
                }

                progresse.set(i, progresse.get(i)+speeds[i+completeTotal]);
            }

            if (progresse.get(0) >= 100) {
                int removeCount = 0;
                while (progresse.size() > 0) {
                    if (progresse.get(0) < 100) {
                        break;
                    }
                    progresse.remove(0);
                    removeCount++;
                }
                completeTotal += removeCount;
                answer.add(removeCount);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        /*int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};
        int[] result = {2,1};*/

        /*int[] progresses = {95,90,99,99,80,99};
        int[] speeds = {1,1,1,1,1,1};
        int[] result = {1,3,2};*/

        /*int[] progresses = {55,60,65};
        int[] speeds = {5,10,7};
        int[] result = {3};*/

        int[] progresses = {40, 93, 30, 55, 60, 65};
        int[] speeds = {60, 1, 30, 5 , 10, 7};
        int[] result = {1,2,3};

        /*int[] progresses = {93, 30, 55, 60, 40, 65};
        int[] speeds = {1, 30, 5 , 10, 60, 7};
        int[] result = {2,4};*/

        int[] answer = solution(progresses, speeds);

        // 문제 풀이에서 나온 답
        int[] testResult = answer;
        // 실제 정답
        int[] realResult = result;

        System.out.println("- 문제 풀이를 통한 정답 : " +Arrays.stream(testResult).boxed().collect(Collectors.toList()));
        System.out.println("- 실제 정답안 : " +Arrays.stream(realResult).boxed().collect(Collectors.toList()));
    }
}
