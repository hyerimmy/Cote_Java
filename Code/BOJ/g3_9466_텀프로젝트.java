package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/9466
 * @date 2024.04.10
 * @notes - <br>
 */

public class g3_9466_텀프로젝트 {
    public static int N;
    public static int[] wants;
    public static boolean[] canMakeTeam;
    public static HashSet<Integer> history; // DFS 탐색용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            // 탐색 위한 배열 크기 지정
            wants = new int[N + 1];
            canMakeTeam = new boolean[N + 1];

            // 팀하고 싶은 학생 정보 입력
            st = new StringTokenizer(br.readLine());
            for (int n = 1; n <= N; n++) {
                wants[n] = Integer.parseInt(st.nextToken());
            }

            // 탐색
            for (int n = 1; n <= N; n++) {
                // 이미 팀이 결성되었다면 건너뛰기 (두 가지 팀에 속하는 경우는 불가능함)
                if (canMakeTeam[n])
                    continue;

                // history 초기화 후 탐색 진행
                history = new HashSet<>();
                DFS(n);
            }

            // 결과 계산 및 저장
            int result = 0;
            for (int n = 1; n <= N; n++) {
                if (!canMakeTeam[n]) result++;
            }
            sb.append(result).append("\n");
        }

        // 전체 결과 출력
        System.out.println(sb);
    }

    private static int DFS(int student) {
        history.add(student);
        int next = wants[student];

        // 팀이 지금 결성된다면 (next = 팀의 시작점)
        if (history.contains(next)) {
            canMakeTeam[student] = true;
            return next;
        }

        // 끝까지 탐색했을 때 팀의 시작점을 target으로 받아옴
        int target = DFS(next);

        // -1일 경우 팀 결성 불가한 경우
        if (target == -1)
            return -1;

        // 팀 결성 가능한 경우
        canMakeTeam[student] = true;
        if (target == student) { // 팀 결성 시작점까지 왔다면 이젠 -1 반환
            return -1;
        }
        // 팀 결성 시작점이 아직 아니라면 계속해서 시작점 반환
        return target;
    }
}

