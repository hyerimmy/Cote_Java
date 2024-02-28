package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.06
 * @notes - 벨만포드 예제<br>
 * - int 타입로 했다가 틀려서 long으로 변경했더니 통과 했습니다. 그런데 모든 노선의 가중치가 10,000이라 하더라도 최대 가중치는 500 * 10,000 이라 int타입으로 해도 넘을 것 같지가 않은데 왜 이슈가 존재하는지 궁금합니다. <br>
 * - 오버플로우가 날 일은 없지만 언더플로우는 날 수 있습니다. 음수 사이클이 있으면 최단거리가 단순히 간선 가중치를 합한 것보다도 작아질 수 있기 때문입니다. <br>
 */

public class g4_10942_팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        boolean[][] isPallindrom = new boolean[N][N];

        // 숫자 입력받기
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }

        // 팰린드롬 탐색하기 (DP)
        isPallindrom[N - 1][N - 1] = true;
        for (int s = N - 2; s >= 0; s--) {
            isPallindrom[s][s] = true;
            for (int e = s + 1; e < N; e++) {
                // 가운데 숫자가 팰린드롬이지 않다면 종료
                if ((e - s) > 1 && !isPallindrom[s + 1][e - 1]) {
                    continue;
                }

                // 앞 뒤 숫자 같지 않다면 종료
                if (numbers[s] != numbers[e]) {
                    continue;
                }

                isPallindrom[s][e] = true;
            }
//            System.out.println(s + " -> " + Arrays.toString(isPallindrom[s]));
        }


        // 질문 개수 입력받기
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        // 질문 입력받고 결과 저장하기
        StringBuilder result = new StringBuilder();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            result.append(isPallindrom[start][end] ? 1 : 0).append("\n");
        }

        // 결과 출력하기
        System.out.println(result);
    }
}

