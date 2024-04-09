package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem/1005
 * @date 2024.04.10
 * @notes - 43분, 1트에 성공!! <br>
 */

public class g3_1005_ACMCraft {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물수
            int K = Integer.parseInt(st.nextToken()); // 규칙수

            int[] times = new int[N + 1]; // 건물 별 소요시간
            long[] minTimes = new long[N + 1]; // 건물까지의 최소 소요시간
            List<List<Integer>> rules = new ArrayList<>(); // 규칙 정보

            int[] prevCnt = new int[N + 1]; // 건물 별 이전 만족 건물 수 카운팅
            int[] prevNeedCnt = new int[N + 1]; // 건물 별 이전 만족 건물 수

            // 규칙 리스트 크기 초기화
            for (int n = 0; n <= N; n++) {
                rules.add(new ArrayList<>());
            }

            // 건물 별 시간 입력받기
            st = new StringTokenizer(br.readLine());
            for (int n = 1; n <= N; n++) {
                times[n] = Integer.parseInt(st.nextToken());
            }

            // 규칙 입력받기
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                rules.get(a).add(b);
                prevNeedCnt[b]++;
            }

            // 목표 건물 입력받기
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken()); // 목표 건물

            // 최소 시간 계산을 위한 Q 정의
            Queue<Integer> Q = new LinkedList<>();

            // 시작 가능한 건물 Q에 넣기
            for (int n = 1; n <= N; n++) {
                if (prevNeedCnt[n] == 0) {
                    Q.add(n);
                    minTimes[n] = times[n];
                }
            }

            // 최소 시간 계산 탐색
            while (!Q.isEmpty()) {
                int current = Q.poll();

                // 목표한 건물까지 탐색이 되었다면 종료
                if (current == W)
                    break;

                for (int next : rules.get(current)) {
                    minTimes[next] = Math.max(minTimes[next], minTimes[current] + times[next]);
                    prevCnt[next]++;

                    // 완벽히 이전 경로를 모두 탐색한 건물이라면 Q에 추가
                    if (prevNeedCnt[next] == prevCnt[next]) {
                        Q.add(next);
                    }
                }
            }

            // 결과 저장
            sb.append(minTimes[W]).append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}

