package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.04.
 * @notes - 백트래킹 연습!! 백트래킹 뿌숴야지 <br>
 */

public class s2_15663_N과M9 {
    public static int N;
    public static int M;
    public static int[] answers;
    public static HashMap<Integer, Integer> numberCount = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answers = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int inputN = Integer.parseInt(st.nextToken());
            numberCount.put(inputN, numberCount.getOrDefault(inputN, 0) + 1);
        }

        System.out.println(numberCount);

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

        for (int n : numberCount.keySet()) {
            if(numberCount.get(n) > 0){
                answers[depth] = n;
                numberCount.put(n, numberCount.get(n)-1);
                BT(depth + 1);
                numberCount.put(n, numberCount.get(n)+1);
            }
        }
    }
}