package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.02
 * @notes - 그냥 반복문 돌린다면 시간초과 예상됨. 누적합 활용<br>
 */

public class g5_31091_거짓말 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] upCount = new int[N + 1]; // 이상, 0 카운트
        int[] downCount = new int[N + 1]; // 이하 카운트
        List<Integer> answers = new ArrayList<>(); // 결과

        // 이상, 이하 개수 입력받기
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int inputN = Integer.parseInt(st.nextToken());
            if (inputN <= 0)
                downCount[inputN * -1]++;
            else
                upCount[inputN]++;
        }

        // 이상, 이하 누적합 구하기
        for (int idx = 1; idx <= N; idx++) {
            upCount[idx] += upCount[idx - 1];
        }
        for (int idx = N - 1; idx >= 0; idx--) {
            downCount[idx] += downCount[idx + 1];
        }

//        System.out.println(Arrays.toString(upCount));
//        System.out.println(Arrays.toString(downCount));

        // 이상 누적합, 이하 누적합 합해서 가능한 수의 개수 구하기
        for (int idx = 0; idx <= N; idx++) {
            if (upCount[idx] + downCount[idx] == N - idx)
                answers.add(idx);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        Collections.sort(answers);
        sb.append(answers.size()).append("\n");
        for (int answer : answers)
            sb.append(answer).append(" ");
        System.out.println(sb);
    }
}

