package BOJ;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.10.
 * @notes - 다익스트라 <br>
 * - 처음에 DP로 생각했으나, '이전의 값들로 모든 경우를 도출 가능하다'의 조건에 위배됨 (X-1 의 경우 때문)<br>
 * - X-1, X+1, 2X를 각 위치에서의 간선이라 생각하면 그래프로 풀 수 있음.<br>
 * - 일직선 좌표 문제라도 그래프로 풀 수 있음을 명심!!<br>
 */

public class g5_13549_숨바꼭질3 {
    public static int INF = Integer.MAX_VALUE;
    public static int MAX_POINT = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 그래프 정의
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= MAX_POINT; i++) {
            graph.add(new ArrayList<>());
            if (i - 1 >= 0)
                graph.get(i).add(new int[]{i - 1, 1});
            if (i + 1 <= MAX_POINT)
                graph.get(i).add(new int[]{i + 1, 1});
            if (2 * i <= MAX_POINT)
                graph.get(i).add(new int[]{2 * i, 0});
        }

        // 최단 시간 배열 정의 및 초기화
        int[] times = new int[MAX_POINT + 1];
        for (int i = 0; i <= MAX_POINT; i++) {
            if (i != N)
                times[i] = INF;
        }

        boolean[] visited = new boolean[MAX_POINT + 1]; // 방문 배열
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(N, times[N]));

        while (!PQ.isEmpty()) {
            Point point = PQ.poll();

            if (visited[point.position])
                continue;

            for (int[] nextPoint : graph.get(point.position)) {
//                System.out.println(graph.get(point.position));
                times[nextPoint[0]] = Math.min(times[nextPoint[0]], times[point.position] + nextPoint[1]);
                PQ.add(new Point(nextPoint[0], times[nextPoint[0]]));
            }

            visited[point.position] = true;
        }

        System.out.println(times[K]);
    }

    private static class Point implements Comparable<Point> {
        int position;
        int time;

        public Point(int position, int time) {
            this.position = position;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }
}