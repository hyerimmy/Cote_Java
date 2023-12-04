package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.04.
 * @notes - 백트래킹 연습!! 백트래킹 뿌숴야지 <br>
 */

public class s2_15666_N과M12 {
    public static int N;
    public static int M;
    public static int[] answers;
    public static List<Integer> numbers;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answers = new int[M];

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> numbersSet = new HashSet<>();
        for (int n = 0; n < N; n++) {
            numbersSet.add(Integer.parseInt(st.nextToken()));
        }
        numbers = new ArrayList<>(numbersSet);
        Collections.sort(numbers);

        BT(0, 0);
        System.out.println(sb);
    }

    public static void BT(int prev, int depth) {
        if (depth == M) {
            for (int answer : answers)
                sb.append(answer).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = prev; i < numbers.size(); i++) {
            answers[depth] = numbers.get(i);
            BT(i, depth + 1);
        }
    }
}