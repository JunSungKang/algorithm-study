package topcoder_book;

import java.util.Arrays;

/**
 * Problem.
 *
 * 준성이는 맛있는 키위 주스를 준비했습니다. 0부터 N-1이라 이름을 붙인 N개의 병에 키위 주스를 넣었습니다.
 * 이때 i번째의 병의 용량은 capacities[i], i번째 병에 넣은 키위 주스의 양은 bottles[i] 입니다.
 * 병의 용량: capacities[i]
 * 주스의 양: bottles[i]
 *
 * 준성이는 키위 주스를 재분배하기 위해서, 0부터 M-1회까지 M회 조작합니다.
 * i번째 조작은 준성이가 fromId[i]부터 병 toId[i]에 키위 주스를 넣는 것을 의미합니다.
 *
 * 병 fromId[i]가 비어 있거나 병 toId[i]가 꽉 차는 순간 준성이는 키위 주스를 넣지 않습니다.
 *
 * N개의 요소를 가진 정수 배열 int[]를 리턴해주세요. 배열의 i번째 요소는 모든 주스를 쏟는 작업이 완료되고,
 * i번째 병에 남아 있는 키위 주스의 양입니다.
 *
 * (입출력 데이터 예시)
 * capacities = {20, 20} // 2~50개의 요소를 가지며, 각 요소는 1~1000000 사이의 값을 갖습니다.
 * bottles = {5,8} // capacities와 같은 수의 요소가 있는 배열이며, bottles[i]는 capacities[i]에 들어있는 주스를 의미합니다.
 * fromId = {0} // 1~50개의 요소가 있는 배열입니다.
 * toId = {1} // fromId와 같은 수의 요소가 있는 배열입니다.
 * 정답 = {0, 13}
 *
 * 변수 fromId와 toId는 0~(N-1) 사이의 값입니다. 이때 N은 변수 capacities의 항목 개수입니다.
 * 변수 fromId[i]와 toId[i]는 서로 다른 값을 갖습니다.
 */
public class Exam20220305 {

    /**
     * 문제 풀이 시작 : 2022-03-05 15:55
     * 문제 풀이 실제 완료 시간 : 2022-03-05 16:26
     * 문제 풀이 목표 완료 시간 : 2022-03-05 16:55
     */
    public static int[] solution(int[] capacities, int[] bottles, int[] fromId, int[] toId) {
        int count = fromId.length;
        for (int i=0; i<count; i++) {
            int from = fromId[i];
            int to = toId[i];

            if (bottles[to] + bottles[from] >= capacities[to]) {
                // 남아 있는 용량
                bottles[from] = bottles[from] - (capacities[to] - bottles[to]);
                // 꽉찬 용량
                bottles[to] = capacities[to];
            } else {
                bottles[to] = bottles[to] + bottles[from];
                bottles[from] = 0;
            }
        }

        return bottles;
    }

    public static void main(String[] args){
        int[] capacities = {20,20};
        int[] bottles = {5,8};
        int[] fromId = {0};
        int[] toId = {1};
        int[] result = {0,13};

        /*int[] capacities = {10,10};
        int[] bottles = {5,8};
        int[] fromId = {0};
        int[] toId = {1};
        int[] result = {3,10};*/
    
        /*int[] capacities = {700000,800000,900000,1000000};
        int[] bottles = {478478,478478,478478,478478};
        int[] fromId = {2,3,2,0,1};
        int[] toId = {0,1,1,3,2};
        int[] result = {0,156956,900000,856956};*/
    
        /*int[] capacities = {14,35,86,58,25,62};
        int[] bottles = {6,34,27,38,9,60};
        int[] fromId = {1,2,4,5,3,3,1,0};
        int[] toId = {0,1,2,4,2,5,3,1};
        int[] result = {0,14,65,35,25,35};*/
            
        int[] answer = solution(capacities, bottles, fromId, toId);

        // 문제 풀이에서 나온 답
        String testResult = Arrays.toString(answer);
        // 실제 정답
        String realResult = Arrays.toString(result);

        System.out.println("- 문제 풀이를 통한 정답 : " +testResult);
        System.out.println("- 실제 정답안 : " +realResult);
        System.out.println( realResult.equals(testResult) );
    }
}
