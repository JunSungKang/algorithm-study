package programmers_web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문제 제목
 * 힙(Heap) : 더 맵게 : Level 2
 *
 * 문제 URL
 * https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
 */
public class Exam20220418 {

    /**
     * 최소 값 정렬, 단 전체 정렬이 아닌 가장 최근에 섞은 음식의 스코빌 지수가 들어갈 공간만 찾아서 정렬
     * @param scoville 스코빌 지수 목록
     * @return
     */
    public static List<Integer> sort(List<Integer> scoville) {
        int insertIdx = -1;
        int value = scoville.get(0);
        for (int i=1; i<scoville.size(); i++) {
            if (scoville.get(i) < value) {
                insertIdx = i;
            }
            if (scoville.get(i) >= value) {
                break;
            }
        }

        if (insertIdx > -1) {
            scoville.add(insertIdx+1, value);
            scoville.remove(0);
        }

        return scoville;
    }

    /**
     * 스코빌 지수 섞기
     * @param firstMin 가장 맵지 않은 음식 스코빌 지수
     * @param secondMin 두번째로 맵지 않은 음식 스코빌 지수
     * @return
     */
    public static int foodMix(int firstMin, int secondMin) {
        return firstMin + (secondMin * 2);
    }

    public static int solution(int[] scoville, int K) {
        // 섞은 횟수
        int answer = 0;

        int scovilleIdx = 0;
        int scovilleFirstMin = -1;
        int scovilleSecondMin = -1;

        // 최초 오름차순 정렬
        List<Integer> scovilles = Arrays.stream(scoville).sorted().boxed().collect(Collectors.toList());

        // 스코빌 지수 인덱스 번호가 3을 넘어가면 루프 탈출
        // sort 함수를 통해서 최소값이 맨 앞으로 당겨져있기 때문에 뒤에 인덱스에 있는 값은 볼 필요없음
        while(scovilleIdx < 2){
            if (scovilles.size() < 2 && scovilles.get(0) < K) {
                answer = -1;
                break;
            } else if (scovilles.size() < 2 && scovilles.get(0) > K) {
                break;
            }

            if (scovilles.get(scovilleIdx) < K && scovilleFirstMin == -1) {
                // 가장 맵지 않은 스코빌 지수일 때
                scovilleFirstMin = scovilles.get(scovilleIdx);
            } else if (scovilleFirstMin > -1 && scovilleSecondMin == -1) {
                // 가장 맵지 않은 스코빌 지수가 K 보다 낮은 값이 있고,
                // 두번째로 맵지 않은 스코빌 지수를 넣어야할 때
                scovilleSecondMin = scovilles.get(scovilleIdx);
            }

            // 다음 순서에 있는 스코빌 지수
            scovilleIdx++;

            // 가장 맵지 않은 스코빌 지수와 두번째로 맵지 않은 스코빌 지수를 찾았을 때
            if (scovilleFirstMin > -1 && scovilleSecondMin > -1) {
                // 새로운 스코빌 지수 등록
                int value = foodMix(scovilleFirstMin, scovilleSecondMin);
                scovilles.set(1, value);
                scovilles.remove(0);

                // 값 초기화
                scovilleIdx = 0;
                scovilleFirstMin = -1;
                scovilleSecondMin = -1;

                // 스코빌 지수 정렬
                scovilles = sort(scovilles);

                // 섞은 횟수 증가
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int result = 2;

        int answer = solution(scoville, K);

        // 문제 풀이에서 나온 답
        int testResult = answer;
        // 실제 정답
        int realResult = result;

        System.out.println("- 문제 풀이를 통한 정답 : " +testResult);
        System.out.println("- 실제 정답안 : " +realResult);
    }
}
