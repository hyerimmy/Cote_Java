package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.03
 * @notes - 그냥 단순 구현? -> 시간초과 바보야~
 */

public class g5_27172_수나누기게임 {
    public static int[] cards;
    public static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        cards = new int[N];
        scores = new int[N];

        // 점수 입력받기
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            cards[n] = Integer.parseInt(st.nextToken());
        }

        // 게임 진행
        for (int player1 = 0; player1 < N; player1++) {
            for (int player2 = player1 + 1; player2 < N; player2++) {
                playGame(player1, player2);
            }
        }

        // 결과 출력
        StringBuilder answer = new StringBuilder();
        for (int score : scores) {
            answer.append(score).append(" ");
        }
        System.out.println(answer);
    }

    private static void playGame(int player1, int player2) {
        if (cards[player1] % cards[player2] == 0) {
            scores[player2]++;
            scores[player1]--;
        } else if (cards[player2] % cards[player1] == 0) {
            scores[player1]++;
            scores[player2]--;
        }
    }
}