package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Lv2_GBC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 구간 정보 입력받기
        int[][] info = new int[N][2];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            info[n][0] = Integer.parseInt(st.nextToken());
            info[n][1] = Integer.parseInt(st.nextToken());
        }

        // 정답값 변수
        int maxDiffer = 0;

        // 구간 정보 인덱스
        int i = 0;

        // 테스트 정보 입력받아 초과 속도 구하기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            while (d > 0) {
                if (info[i][1] < v)
                    maxDiffer = Math.max(maxDiffer, v - info[i][1]);

                if (info[i][0] > d) { // #1 구간 길이 > 시험할 길이
                    info[i][0] -= d;
                    d = 0;
                } else if (info[i][0] < d) { // #2 구간 길이 < 시험할 길이
                    d -= info[i][0];
                    i++;
                } else { // #3 구간길이 = 시험할 길이
                    d = 0;
                    i++;
                }
            }
        }

        // 결과 출력
        System.out.println(maxDiffer);
    }
}
