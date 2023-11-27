package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.27.
 * @notes
 * - ^.^v
 */

public class s2_1260_DFS와BFS {
    public static int N; // 정점 개수
    public static int M; // 간선 개수
    public static int V; // 시작 정점 번호
    public static ArrayList<ArrayList<Integer>> lines = new ArrayList<>(); // 간선 정보

    public static boolean[] visited;
    public static StringBuilder answer = new StringBuilder();
    ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());


        for (int n = 0; n < N + 1; n++) {
            lines.add(new ArrayList<>());
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            lines.get(node1).add(node2);
            lines.get(node2).add(node1);
        }


        for (ArrayList<Integer> lineList : lines) {
            Collections.sort(lineList);
        }

        visited = new boolean[N + 1];
        DFS(V);

        visited = new boolean[N + 1];
        answer.append("\n");
        BFS(V);

        System.out.println(answer);
    }

    public static void DFS(int node) {
        visited[node] = true;
        answer.append(node).append(" ");

        for (int nextNode : lines.get(node)) {
            if (!visited[nextNode])
                DFS(nextNode);
        }
    }

    public static void BFS(int startNode) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(startNode);

        while (!Q.isEmpty()) {
            int node = Q.poll();
            if (!visited[node]) {
                visited[node] = true;
                answer.append(node).append(" ");
                Q.addAll(lines.get(node));
            }
        }
    }
}

