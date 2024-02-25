package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.25
 * @notes - 신발끈 공식 보고 문제 풀었다!!!<br>
 * - 신발끈 공식이란? 좌표값을 신발끈 형태로 곱해 차이의 1/2하면 다각형 면적을 계산할 수 있다. <br>
 * - https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B0%9C%EB%81%88_%EA%B3%B5%EC%8B%9D <br>
 * - 계산 시 < A(double) = B(int) * C(int) > 일 경우 -> B*C에서 이미 int overflow 발생해서 A에 이상한 값 들어감..
 */
public class g5_2166_다각형의면적 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] points = new int[N + 1][2]; // 좌표값

        // 좌표값 입력받기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            points[n] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }
        points[N] = points[0];

        // 면적 계산
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += (points[i][0] * (double) points[i + 1][1]);
            sum2 += (points[i][1] * (double) points[i + 1][0]);
        }

        // 결과 출력
        double result = Math.abs(sum1 - sum2) * 0.5;
        System.out.println(String.format("%.1f", result));
    }
}
