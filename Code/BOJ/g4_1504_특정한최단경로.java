package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.09
 * @notes - 다익스트라<br>
 * - 에센셜 4<br>
 */
public class g4_1504_특정한최단경로 {
    public static int INF = Integer.MAX_VALUE;
    public static int N;
    public static List<List<int[]>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수

        // 엣지리스트 초기화
        for (int n = 0; n <= N; n++) {
            edges.add(new ArrayList<>());
        }

        // 엣지리스트 값 입력
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발 정점
            int b = Integer.parseInt(st.nextToken()); // 도착 정점
            int c = Integer.parseInt(st.nextToken()); // 거리
            edges.get(a).add(new int[]{b, c});
            edges.get(b).add(new int[]{a, c});
        }

        // v1, v2 입력
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘 진행
        int[] distancesFrom1 = getDistances(1);
        int[] distancesFromv1 = getDistances(v1);
        int[] distancesFromv2 = getDistances(v2);

        int result = -1;

        // 결과 계산 - (1) 1-v1-v2-N
        if (distancesFrom1[v1] != INF && distancesFromv1[v2] != INF && distancesFromv2[N] != INF)
            result = distancesFrom1[v1] + distancesFromv1[v2] + distancesFromv2[N];

        // 결과 계산 - (2) 1-v2-v1-N
        if (result != -1 && distancesFrom1[v2] != INF && distancesFromv2[v1] != INF && distancesFromv1[N] != INF)
            result = Math.min(result, distancesFrom1[v2] + distancesFromv2[v1] + distancesFromv1[N]);


        System.out.println(result);
    }

    public static int[] getDistances(int startNode) {
        // 최단거리 배열 정의 및 초기화
        int[] distances = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i != startNode)
                distances[i] = INF;
        }

        // 다익스트라 알고리즘 진행
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(startNode, distances[startNode]));
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            if (visited[node.idx])
                continue;

            for (int[] nextNode : edges.get(node.idx)) {
                distances[nextNode[0]] = Math.min(distances[nextNode[0]], distances[node.idx] + nextNode[1]);
                PQ.add(new Node(nextNode[0], distances[nextNode[0]]));
            }

            visited[node.idx] = true;
        }

        return distances;
    }

    private static class Node implements Comparable<Node> {
        public int idx;
        public int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
