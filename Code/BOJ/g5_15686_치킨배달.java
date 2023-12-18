package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.18
 * @notes - 에센셜 4<br>
 * - 시간초과 -> 문 닫을 가게를 중복해서 선택하지 않으므로 startChickenIdx 를 DFS 매개변수로 추가했다!! <br>
 */

public class g5_15686_치킨배달 {
    public static int M;
    public static List<int[]> chickenList = new ArrayList<>();
    public static List<int[]> homeList = new ArrayList<>();

    public static int[][] distance;

    public static boolean[] visited;
    public static int visitCount = 0;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 지도 입력받고 치킨가게, 집 위치 리스트 초기화
        int[][] map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());

                if (map[r][c] == 1)
                    homeList.add(new int[]{r, c});
                if (map[r][c] == 2)
                    chickenList.add(new int[]{r, c});
            }
        }

        // 치킨 거리 계산
        distance = new int[chickenList.size()][homeList.size()];
        for (int chickenIdx = 0; chickenIdx < chickenList.size(); chickenIdx++) {
            for (int homeIdx = 0; homeIdx < homeList.size(); homeIdx++) {
                int[] chickenP = chickenList.get(chickenIdx);
                int[] homeP = homeList.get(homeIdx);
                distance[chickenIdx][homeIdx] = Math.abs(chickenP[0] - homeP[0]) + Math.abs(chickenP[1] - homeP[1]);
            }
        }

        // DFS + 백트래킹
        visited = new boolean[chickenList.size()];
        DFS(0);

        // 결과 출력
        System.out.println(answer);
    }

    public static void DFS(int startChickenIdx) {
        if (visitCount == M) {
            // 최단거리 저장 배열
            int[] minDistance = new int[homeList.size()];

            // 최소값 계산하기
            for (int chickenIdx = 0; chickenIdx < chickenList.size(); chickenIdx++) {
                if (visited[chickenIdx]) {
                    for (int homeIdx = 0; homeIdx < homeList.size(); homeIdx++) {
                        if (minDistance[homeIdx] == 0)
                            minDistance[homeIdx] = distance[chickenIdx][homeIdx];
                        else
                            minDistance[homeIdx] = Math.min(minDistance[homeIdx], distance[chickenIdx][homeIdx]);
                    }
                }
            }

            // 합해서 결과 갱신
            int distanceSum = 0;
            for (int distance : minDistance)
                distanceSum += distance;
            answer = Math.min(answer, distanceSum);
        }

        for (int chickenIdx = startChickenIdx; chickenIdx < chickenList.size(); chickenIdx++) {
            if (!visited[chickenIdx]) {
                visited[chickenIdx] = true;
                visitCount++;
                DFS(startChickenIdx + 1);
                visited[chickenIdx] = false;
                visitCount--;
            }
        }
    }
}
