package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.07
 * @notes - 에센셜4<br>
 * - 다익스트라 알고리즘<br>
 */

public class g3_1238_파티 {
    public static int INF = Integer.MAX_VALUE;
    public static List<List<Edge>> edgeList = new ArrayList<>();
    public static List<List<Edge>> edgeListReverse = new ArrayList<>();
    public static int N;
    public static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 마을수
        int M = Integer.parseInt(st.nextToken()); // 도로수
        X = Integer.parseInt(st.nextToken()); // 출발 마을

        // 인접 리스트 정의
        for (int n = 0; n <= N; n++) {
            edgeList.add(new ArrayList<>());
            edgeListReverse.add(new ArrayList<>());
        }

        // 인접 리스트 값 저장
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edgeList.get(start).add(new Edge(end, time));
            edgeListReverse.get(end).add(new Edge(start, time));
        }

        // 가는 시간 계산 (N -> X)
        int[] goTimes = getTimes(true);
//        System.out.println(Arrays.toString(goTimes));

        // 돌아오는 시간 계산 (X -> N)
        int[] comebackTimes = getTimes(false);
//        System.out.println(Arrays.toString(comebackTimes));

        // 결과 집계
        int maxTime = 0;
        for (int node = 1; node <= N; node++) {
            maxTime = Math.max(maxTime, goTimes[node] + comebackTimes[node]);
        }

        // 결과 출력
        System.out.println(maxTime);
    }

    public static int[] getTimes(boolean reverse) {
        // 최단 거리 저장 배열
        int[] times = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            if (n != X)
                times[n] = INF;
        }

        // 방문 배열 정의
        boolean[] visited = new boolean[N + 1];

        // 우선순위 큐 정의
        PriorityQueue<Node> nodeQ = new PriorityQueue<>();
        nodeQ.add(new Node(X, 0));

        // 다익스트라 진행
        while (!nodeQ.isEmpty()) {
            Node node = nodeQ.poll();

            if (visited[node.idx])
                continue;

            if (!reverse) {
                for (Edge edge : edgeList.get(node.idx)) {
                    if (times[edge.node] > times[node.idx] + edge.time) {
                        times[edge.node] = times[node.idx] + edge.time;
                        nodeQ.add(new Node(edge.node, times[edge.node]));
                    }
                }
            } else {
                for (Edge edge : edgeListReverse.get(node.idx)) {
                    if (times[edge.node] > times[node.idx] + edge.time) {
                        times[edge.node] = times[node.idx] + edge.time;
                        nodeQ.add(new Node(edge.node, times[edge.node]));
                    }
                }

            }

            visited[node.idx] = true;
        }

        return times;
    }

    private static class Edge {
        int node;
        int time;

        public Edge(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    private static class Node implements Comparable<Node> {
        int idx;
        int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
}

