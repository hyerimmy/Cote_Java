package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.06
 * @notes - 플로이드워셜 예제<br>
 */

public class g4_11404_플로이드__플로이드워셜 {
    public static int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 노드 수 (도시)
        int M = Integer.parseInt(br.readLine()); // 간선 수 (버스)

        // 인접행렬 정의 및 초기화
        int[][] graph = new int[N + 1][N + 1];
        for (int start = 1; start <= N; start++) { // 시작노드
            for (int end = 1; end <= N; end++) { // 출발노드
                if (start != end)
                    graph[start][end] = INF;
            }
        }

        // 간선 업데이트
        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start][end] = Math.min(graph[start][end], weight);
        }

        // 플로이드 워셜 알고리즘 실행
        for (int k = 1; k <= N; k++) { // 중간노드
            for (int start = 1; start <= N; start++) { // 시작노드
                for (int end = 1; end <= N; end++) { // 출발노드
                    if(start == end)
                        continue;
                    graph[start][end] = Math.min(graph[start][end], graph[start][k] + graph[k][end]);
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int start = 1; start <= N; start++) { // 시작노드
            for (int end = 1; end <= N; end++) { // 출발노드
                if(graph[start][end] == INF)
                    sb.append(0).append(" ");
                else
                    sb.append(graph[start][end]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
