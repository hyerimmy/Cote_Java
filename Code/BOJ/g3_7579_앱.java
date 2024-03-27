package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.26.
 * @notes - 배낭문제<br/>
 * - 배낭문제 유형 풀 때, 두 조건 중 어떤 것이 더 작은지 고민하고 그것을 기준으로 전개해나갈 것 (시간초과, 메모리초과 방지) <br/>
 * - 예를 들어, 7579 앱 문제에서는 cost, memory 두 가지 조건이 있는데 cost 가능 최대값이 훨씬 작기 때문에 cost 기준으로 배낭알고리즘 진행.
 */

public class g3_7579_앱 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 앱 데이터 (메모리, 비용) 리스트
        List<App> apps = new ArrayList<>();
        apps.add(null); // 1부터 인덱스 시작하도록 더미데이터

        // 모든 비용의 합
        int costSum = 0;

        // 메모리, 비용 입력받기
        StringTokenizer memoryInputs = new StringTokenizer(br.readLine());
        StringTokenizer costInputs = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int cost = Integer.parseInt(costInputs.nextToken());
            int memory = Integer.parseInt(memoryInputs.nextToken());

//            Random rd = new Random();
//            int cost = rd.nextInt(100) + 1;
//            int memory = rd.nextInt(10_000_000) + 1;

            apps.add(new App(cost, memory));
            costSum += cost;
        }

        // 배낭 알고리즘 진행
        long[][] maxMemories = new long[costSum + 1][N + 1];
        int resultCost = -1;
        for (int cost = 0; cost <= costSum; cost++) {
            for (int i = 1; i <= N; i++) {
                App app = apps.get(i);

                // 1. 해당 메모리를 선택하지 않는 경우
                maxMemories[cost][i] = maxMemories[cost][i - 1];

                // 2. 해당 메모리를 선택하는 경우
                if (app.cost <= cost) {
                    long memory = app.memory + maxMemories[cost - app.cost][i - 1];
                    maxMemories[cost][i] = Math.max(maxMemories[cost][i], memory);
                }

                // 만약 목표한 메모리를 채운다면 종료
                if (maxMemories[cost][i] >= M) {
                    resultCost = cost;
                    break;
                }
            }

            if (resultCost != -1) {
                break;
            }
        }

        System.out.println(resultCost);
    }

    private static class App {
        int cost;
        int memory;

        App(int cost, int memory) {
            this.cost = cost;
            this.memory = memory;
        }
    }

}
