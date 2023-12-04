package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.04.
 * @notes - 백트래킹 연습!! 백트래킹 뿌숴야지 <br>
 */

public class s3_15651_N과M3 {
    public static int N;
    public static int M;
    public static int[] answers;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answers = new int[M];

        BT(0);
        System.out.println(sb);
    }

    public static void BT(int depth) {
        if (depth == M) {
            for (int answer : answers)
                sb.append(answer).append(" ");
            sb.append("\n");
            return;
        }

        for (int n = 1; n <= N; n++) {
            answers[depth] = n;
            BT(depth + 1);
        }
    }
}