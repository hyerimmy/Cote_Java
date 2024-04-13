package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1049
 * @date 2024.04.14
 * @notes - <br>
 */

public class s4_1049_기타줄 {
    public static int MAX_PRICE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] minPrice = new int[]{MAX_PRICE, MAX_PRICE}; // 6개 구매 가격, 낱개 구매 가격

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int[] inputPrices = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            // 6개 가격 계산
            minPrice[0] = Math.min(minPrice[0], inputPrices[0]);
            minPrice[0] = Math.min(minPrice[0], inputPrices[1] * 6);

            // 나머지 가격 계산
            minPrice[1] = Math.min(minPrice[1], inputPrices[1]);
        }

        // 최종 금액 계산 및 출력
        int resultPrice = 0;
        resultPrice = minPrice[0] * (N / 6) + Math.min(minPrice[0], minPrice[1] * (N % 6));
        System.out.println(resultPrice);
    }
}
