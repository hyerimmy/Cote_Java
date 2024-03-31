package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.28
 * @notes - DFS <br>
 */
public class _failed_s1_1325_효율적인해킹 {
    public static int N;
    public static boolean[][] canHack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 배열, 리스트 크기 초기화
        canHack = new boolean[N + 1][N + 1];

        // relatioins 입력
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            canHack[b][a] = true;
        }

        // BFS (canHack 배열 완성)
        BFS();

        // 최대 해킹 컴퓨터 수 계산
        int maxHackCount = 0;
        int[] hackCounts = new int[N + 1];
        for (int s = 1; s <= N; s++) {
            for (int e = 1; e <= N; e++) {
                if (canHack[s][e]) hackCounts[s]++;
            }
            maxHackCount = Math.max(hackCounts[s], maxHackCount);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int c = 1; c <= N; c++) {
            if (hackCounts[c] == maxHackCount) sb.append(c).append(" ");
        }
        System.out.println(sb);
    }

    private static void BFS() {
        Queue<Integer> Q = new LinkedList<>();

    }
}