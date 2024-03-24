package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem/
 * @date 2024.03.23
 * @notes - 골3 도전<br>
 * - 한 번에 풀어보자. (1. BFS -> 2. 배낭문제DP)
 * - 망할 배낭문제!!!! 바보야 배낭문제 알고리즘 제대로 알지도 못했으면서 왜 아는줄 알았던거니~~~ 기억해
 */

public class g3_20303_할로윈의양아치__배낭문제 {
    public static int N, M, K;
    public static int[] candies;

    public static List<List<Integer>> relations = new ArrayList<>();
    public static List<Friends> friendsList = new ArrayList<>();
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candies = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
//            Random rd = new Random();
//            candies[n] = rd.nextInt(10000) + 1;

            candies[n] = Integer.parseInt(st.nextToken());
        }

        for (int n = 0; n <= N; n++) {
            relations.add(new ArrayList<>());
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

//            Random rd = new Random();
//            int a = rd.nextInt(N) + 1;
//            int b = rd.nextInt(N) + 1;

            relations.get(a).add(b);
            relations.get(b).add(a);
        }

        // BFS
        visited = new boolean[N + 1];
        for (int n = 1; n <= N; n++) {
            if (!visited[n]) BFS(n);
        }

        // DP
        int friendsSize = friendsList.size();

        int[][] dp = new int[friendsSize + 1][K];

        for (int f = 1; f <= friendsSize; f++) {
            Friends friends = friendsList.get(f - 1);
//            System.out.println(friends);

            for (int max = 1; max <= K - 1; max++) {
                // 1. 친구무리를 넣지 않는 경우
                dp[f][max] = dp[f - 1][max];

                // 2. 친구무리를 넣는 경우
                if (friends.friendCount <= max) {
                    dp[f][max] = Math.max(dp[f][max], friends.candyCount + dp[f - 1][max - friends.friendCount]);
                }
            }

//            System.out.println(Arrays.toString(dp[f]));
        }


        // 출력
        System.out.println(dp[friendsSize][K - 1]);
    }

    public static void BFS(int startN) {
        Queue<Integer> Q = new LinkedList<>();

        visited[startN] = true;
        int friendCount = 1;
        int candyCount = candies[startN];
        Q.add(startN);

        while (!Q.isEmpty()) {
            int n = Q.poll();

            for (int friend : relations.get(n)) {
                if (visited[friend]) {
                    continue;
                }

                visited[friend] = true;
                friendCount++;
                candyCount += candies[friend];
                Q.add(friend);
            }

        }

        friendsList.add(new Friends(friendCount, candyCount));
    }

    private static class Friends {
        int friendCount;
        int candyCount;

        public Friends(int friendCount, int candies) {
            this.friendCount = friendCount;
            this.candyCount = candies;
        }
    }
}