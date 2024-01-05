package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.01.05
 * @notes - 삼성 SW 역량 테스트 기출 문제 <br>
 */

public class g4_16234_인구이동 {
    public static int N, L, R; // 땅 크기 N, 인구차이 L~R
    public static int[][] A; // 나라 별 사람 수
    public static boolean[][] visited; // 국경선 열기 위한 나라 별 계산 유무

    public static int sum;
    public static List<int[]> countryList;
    public static int[] dR = new int[]{0, 0, 1, -1};
    public static int[] dC = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 인구 수 입력받기
        A = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        boolean move = true; // 이동 발생 유무
        int days = 0; // 이동 발생 일수

        while (move) {
            move = false;
            visited = new boolean[N][N];

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        // 인구 이동 진행
                        BFS(r, c);

                        // 인구 이동 후 인구 수 계산해 업데이트
                        if (countryList.size() > 1) {
                            int newNumber = sum / countryList.size();
                            for (int[] country : countryList) {
                                A[country[0]][country[1]] = newNumber;
                            }
                            move = true;
                        }
                    }
                }
            }

            if (move)
                days++;
        }

        System.out.println(days);
    }

    private static void BFS(int r, int c) {
        // 초기화
        sum = A[r][c];
        countryList = new ArrayList<>();
        countryList.add(new int[]{r, c});

        // 시작점 방문처리
        visited[r][c] = true;

        // 큐 정의
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{r, c});

        while (!Q.isEmpty()) {
            int[] country = Q.poll();

            for (int t = 0; t < 4; t++) {
                int[] newCountry = new int[]{country[0] + dR[t], country[1] + dC[t]};

                // 새로운 좌표가 땅을 벗어난다면 건너뜀
                if (newCountry[0] < 0 || newCountry[0] >= N || newCountry[1] < 0 || newCountry[1] >= N)
                    continue;

                // 이미 방문한 나라라면 건너뜀
                if (visited[newCountry[0]][newCountry[1]])
                    continue;

                // 나라 간의 인구 수 차이 계산
                int numberDifference = Math.abs(A[newCountry[0]][newCountry[1]] - A[country[0]][country[1]]);

                // 조건에 맞다면 인구 이동 대상 처리
                if (numberDifference >= L && numberDifference <= R) {
                    sum += A[newCountry[0]][newCountry[1]];
                    countryList.add(newCountry);
                    Q.add(newCountry);
                    visited[newCountry[0]][newCountry[1]] = true;
                }
            }
        }

    }
}