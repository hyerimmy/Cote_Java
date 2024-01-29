package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 나머지 연산 할 때 결과값은 int 범위더라도 나머지 연산 전 값이 벗어난다면 Long으로 선언해야 오류나지 않는다!!!!!
 * */
public class Lv2_바이러스 {
    public static void main(String[] args) throws IOException {
        // 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 최대값
        int MAX_VALUE = 1_000_000_007;

        // 계산하기
        long result = K;
        for (int count = 0; count < N; count++) {
            result = (result * P) % MAX_VALUE;
        }

        // 결과 출력하기
        System.out.println(result);
    }
}
