package year_2022.month_03;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Problem.
 *
 * 준성이는 다재다능한 사람입니다. 그래서 그에게는 친구가 많습니다.
 * 하지만 불행하게도 그의 친구들은 다재다능하지 않습니다.
 * 각각의 친구는 2가지 주제에만 관심이 있고 다른 주제로 이야기하는 것을 싫어합니다.
 * 그래서 파티를 개최할 떄마다 모두가 즐겁게 파티를 보내려면 어떤 친구를 초대할지가 큰 문제입니다.
 *
 * 준성이는 그 동안의 경험으로 초대된 친구 모두가 공통의 흥미 있는 화제가 있으 ㄹ때 파티를 즐긴하는 것을 알았습니다.
 * 문자열 배열 first, second가 주어집니다.
 *
 * 준성이는 i번째 친구가 흥미 있는 화제는 first[i]와 second[i]입니다.
 * 즐거운 파티가 되려면 준성이가 초대할 수 있는 친구는 최대 몇 명인지 리턴하세요.
 *
 * (입출력 데이터 예시)
 * first = {"fishing", "gardening", "swimming", "fishing"} // 1~50개의 요소를 갖는 배열입니다.
 * second = {"hunting", "fishing", "fishing", "biting"} // first와 같은 크기의 배열입니다.
 * return = 4
 * 각 요소는 1~15개의 문자이며, 각 문자는 영어 소문자입니다. i번째 요소 first[i]와 second[i]의 내용은 다릅니다.
 */
public class Day06 {

    /**
     * 문제 풀이 시작 : 2022-03-06 00:00
     * 문제 풀이 실제 완료 시간 : 2022-03-06 00:32
     * 문제 풀이 목표 완료 시간 : 2022-03-06 01:00
     */
    private static String[] first = {"fishing", "gardening", "swimming", "fishing"};
    private static String[] second = {"hunting", "fishing", "fishing", "biting"};
    private static int result = 4;

    /*private static String[] first = {"variety", "diversity", "loquacity", "courtesy"};
    private static String[] second = {"talking", "speaking", "discussion", "meeting"};
    private static int result = 1;*/
        
    /*private static String[] first = {"t","o","p","c","o","d","e","r","s","i","n","g","l","e","r","o","u","n","d","m","a","t","c","h","f","o","u","r","n","i"};
    private static String[] second = {"n","e","f","o","u","r","j","a","n","u","a","r","y","t","w","e","n","t","y","t","w","o","s","a","t","u","r","d","a","y"};
    private static int result = 6;*/

    public static void main(String[] args){

        Map<String, Integer> interest = new HashMap<>();
        for (int i=0; i<first.length; i++) {
            interest.merge(first[i], 1, (integer, integer1) -> integer + integer1);
            interest.merge(second[i], 1, (integer, integer1) -> integer+integer1);
        }

        int maxCount = Collections.max(interest.values());

        // 문제 풀이에서 나온 답
        int testResult = maxCount;
        // 실제 정답
        int realResult = result;

        System.out.println("- 문제 풀이를 통한 정답 : " +maxCount);
        System.out.println("- 실제 정답안 : " +realResult);
        System.out.println( realResult == testResult );
    }
}
