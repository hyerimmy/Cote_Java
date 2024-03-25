package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.25
 * @notes - 코테 <br>
 */

public class s4_1459_걷기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        long time = 0;

        // 오른쪽 왼쪽 모두 공통부분까지 이동
        time += Math.min(X, Y) * (long) Math.min(2 * W, S);

        // 남은 일직선 거리 이동
        int gap = Math.max(X, Y) - Math.min(X, Y);
        time += (gap / 2 * 2) * (long) Math.min(W, S);
        time += (gap % 2) * (long) W;

        // 결과 출력
        System.out.println(time);
    }
}