package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.01.04.
 * @notes - 삼성 SW 역량테스트 문제집 <br>
 */

public class g4_14499_주사위굴리기 {
    public static int N, M, x, y;
    public static int[][] map;
    public static int[] diceIndex = new int[]{6, 3, 4, 2, 5, 1}; // 아래, 동, 서, 북, 남, 위
    public static int[] diceValue = new int[7]; // 주사위에 적힌 숫자, 처음엔 모두 0

    public static int[] dx = new int[]{0, 0, 0, -1, 1};
    public static int[] dy = new int[]{0, 1, -1, 0, 0};
    public static StringBuilder answers = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 지도 숫자 입력받기
        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 명령 입력받고 실행하기
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < K; k++) {
            move(Integer.parseInt(st.nextToken()));
        }

        // 결과 출력하기
        System.out.println(answers);
    }

    private static void move(int d) {
        // 새로운 주사위 좌표 계산
        int newX = x + dx[d];
        int newY = y + dy[d];
//        System.out.println(d + " " + newX + ", " + newY);

        // 주사위 좌표가 범위를 벗어난다면 명령 무시
        if (newX < 0 || newX >= N || newY < 0 || newY >= M)
            return;

        // 주사위 좌표 업데이트
        x = newX;
        y = newY;

        // 주사위 인덱스 업데이트하기
        int tempIndex = diceIndex[0];
        diceIndex[0] = diceIndex[d];
        diceIndex[5] = 7 - diceIndex[d];
        int sum = 3;
        if (d == 3 || d == 4)
            sum = 7;
        diceIndex[sum - d] = tempIndex;
        diceIndex[d] = 7 - diceIndex[sum - d];

//        System.out.println(Arrays.toString(diceIndex));

        // 주사위 숫자, 칸 숫자 업데이트하기
        if (map[x][y] == 0) {
            map[x][y] = diceValue[diceIndex[0]];
        } else {
            diceValue[diceIndex[0]] = map[x][y];
            map[x][y] = 0;
        }

        // 주사위 윗면 숫자 출력 저장하기
        answers.append(diceValue[diceIndex[5]]).append("\n");
    }
}