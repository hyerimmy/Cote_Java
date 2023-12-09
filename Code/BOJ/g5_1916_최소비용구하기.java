package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.04. (DP) / 2023.12.09. (다익스트라)
 * @notes - 에센셜4 <br>
 */

public class g5_1916_최소비용구하기 {
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        // 버스 저장할 리스트 초기화
        List<List<Bus>> busList = new ArrayList<>();
        for (int n = 0; n <= N; n++) {
            busList.add(new ArrayList<>());
        }

        // 버스 입력받기
        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            busList.get(start).add(new Bus(end, pay));
        }

        // 출발지, 도착지 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityA = Integer.parseInt(st.nextToken());
        int cityB = Integer.parseInt(st.nextToken());

        // 최소 비용 배열 정의
        int[] pays = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i != cityA) {
                pays[i] = INF;
            }
        }

        // 다익스트라 탐색
        boolean[] visited = new boolean[N + 1]; // 방문 배열
        PriorityQueue<City> PQ = new PriorityQueue<>();
        PQ.add(new City(cityA, 0));
        while (!PQ.isEmpty()) {
            City city = PQ.poll();

            if (visited[city.idx])
                continue;

            for (Bus bus : busList.get(city.idx)) {
                pays[bus.end] = Math.min(pays[bus.end], city.pay + bus.pay);
                PQ.add(new City(bus.end, pays[bus.end]));
            }

            visited[city.idx] = true;
        }


        // 결과 출력
        System.out.println(pays[cityB]);

    }

    public static class Bus {
        public int end;
        public int pay;

        Bus(int end, int pay) {
            this.end = end;
            this.pay = pay;
        }
    }

    public static class City implements Comparable<City> {
        public int idx;
        public int pay;

        public City(int idx, int pay) {
            this.idx = idx;
            this.pay = pay;
        }

        @Override
        public int compareTo(City o) {
            return this.pay - o.pay;
        }
    }
}