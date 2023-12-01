package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.27
 * @notes - 에센셜3++<br>
 * - 플로이드-워셜
 */
public class s1_1389_케빈베이컨의6단계법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] relations = new long[N + 1][N + 1];

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            relations[A][B] = 1;
            relations[B][A] = 1;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int start = 1; start < N + 1; start++) {
                for (int end = 1; end < N + 1; end++) {
                    if (start == end)
                        continue;

                    if (relations[start][k] > 0 && relations[k][end] > 0) {
                        if(relations[start][end] == 0)
                            relations[start][end] = relations[start][k] + relations[k][end];
                        relations[start][end] = Math.min(relations[start][end], relations[start][k] + relations[k][end]);
                    }
                }
            }
        }

        long minResult = 0;
        int minUser = 0;
        for (int user = 1; user < N + 1; user++) {
            int result = 0;
//            System.out.println(Arrays.toString(relations[user]));
            for (long levelCount : relations[user])
                result += levelCount;
            if (minUser == 0 || minResult > result || (minResult == result && minUser > user)) {
                minUser = user;
                minResult = result;
            }
        }

        System.out.println(minUser);

    }
}
