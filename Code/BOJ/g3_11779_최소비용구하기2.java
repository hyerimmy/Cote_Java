package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Pattern;


/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.10
 * @notes - 다익스트라 예제<br>
 */
public class g3_11779_최소비용구하기2 {
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        // 인접 리스트 정의
        List<List<int[]>> graph = new ArrayList<>();
        for (int node = 0; node <= N; node++) {
            graph.add(new ArrayList<>());
        }

        // 인접 리스트 값 입력
        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[]{end, cost});
        }

        // 출발, 도착 도시 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘을 위한 변수 정의
        boolean[] visited = new boolean[N + 1]; // 방문 배열
        int[] costs = new int[N + 1]; // 최소 비용 저장 배열
        for (int node = 1; node <= N; node++) {
            if (node != startCity)
                costs[node] = INF;
        }
        List<List<Integer>> route = new ArrayList<>(); // 최소 비용 경로
        for (int node = 0; node <= N; node++) {
            route.add(new ArrayList<>());
        }
        PriorityQueue<City> PQ = new PriorityQueue<>();
        PQ.add(new City(startCity, costs[startCity]));

        // 다익스트라 진행
        while (!PQ.isEmpty()) {
            City city = PQ.poll();

            if (visited[city.idx])
                continue;

            for (int[] nextCity : graph.get(city.idx)) {
                if (costs[nextCity[0]] > costs[city.idx] + nextCity[1]) {
                    costs[nextCity[0]] = costs[city.idx] + nextCity[1];
                    route.get(nextCity[0]).clear();
                    route.get(nextCity[0]).addAll(route.get(city.idx));
                    route.get(nextCity[0]).add(city.idx);
                    PQ.add(new City(nextCity[0], costs[nextCity[0]]));
                }
            }

            visited[city.idx] = true;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(costs[endCity]).append("\n");
        sb.append(route.get(endCity).size() + 1).append("\n");
        for (int city : route.get(endCity))
            sb.append(city).append(" ");
        sb.append(endCity).append("\n");
        System.out.println(sb);
    }

    private static class City implements Comparable<City> {
        int idx;
        int cost;

        public City(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return this.cost - o.cost;
        }
    }
}
