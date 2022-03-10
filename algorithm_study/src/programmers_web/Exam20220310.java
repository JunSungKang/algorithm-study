package programmers_web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문제 제목
 * 탐욕범(Greedy) : 체육복 : Level 1
 *
 * 문제 URL
 * https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */
public class Exam20220310 {

    /**
     * 빌러줄 사람이 있는지 확인
     * 학생의 입장에서 왼쪽에 있는 학생이 빌려주는 우선순위가 높음

     * @param reserves 여분의 옷을 갖고 있는 사람
     * @param lost_person 체육복을 잃어버린 사람
     * @return 빌려줄 사람이 있는 경우 -1보다 큰 값
     **/
    public static int rental(List<Integer> reserves, int lost_person) {
        int reserveIdx = reserves.indexOf(lost_person-1);
        if (reserveIdx > -1) {
            // 왼쪽의 학생이 여분이 있는 경우
            return reserveIdx;
        }

        // 왼쪽 학생이 여분이 없는 경우에는 오른쪽 학생의 여분을 확인
        reserveIdx = reserves.indexOf(lost_person+1);
        return reserveIdx;
    }

    /**
     * 문제 풀이 시작 : 2022-03-10 20:40
     * 문제 풀이 실제 완료 시간 : 2022-03-10 21:40
     * 문제 풀이 목표 완료 시간 : 2022-03-10 21:30
     */
    public static int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(reserve);
        Arrays.sort(lost);

        long count = 0;
        final List<Integer> reserves = new ArrayList<>();
        final List<Integer> losts = new ArrayList<>();

        // 중복숫자 제거
        for (int i=0; i<lost.length; i++) {
            final int l = lost[i];
            count = Arrays.stream(reserve).filter(r->l==r).count();
            if (count == 0) {
                // 같은 학생이 없는 경우에만 추가
                losts.add(lost[i]);
            }
        }

        // 중복제거
        for (int i=0; i<reserve.length; i++) {
            final int r = reserve[i];
            count = Arrays.stream(lost).filter(l->l==r).count();
            if (count == 0) {
                // 같은 학생이 없는 경우에만 추가
                reserves.add(reserve[i]);
            }
        }

        // 체육복 빌려주기
        int answer = losts.size();
        for (int i=0; i<losts.size(); i++) {
            int lost_person = losts.get(i);
            int idx = rental(reserves, lost_person);
            if (idx > -1) {
                reserves.remove(idx);
                answer--;
            }
        }

        return n-answer;
    }

    public static void main(String[] args){
        int n = 5;
        int[] lost = {2,4};
        int[] reserve = {1,3,5};
        int result = 5;

        /*int n = 5;
        int[] lost = {2,4};
        int[] reserve = {3};
        int result = 4;*/

        /*int n = 7;
        int[] lost = {2,3,4};
        int[] reserve = {1,2,3,6};
        int result = 6;*/

        int answer = solution(n, lost, reserve);

        // 문제 풀이에서 나온 답
        int testResult = answer;
        // 실제 정답
        int realResult = result;

        System.out.println("- 문제 풀이를 통한 정답 : " +testResult);
        System.out.println("- 실제 정답안 : " +realResult);
        System.out.println( realResult == testResult );
    }
}
