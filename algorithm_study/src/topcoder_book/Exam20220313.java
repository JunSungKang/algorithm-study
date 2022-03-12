package topcoder_book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem.
 *
 * 숫자 3과 9는 재미있는 성질이 있습니다. 3의 배수의 각 자릿수의 합은 다른 3의 배수가 됩니다.
 * 예를 들어 118x3=354이고, 각 자릿수의 합은 3+5+4=12로 결과 값은 3의 배수입니다.
 * 마찬가지로 9의 배수의 각 자릿수의 합은 다른 9의 배수가 됩니다.
 * 예를 들어 75x9=675이고, 각 자릿수의 합은 6+7+5=18은 결과 값은 9의 배수입니다.
 *
 * 어떤 진법에서 이러한 성질을 갖는다고 다른 진법에서 이러한 성질을 가지지는 않습니다.
 * 예를 들어 10진수에서 3은 이러한 성질을 가지지만 5진수에서는 성립하지 않습니다.
 * 또한 10진수에서 모든 곱을 고려할 때에는 999보다 큰 값은 고려하지 않아도 됩니다.
 *
 * (입출력 데이터 예시)
 * base = 10 // 3~30의 정수
 * returns = {3,9} // 정답
 */
public class Exam20220313 {

    /**
     * 문제 풀이 시작 : 2022-03-13 02:35
     * 문제 풀이 실제 완료 시간 : 2022-03-13 03:20
     * 문제 풀이 목표 완료 시간 : 2022-03-13 03:30
     * @return
     */
    public static int[] solution(int base) {
        List<Integer> tAnswer = new ArrayList<>();

        for (int i=2; i<base; i++) {
            if ((base-1)%i == 0) {
                tAnswer.add(i);
            }
        }

        int[] answer = new int[tAnswer.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = tAnswer.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        int base = 10;
        int[] result = {3,9};

        /*int base = 3;
        int[] result = {2};*/

        /*int base = 9;
        int[] result = {2,4,8};*/

        /*int base = 26;
        int[] result = {5,25};*/

        int[] answer = solution(base);

        // 문제 풀이에서 나온 답
        String testResult = Arrays.toString(answer);
        // 실제 정답
        String realResult = Arrays.toString(result);

        System.out.println("- 문제 풀이를 통한 정답 : " +testResult);
        System.out.println("- 실제 정답안 : " +realResult);
        System.out.println( realResult.equals(testResult) );
    }
}
