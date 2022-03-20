package programmers_web;

/**
 * 문제 제목
 * 깊이/너비 우선 탐색(DFS/BFS) : 타겟 넘버 : Level 2
 *
 * 문제 URL
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */
public class Exam20220320 {

    public static int loop(int[] numbers, int n, int value, int target) {
        if (numbers.length == n) {
            return value == target ? 1 : 0;
        }

        int rst = 0;
        rst += loop(numbers, n+1, value+numbers[n], target);
        rst += loop(numbers, n+1, value-numbers[n], target);
        return rst;
    }
    /**
     * 문제 풀이 시작 : 2022-03-20 18:00
     * 문제 풀이 실제 완료 시간 : 2022-03-20 19:04
     * 문제 풀이 목표 완료 시간 : 2022-03-20 19:00
     */
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer += loop(numbers, 1, +1*numbers[0], target);
        answer += loop(numbers, 1, -1*numbers[0], target);
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = 5;

        /*int[] numbers = {4,1,2,1};
        int target = 4;
        int result = 2;*/

        int answer = solution(numbers, target);

        // 문제 풀이에서 나온 답
        int testResult = answer;
        // 실제 정답
        int realResult = result;

        System.out.println("- 문제 풀이를 통한 정답 : " + testResult);
        System.out.println("- 실제 정답안 : " + realResult);
        System.out.println(realResult == testResult);
    }
}
