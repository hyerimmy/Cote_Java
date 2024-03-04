package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.03
 * @notes - 그냥 단순 구현? -> 시간초과 바보야~ -> nLog(n)
 */

public class failed_g5_27172_수나누기게임 {

    public static HashMap<Integer, Integer> cards = new HashMap<>();
    public static List<Integer> numbers = new ArrayList<>();
    public static int maxN = 0;

    public static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        scores = new int[N];

        // 점수 입력받기
        st = new StringTokenizer(br.readLine());
        for (int idx = 0; idx < N; idx++) {
            int number = Integer.parseInt(st.nextToken());
            cards.put(number, idx);
            numbers.add(number);
            maxN = Math.max(maxN, number);
        }

        // 카드 숫자 오름차순
        Collections.sort(numbers);

        // 게임 진행
        for (int smallN : numbers) {
            for (int bigN = smallN * 2; bigN <= maxN; bigN += smallN) {
//                System.out.println("smallN : " + smallN + " & bigN : " + bigN);
                if (cards.containsKey(bigN)) {
                    scores[cards.get(smallN)]++;
                    scores[cards.get(bigN)]--;

                }
            }
        }

        // 결과 출력
        StringBuilder answer = new StringBuilder();
        for (int score : scores) {
            answer.append(score).append(" ");
        }
        System.out.println(answer);
    }
}
