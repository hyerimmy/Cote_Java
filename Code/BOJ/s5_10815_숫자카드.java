package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/10815
 * @date 2024.06.01
 * @notes - <br>
 */

public class s5_10815_숫자카드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Set<Integer> cards = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(st.nextToken());
            cards.add(card);
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
//            cards.contains(number)?1:0;
            sb.append(cards.contains(number) ? 1 : 0).append(" ");
        }

        System.out.println(sb);
    }
}

