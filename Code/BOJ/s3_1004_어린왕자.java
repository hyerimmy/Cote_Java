package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.04.07.
 * @notes - 한번에맞았지롱~<br>
 */

public class s3_1004_어린왕자 {
    public static int[][] calculateResult = new int[2001][2001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());
        for (int t = 0; t < T; t++) {
            // 행성계 진입/이탈 횟수
            int count = 0;

            // 시작좌표, 마지막 좌표 입력받기
            st = new StringTokenizer(br.readLine());
            int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            // 행성 개수 입력받기
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            // 행성 정보 입력받고 계산하기
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                int[] c = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
                int r = Integer.parseInt(st.nextToken());

                // 통과를 꼭 해야한다면 카운팅 추가
                if (addCount(start, end, c, r)) {
                    count++;
                }
            }

            // 결과 저장
            sb.append(count).append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }

    private static boolean addCount(int[] s, int[] e, int[] c, int r) {
        int distance1 = getCalculateValue(s[0], c[0]) + getCalculateValue(s[1], c[1]);
        int compareResult1 = Integer.compare(distance1, r * r);

        int distance2 = getCalculateValue(e[0], c[0]) + getCalculateValue(e[1], c[1]);
        int compareResult2 = Integer.compare(distance2, r * r);

        if (compareResult1 * compareResult2 == -1)
            return true;
        return false;
    }

    private static int getCalculateValue(int a, int b) {
        if (a != b && calculateResult[a + 1000][b + 1000] == 0) {
            calculateResult[a + 1000][b + 1000] = (a - b) * (a - b);
            calculateResult[b + 1000][a + 1000] = calculateResult[a + 1000][b + 1000];
        }
        return calculateResult[a + 1000][b + 1000];
    }
}

