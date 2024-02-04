package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @title 5568 카드 놓기
 * @link https://www.acmicpc.net/problem/5568
 * @date 2024.02.04
 * @notes - 신한은행 대비<br>
 */

public class s4_5568_카드놓기 {
    public static int N;
    public static int K;
    public static int[] numbers;
    public static boolean[] selected;
    public static HashSet<Integer> results = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        numbers = new int[N];
        selected = new boolean[N];

        // 카드 수 입력받기
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        // 카드 수 조합해서 숫자 만들기 (백트래킹)
        BT(0, 0);

        System.out.println(results.size());
    }

    private static void BT(int resultN, int depth) {
        if (depth == K) {
            results.add(resultN);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (selected[i])
                continue;

            selected[i] = true;

            if (numbers[i] < 10)
                BT(resultN * 10 + numbers[i], depth + 1);
            else
                BT(resultN * 100 + numbers[i], depth + 1);

            selected[i] = false;
        }
    }
}

