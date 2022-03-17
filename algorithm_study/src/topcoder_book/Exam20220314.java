package topcoder_book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem.
 *
 * 고장난 로봇이 평면 위에 있습니다. 그리고 n번 움직입니다.
 * 로봇은 각 단계에서 한 방향(동,서,남,북)중에 한 방향을 랜덤하게 선택해서 한 칸 움직입니다.
 * 로봇이 동,서,남,북을 선택할 확률은 north, south, east, west % 입니다.
 *
 * 로봇이 임의로 이동하며 같은 지점을 통과하지 않으면 성공했다고 합니다.
 * 로봇이 성공적으로 보행할 확률을 double 자료형으로 리턴해주세요.
 *
 * 예를 들어 "EENE" 또는 "ENW"는 성공이지만, "ENWS" 또는 "WWWWSNE"는 성공이 아닙니다.
 * (E = 동 / W = 서 / S = 남 / N = 북)
 *
 * (입출력 데이터 예시)
 * n = 1 // 1~14의 범위 값
 * east = 25 // 0~100 범위 값
 * west = 25 // 0~100 범위 값
 * south = 25 // 0~100 범위 값
 * north = 25 // 0~100 범위 값
 * east + west + south + north 의 합은 100을 넘을 수 없습니다.
 * returns = 1.0 // 정답
 *
 * TODO: 확률 계산 어떻게 해야하지 ?? 깊이우선탐색은 했는데, 확률 계산을 ...
 */
public class Exam20220314 {
    static int x = 100, y = 100;
    static int count = 0;
    static int successCount = 0;
    static int[][] map = null;

    public static void move(int n, int nCount, int east, int west, int south, int north) {
        if (n==nCount) {
            count++;
            successCount++;
            return;
        }

        if (east > 0) {
            if (map[x+1][y] == 1) {
                count++;
            } else {
                map[++x][y] = 1;
                move(n, nCount + 1, east, west, south, north);
                map[x--][y] = 0;
            }
        }

        if (west > 0) {
            if (map[x-1][y] == 1) {
                count++;
            } else {
                map[--x][y] = 1;
                move(n, nCount + 1, east, west, south, north);
                map[x++][y] = 0;
            }
        }

        if (south > 0) {
            if (map[x][y-1] == 1) {
                count++;
            } else {
                map[x][--y] = 1;
                move(n, nCount + 1, east, west, south, north);
                map[x][y++] = 0;
            }
        }

        if (north > 0) {
            if (map[x][y+1] == 1) {
                count++;
            } else {
                map[x][++y] = 1;
                move(n, nCount + 1, east, west, south, north);
                map[x][y--] = 0;
            }
        }
    }

    /**
     * 문제 풀이 시작 : 2022-03-17 21:30
     * 문제 풀이 실제 완료 시간 : 2022-03-17 22:30
     * 문제 풀이 목표 완료 시간 : 2022-03-17 22:20
     * @return
     */
    public static double solution(int n, int east, int west, int south, int north) {
        map = new int[x*2][y*2];
        map[x][y] = 1; // 최초 시작점

        // 움직임 시작
        move(n, 0, east, west, south, north);
        return (double)successCount/(double)count;
    }

    public static void main(String[] args){
        /*int n = 1;
        int east = 25;
        int west = 25;
        int south = 25;
        int north = 25;
        double result = 1.0;*/

        /*int n = 2;
        int east = 25;
        int west = 25;
        int south = 25;
        int north = 25;
        double result = 0.75;*/

        /*int n = 7;
        int east = 50;
        int west = 0;
        int south = 0;
        int north = 50;
        double result = 1.0;*/

        int n = 99;
        int east = 50;
        int west = 0;
        int south = 0;
        int north = 50;
        double result = 0;

        double answer = solution(n, east, west, south, north);

        // 문제 풀이에서 나온 답
        String testResult = String.valueOf(answer);
        // 실제 정답
        String realResult = String.valueOf(result);

        System.out.println("- 문제 풀이를 통한 정답 : " +testResult);
        System.out.println("- 실제 정답안 : " +realResult);
        System.out.println( realResult.equals(testResult) );
    }
}
