package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.22.
 * @notes - 에센셜3 <br>
 */

public class s4_11047_동전0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[N - i - 1] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;
        for (int amount : coin) {
            if(K >= amount) {
                cnt += K / amount;
                K %= amount;
            }

            if(K==0)
                break;
        }

        System.out.println(cnt);
    }
}