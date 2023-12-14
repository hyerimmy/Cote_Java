package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.14.
 * @notes - 트리 예제<br>
 */
public class s2_11725_트리의부모찾기__트리 {
    public static int N;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited;
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        parents = new int[N + 1];

        for (int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }

        for (int k = 0; k < N - 1; k++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        BFS();

        StringBuilder sb = new StringBuilder();
        for (int node = 2; node <= N; node++) {
            sb.append(parents[node]).append("\n");
        }
        System.out.println(sb);
    }

    public static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);

        while (!Q.isEmpty()) {
            int node = Q.poll();

            if(visited[node])
                continue;

            for(int nextNode : graph.get(node)){
                if(!visited[nextNode]){
                    parents[nextNode] = node;
                    Q.add(nextNode);
                }
            }

            visited[node] = true;
        }
    }
}
