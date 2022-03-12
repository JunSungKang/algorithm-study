package topcoder_book;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem.
 *
 * 준성이는 새로운 암호화 시스템을 개발했습니다.
 * 이 시스템은 암호화하려고 숫자 리스트를 입력받습니다.
 *
 * 여러분은 준성 비밀 정보 수사원이비다. 암호화 과정에서 중요한 부분을 구현하는 것이 여러분의 일입니다.
 * 여러분은 입력 리스트에서 1개의 값을 선택하고 값을 1 증가 시킵니다.
 * 이때 리스트 내부의 모든 숫자 곱이 가장 커져야 합니다.
 *
 * int[] numbers 형태로 숫자 배열이 주어질 때 곱의 최댓값을 리턴하세요.
 * 리턴값이 2^62를 넘는 문제는 절대 나오지 않습니다.
 *
 * (입출력 데이터 예시)
 * numbers = {1,2,3} // 2~50개의 요소가 있는 배열이며 각 요소의 값은 1~1000입니다.
 * returns = 12 // 정답
 */
public class Exam20220312 {

    /**
     * 문제 풀이 시작 : 2022-03-12 14:25
     * 문제 풀이 실제 완료 시간 : 2022-03-12 15:00 (5분 초과)
     * 문제 풀이 목표 완료 시간 : 2022-03-12 14:55
     */
    public static long solution(int[] numbers) {
        BigInteger max = new BigInteger("0");
        for (int i=0; i<numbers.length; i++) {
            int[] temp = numbers.clone();
            temp[i]++;

            BigInteger rst = new BigInteger("1");
            for (int t : temp) {
                rst = rst.multiply(new BigInteger( String.valueOf(t) ));
            }

            max = max.max(rst);
        }

        return max.longValue();
    }

    public static void main(String[] args){
        /*int[] numbers = {1,2,3};
        long result = 12;*/

        /*int[] numbers = {1,3,2,1,1,3};
        long result = 36;*/

        int[] numbers = {1000,999,998,997,996,995};
        long result = new BigInteger("986074810223904000").longValue();

        long answer = solution(numbers);

        // 문제 풀이에서 나온 답
        long testResult = answer;
        // 실제 정답
        long realResult = result;

        System.out.println("- 문제 풀이를 통한 정답 : " +answer);
        System.out.println("- 실제 정답안 : " +realResult);
        System.out.println( realResult == testResult );
    }
}
