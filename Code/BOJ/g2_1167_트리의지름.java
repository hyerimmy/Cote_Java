package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.20
 * @notes - 에센셜 4<br>
 * - DFS로 풀기 - 시간초과 <br>
 * - 트리의 지름 구하기 문제는 DFS 두 번 돌려서 구하는 것!! 외우자!! <br>
 * - 평면에 (트리를 이루는) 많은 점이 있다고 가정합시다. 이때 임의의 점에서 dfs를 돌린다면 지름을 그릴 수 있는 점 중 '하나'를 찾을 수 있습니다. 여기에서 또 한번 dfs를 돌린다면 지름의 나머지 한 점을 찾을 수 있고, 이것이 트리의 "지름"이 되는 것입니다. <br>
 * -
 */

public class g2_1167_트리의지름 {
    public static int N;
    public static List<List<Edge>> graph = new ArrayList<>();
    public static int maxDistance = 0;
    public static int maxNode = 0;

    // DFS 탐색용
    public static boolean[] visited;
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
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            while (node2 != -1) {
                int distance = Integer.parseInt(st.nextToken());
                graph.get(node1).add(new Edge(node2, distance));
                graph.get(node2).add(new Edge(node1, distance));
                node2 = Integer.parseInt(st.nextToken());
            }
        }

        // DFS (1) - 1번 노드와 가장 멀리 떨어진 노드(=지름의 첫 번째 노드) 찾기
        distanceSum = 0;
        visited = new boolean[N + 1];
        DFS(1);
//        System.out.println(maxNode);

        // DFS (2) - maxNode와 가장 멀리 떨어진 노드(=지름의 두 번째 노드) 길이 찾기
        distanceSum = 0;
        visited = new boolean[N + 1];
        DFS(maxNode);

        // 결과 출력
        System.out.println(maxDistance);

    }

    private static void DFS(int node) {

        // 연결 노드 반복 돌기
        for (Edge edge : graph.get(node)) {
            // 이미 계산한 부분은 뛰어넘기
            if (visited[edge.endNode])
                continue;

            visited[node] = true;
            distanceSum += edge.distance;

            // 거리 값 갱신
            if(maxDistance < distanceSum){
                maxDistance = distanceSum;
                maxNode = edge.endNode;
            }

            DFS(edge.endNode);
            distanceSum -= edge.distance;
        }
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
