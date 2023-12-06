package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.06
 * @notes - 최소 신장 트리 (MST) 예제<br>
 */
public class g4_1197_최소스패닝트리__MST {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken()); // 정점 개수
        int E = Integer.parseInt(st.nextToken()); // 간선 개수

        List<Edge> edgeList = new ArrayList<>(); // 엣지 리스트
        parent = new int[V + 1]; // 대표값 저장 배열

        // 대표값 저장 배열 초기화
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        // 엣지 리스트 초기화
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발 정점
            int end = Integer.parseInt(st.nextToken()); // 도착 정점
            int weight = Integer.parseInt(st.nextToken()); // 가중치
            edgeList.add(new Edge(start, end, weight));
        }

        // 엣지 리스트 가중치 기준으로 오름차순 정렬
        Collections.sort(edgeList);

        // 가중치 적은 순으로 에지 연결 시도
        int weightSum = 0; // 가중치 합
        int edgeCount = 0; // 연결한 엣지 개수
        for (Edge edge : edgeList) {
            if(union(edge.start, edge.end)){
                weightSum += edge.weight;
                edgeCount++;
            }
            if(edgeCount == V-1)
                break;
        }

        System.out.println(weightSum);

    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        // 대표 노드가 같다면 (사이클 생성됨) 연결하지 않는다
        if (a == b)
            return false;

        // 대표 노드가 같지 않다면 연결한다
        parent[b] = a;
        return true;
    }

    private static int find(int a) {
        if(parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }

    private static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}
