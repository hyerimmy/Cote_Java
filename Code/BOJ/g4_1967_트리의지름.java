package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.19
 * @notes - 에센셜 4<br>
 * - 모든 노드 : 모든 노드 경로 길이를 구해야 하니 플로이드워셜? -> 메모리 초과<br>
 * - 모두 경로가 한 개씩밖에 없기 때문에 굳이 최단경로 알고리즘을 쓸 필요가 없음. DFS로 변경 <br>
 */

public class g4_1967_트리의지름 {
    public static int N;
    public static List<List<Edge>> graph = new ArrayList<>();
    public static int maxDistance = 0;

    // DFS 탐색용
    public static boolean[] visited;
    public static int targetNode;
    public static int distanceSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드 개수 입력받기
        N = Integer.parseInt(st.nextToken());

        // 최단거리 배열 크기 지정 및 초기화
        for (int node = 0; node <= N; node++) {
            graph.add(new ArrayList<>());
        }

        // 엣지 입력받기
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(node1).add(new Edge(node2, distance));
            graph.get(node2).add(new Edge(node1, distance));
        }

        // DFS 진행하며 길이 저장
        calculateDistance();

        // 결과 출력
        System.out.println(maxDistance);

    }

    private static void calculateDistance() {
        for (targetNode = 1; targetNode <= N - 1; targetNode++) {
            visited = new boolean[N + 1];
            DFS(targetNode + 1);
        }
    }

    private static void DFS(int node) {
        // 거리 값 갱신
        maxDistance = Math.max(maxDistance, distanceSum);

        // 연결 노드 반복 돌기
        for (Edge edge : graph.get(node)) {
            // 이미 계산한 부분은 뛰어넘기
            if (visited[edge.endNode])
                continue;

            visited[node] = true;
            distanceSum += edge.distance;
            DFS(edge.endNode);
            visited[node] = false;
            distanceSum -= edge.distance;
        }

        // 방문 처리
        visited[node] = true;
    }

    private static class Edge {
        public int endNode;
        public int distance;

        public Edge(int endNode, int distance) {
            this.endNode = endNode;
            this.distance = distance;
        }
    }
}
