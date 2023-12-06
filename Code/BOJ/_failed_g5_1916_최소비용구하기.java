package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.04.
 * @notes - 에센셜4 <br>
 */

public class _failed_g5_1916_최소비용구하기 {
    public static long[] dp;
    public static boolean[] visited;
    public static List<List<Bus>> arriveBusList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        dp = new long[N + 1];
        visited = new boolean[N + 1];

        // 버스 저장할 리스트 초기화
        for (int n = 0; n <= N; n++) {
            arriveBusList.add(new ArrayList<>());
        }

        // 버스 입력받기
        for (int m = 0; m < M; m++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            arriveBusList.get(end).add(new Bus(start, pay));
        }

        // 출발지, 도착지 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cityA = Integer.parseInt(st.nextToken());
        int cityB = Integer.parseInt(st.nextToken());

        // dp 탐색
        if(cityA <= cityB)
            DP(cityA, cityB);
        else
            DPreverse(cityA, cityB);


//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[cityB]);

    }

    public static void DP(int cityA, int cityB){
        visited[cityA] = true;
        for (int city = cityA + 1; city <= cityB; city++) {
            for (Bus B : arriveBusList.get(city)) {
                if (visited[B.start] && B.start >= cityA) { // 중간지점까지 갈 수 있는 경우
                    if (!visited[city]) { // 처음 버스일 경우 초기화
                        dp[city] = dp[B.start] + B.pay;
                        visited[city] = true;
                    } else
                        dp[city] = Math.min(dp[city], dp[B.start] + B.pay);
                }
            }
        }
    }

    public static void DPreverse(int cityA, int cityB){
        visited[cityA] = true;
        for (int city = cityA - 1; city >= cityB; city--) {
            for (Bus B : arriveBusList.get(city)) {
                if (visited[B.start] && B.start <= cityA) { // 중간지점까지 갈 수 있는 경우
                    if (!visited[city]) { // 처음 버스일 경우 초기화
                        dp[city] = dp[B.start] + B.pay;
                        visited[city] = true;
                    } else
                        dp[city] = Math.min(dp[city], dp[B.start] + B.pay);
                }
            }
        }
    }

    public static class Bus {
        public int start;
        public int pay;

        Bus(int start, int pay) {
            this.start = start;
            this.pay = pay;
        }
    }
}