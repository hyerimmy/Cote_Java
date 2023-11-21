package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.21.
 * @notes - 에센셜3 <br>
 */

public class s1_1074_Z {
    public static int answer = 0;
    public static int R;
    public static int C;
    public static int startR = 0;
    public static int startC = 0;

    public static int[] dRow = new int[]{0, 0, 1, 1};
    public static int[] dColumn = new int[]{0, 1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int size = 1;
        for (int i = 0; i < N; i++) {
            size *= 2;
        }

        findArea(size / 2);
        System.out.println(answer);
    }

    public static void findArea(int size) {
        if (size == 1) {
            // 마지막 계산
            findTarget();
        } else {
            for (int t = 0; t < 4; t++) {
                int subStartR = startR + size * dRow[t];
                int subStartC = startC + size * dColumn[t];

                if (subStartR <= R && R <= subStartR + size - 1
                        && subStartC <= C && C <= subStartC + size - 1) {
                    // 범위를 찾았다
                    startR = subStartR;
                    startC = subStartC;
                    answer += size * size * t;
                    findArea(size / 2);
                    break;
                }
            }
        }
    }

    public static void findTarget() {
        for (int t = 0; t < 4; t++) {
            int subStartR = startR + dRow[t];
            int subStartC = startC + dColumn[t];
            if (subStartR == R && subStartC == C) {
                answer += t;
                break;
            }
        }
    }
}