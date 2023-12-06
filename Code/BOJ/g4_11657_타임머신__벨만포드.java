package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.06
 * @notes - 벨만포드 예제<br>
 * - int 타입로 했다가 틀려서 long으로 변경했더니 통과 했습니다. 그런데 모든 노선의 가중치가 10,000이라 하더라도 최대 가중치는 500 * 10,000 이라 int타입으로 해도 넘을 것 같지가 않은데 왜 이슈가 존재하는지 궁금합니다. <br>
 * - 오버플로우가 날 일은 없지만 언더플로우는 날 수 있습니다. 음수 사이클이 있으면 최단거리가 단순히 간선 가중치를 합한 것보다도 작아질 수 있기 때문입니다. <br>
 */

public class g4_11657_타임머신__벨만포드 {
    public static long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수

        // 엣지리스트 정의
        List<Edge> edgeList = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 시작 노드
            int end = Integer.parseInt(st.nextToken()); // 끝 노드
            int weight = Integer.parseInt(st.nextToken()); // 가중치
            edgeList.add(new Edge(start, end, weight));
        }

        // 최단 경로 저장 배열 정의
        long[] distance = new long[N + 1];
        for (int i = 2; i <= N; i++) {
            distance[i] = INF; // 출발점 외의 노드 최단거리 무한대로 초기화
        }

        // 벨만포드 (노드수-1)번 반복
        for (int count = 0; count < N - 1; count++) {
            for (Edge E : edgeList) {
                if (distance[E.start] != INF && distance[E.end] > distance[E.start] + E.weight)
                    distance[E.end] = distance[E.start] + E.weight;
            }
        }

        // 음수 사이클 있는지 확인
        boolean exist = true;
        for (Edge E : edgeList) {
            if (distance[E.start] != INF && distance[E.end] > distance[E.start] + E.weight) {
                exist = false;
                break;
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        if (exist) {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == INF)
                    sb.append(-1).append("\n");
                else
                    sb.append(distance[i]).append("\n");
            }
        } else sb.append(-1);
        System.out.println(sb);
    }

    public static class Edge {
        public int start;
        public int end;
        public int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}

