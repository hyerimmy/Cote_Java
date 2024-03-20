package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.20
 * @notes - 촌수계산<br>
 */

public class s2_2644_촌수계산 {
    public static int N, P1, P2;
    public static List<List<Integer>> relations = new ArrayList<>();
    public static boolean[] visited;
    public static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // relations 초기화
        for (int n = 0; n <= N; n++) {
            relations.add(new ArrayList<>());
        }

        // visited 초기화
        visited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        P1 = Integer.parseInt(st.nextToken());
        P2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        // 관계 입력받기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            relations.get(x).add(y);
            relations.get(y).add(x);
        }

        // BFS
        BFS();

        // 결과 출력
        System.out.println(result);
    }

    private static void BFS() {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{P1, 0});

        while (!Q.isEmpty()) {
            int[] person = Q.poll();

            // 이미 방문한 노드라면 건너뛰기
            if (visited[person[0]]) {
                continue;
            }

            // 정답이라면 결과값 갱신하고 종료
            if (person[0] == P2) {
                result = person[1];
                break;
            }

            // 주변 값 Q에 추가
            for (int relatedPerson : relations.get(person[0])) {
                Q.add(new int[]{relatedPerson, person[1] + 1});
            }
            visited[person[0]] = true;
        }
    }
}

