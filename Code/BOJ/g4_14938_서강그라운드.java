package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.05
 * @notes - 에센셜4 <br>
 * - 플로이드워셜, 모든 최단경로를 탐색한 후, 조건에 맞는 것만 합해서 최대값 구하도록 코드 짜야지~<br>
 * - 히.히. 한 번에 정답~^.^v <br>
 */

public class g4_14938_서강그라운드 {
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 지역 수
        int M = Integer.parseInt(st.nextToken()); // 수색 범위
        int R = Integer.parseInt(st.nextToken()); // 길 수

        // 아이템 수 저장 배열 정의
        int[] items = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        // 그래프 정의
        int[][] distances = new int[N + 1][N + 1];
        for (int start = 1; start <= N; start++) {
            for (int end = 1; end <= N; end++) {
                if (start != end)
                    distances[start][end] = INF;
            }
        }

        // 길 정보 저장
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 지역번호1
            int b = Integer.parseInt(st.nextToken()); // 지역번호2
            int l = Integer.parseInt(st.nextToken()); // 길의 길이
            distances[a][b] = l;
            distances[b][a] = l;
        }

        // 플로이드워셜 진행
        for (int k = 1; k <= N; k++) {
            for (int start = 1; start <= N; start++) {
                for (int end = 1; end <= N; end++) {
                    if (distances[start][k] != INF && distances[k][end] != INF)
                        distances[start][end] = Math.min(distances[start][end], distances[start][k] + distances[k][end]);
                }
            }
        }

        // 각 지역 별 최대 아이템 개수 계산
        int answer = 0;
        for (int start = 1; start <= N; start++) {
            int itemSum = 0;
            for (int region = 1; region <= N; region++) {
                if (distances[start][region] <= M)
                    itemSum += items[region];
            }
            answer = Math.max(answer, itemSum);
        }

        // 정답 출력
        System.out.println(answer);
    }
}