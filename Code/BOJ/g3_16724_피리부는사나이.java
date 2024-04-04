package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @title 피리 부는 사나이
 * @link https://www.acmicpc.net/problem/2596
 * @date 2024.04.04
 * @notes - <br>
 */

public class g3_16724_피리부는사나이 {
    public static int N, M; // 가로, 세로
    public static char[][] map; // 지도 정보

    // 방향 정보
    public static HashMap<Character, int[]> directionMap = new HashMap<>() {{
        put('U', new int[]{-1, 0});
        put('D', new int[]{1, 0});
        put('L', new int[]{0, -1});
        put('R', new int[]{0, 1});
    }};


    public static int[][] types; // 방문 처리 배열
    public static int safezoneCount = 0; // 결과값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        N = 1000;
//        M = 1000;

        map = new char[N][M];
        types = new int[N][M];

        // 지도 정보 입력받기
        for (int n = 0; n < N; n++) {
            String inputs = br.readLine();
//            String inputs = "RRRRRRRRRL".repeat(100);
            for (int m = 0; m < M; m++) {
                map[n][m] = inputs.charAt(m);
            }
        }

        // 지도 완전탐색
        int type = 1;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                // 만약 이미 safe zone이 설치된 루트라면
                if (types[n][m] == 0 && needSafezone(n, m, type)) {
                    safezoneCount++;
//                    System.out.printf("(%d, %d)%n", n, m);
                }
                type++;
            }
        }

        // 결과 출력
        System.out.println(safezoneCount);
    }

    public static boolean needSafezone(int n, int m, int type) {
        char direction = map[n][m];
        int newN = n + directionMap.get(direction)[0];
        int newM = m + directionMap.get(direction)[1];

        types[n][m] = type;

//        System.out.println(n + ", " + m);
//        System.out.println("type" + type);
//        System.out.println("types[newN][newM]" + types[newN][newM]);

        // 아직 방문하지 않은 곳이라면
        if (types[newN][newM] == 0) {
            return needSafezone(newN, newM, type);
        }

        // 만약 이미 safe zone이 설치된 루트라면
        if (types[newN][newM] != type) {
            return false;
        }

        return true;
    }
}

/*
3 3
DDD
DRU
RRU
 */

/*
10 10
DRDRRRRRRD
RDRUDUUUUL
URLDLRRRRD
RRRRLRDLUD
DDRLLDULUU
DRULLLRDUU
DULLDDDURU
URLDDDDUUL
DLRLRDUULL
RRULRUUURU
 */


/*
3 5
DRLLD
RULLL
ULLRL
 */