package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.07
 * @notes - 에센셜4<br>
 * - 벨만포드 - 음수간선 유무 확인하는 문제<br>
 */

public class g3_1865_웜홀 {
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 개수

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점수
            int M = Integer.parseInt(st.nextToken()); // 도로수
            int W = Integer.parseInt(st.nextToken()); // 웜홀수

            List<Edge> edges = new ArrayList<>(); // 엣지 리스트
            boolean[] visited = new boolean[N+1]; // 지점 방문 저장 배열

            // 도로 입력
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()); // 출발점
                int end = Integer.parseInt(st.nextToken()); // 도착점
                int time = Integer.parseInt(st.nextToken()); // 시간
                edges.add(new Edge(start, end, time));
                edges.add(new Edge(end, start, time));
            }

            // 웜홀 입력
            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()); // 출발점
                int end = Integer.parseInt(st.nextToken()); // 도착점
                int time = Integer.parseInt(st.nextToken()); // 시간
                edges.add(new Edge(start, end, -time));
            }


            // 최단 시간 저장 배열 초기화 (출발지점 제외)
            int[] times = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                times[i] = INF;
            }

            // 모든 노드 방문할 수 있도록 반복
            for(int node = 1; node <= N; node++){
                if(visited[node])
                    continue;

                times[node] = 0;

                // N-1번 반복
                for (int cnt = 0; cnt < N - 1; cnt++) {
                    for (Edge edge : edges) {
                        if (times[edge.start] != INF && times[edge.end] > times[edge.start] + edge.time) {
                            times[edge.end] = times[edge.start] + edge.time;
                            visited[edge.end] = true;
                        }
                    }
                }

                visited[node] = true;
            }

            // 음수 사이클 확인
            boolean existCycle = false;
            for (Edge edge : edges) {
                if (times[edge.start] != INF && times[edge.end] > times[edge.start] + edge.time) {
                    existCycle = true;
                    break;
                }
            }

            // 결과 저장
            if (existCycle)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");

        }
        System.out.println(sb);
    }

    private static class Edge {
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

}

