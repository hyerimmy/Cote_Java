package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.02
 * @notes - 유니온파인드문제 <br>
 */

public class g4_20040_사이클게임 {
    public static int N, M;
    public static int[] parents;
    public static boolean existCycle = false;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // parents 배열 초기화
        parents = new int[N];
        for (int n = 0; n < N; n++) {
            parents[n] = n;
        }

        // 선 연결 반복
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if (n1 != n2) {
                union(n1, n2);
            }

            if (existCycle) {
                result = m + 1;
                break;
            }
//            System.out.println(Arrays.toString(parents));
        }

        // 결과 출력
        System.out.println(result);
    }

    public static void union(int n1, int n2) {
        n1 = find(n1);
        n2 = find(n2);

        if (n1 == n2) {
            existCycle = true;
        }

        parents[n1] = n2;
    }

    public static int find(int n) {
        if (parents[n] == n) {
            return n;
        }

        return parents[n] = find(parents[n]);
    }
}