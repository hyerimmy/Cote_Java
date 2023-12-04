package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.04.
 * @notes - 백트래킹 연습!! 백트래킹 뿌숴야지 <br>
 */

public class s3_15657_N과M8 {
    public static int N;
    public static int M;
    public static int[] numbers;
    public static int[] answers;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        answers = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort( numbers);


        BT(0,0);
        System.out.println(sb);
    }

    public static void BT(int prev, int depth) {
        if (depth == M) {
            for (int answer : answers)
                sb.append(answer).append(" ");
            sb.append("\n");
            return;
        }

        for (int n = prev ; n < N; n++) {
            answers[depth] = numbers[n];
            BT(n, depth + 1);
        }
    }
}