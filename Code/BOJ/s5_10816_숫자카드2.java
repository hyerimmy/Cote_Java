package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06
 * @notes - 에센셜2<br>
 */

public class s5_10816_숫자카드2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 카드 개수

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> cardCount = new HashMap<>(); // 카드 카운팅 해시맵
        for(int n=0; n<N; n++){
            int cardNumber = Integer.parseInt(st.nextToken());
            cardCount.put(cardNumber, cardCount.getOrDefault(cardNumber, 0)+1);
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 문제 수

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int m=0; m<M; m++){
            sb.append(cardCount.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(" ");
        }
        System.out.print(sb);
    }
}

