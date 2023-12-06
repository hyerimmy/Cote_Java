package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.06
 * @notes - 다익스트라 예제<br>
 */

public class g4_1753_최단경로__다익스트라 {
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점 수
        int E = Integer.parseInt(st.nextToken()); // 간선 수

        int start = Integer.parseInt(br.readLine()); // 시작노드

        // 그래프 인접리스트 정의
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 연결
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int startV = Integer.parseInt(st.nextToken()); // 시작노드
            int endV = Integer.parseInt(st.nextToken()); // 끝노드
            int W = Integer.parseInt(st.nextToken()); // 가중치
            graph.get(startV).add(new int[]{endV, W});
        }

        // 최단경로 배열 초기화
        int[] distance = new int[V + 1]; // 거리 저장 리스트
        for (int i = 1; i <= V; i++) {
            if (i != start)
                distance[i] = INF;
        }

        // 다익스트라 알고리즘 진행
        boolean[] visited = new boolean[V + 1]; // 방문 배열
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, distance[start]));
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (visited[node.idx])
                continue;

            for (int[] next : graph.get(node.idx)) {
                int nextNode = next[0];
                int weight = next[1];
                distance[nextNode] = Math.min(distance[nextNode], distance[node.idx] + weight);
                queue.add(new Node(nextNode, distance[nextNode]));
            }
            visited[node.idx] = true;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF)
                sb.append("INF").append("\n");
            else
                sb.append(distance[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static class Node implements Comparable<Node> {
        public int idx;
        public int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}

