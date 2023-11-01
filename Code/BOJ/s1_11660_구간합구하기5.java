package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.01
 * @notes - 현대 기출<br>
 * - 역시나 시간초과. 어떻게 풀더라.. -> 구간합 배열을 만들어서!!
 * - 기억하자!! 구간합을 구해야 한다면 입력받을 때 한 번만 구간합 배열 만들어서 사용하는게 시간효율 좋음!!
 * - 아 그래도 시간초과넹.. -> 2차원 구간합을 만들어야 해!!!
 * 헷갈리니까 그냥 If문 많이 써서 하자. 가독성이 중요한거 아니니까..
 */

public class s1_11660_구간합구하기5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        int[][] S = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                int inputN = Integer.parseInt(st.nextToken());
                if (i == 0 && k == 0) {
                    S[i][k] = inputN;
                } else if (i == 0) {
                    S[i][k] = inputN + S[i][k - 1];
                } else if (k == 0) {
                    S[i][k] = inputN + S[i - 1][k];
                } else {
                    S[i][k] = inputN + S[i][k - 1] + S[i - 1][k] - S[i - 1][k - 1];
                }
            }
        }

        for (long m = 0; m < M; m++) {
            long answer;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            if (x1 == 0 && y1 == 0) {
                answer = S[x2][y2];
            } else if (x1 == 0) {
                answer = S[x2][y2] - S[x2][y1 - 1];
            } else if (y1 == 0) {
                answer = S[x2][y2] - S[x1 - 1][y2];
            } else {
                answer = S[x2][y2] - S[x1 - 1][y2] - S[x2][y1 - 1] + S[x1 - 1][y1 - 1];
            }
            System.out.println(answer);
        }
    }
}

