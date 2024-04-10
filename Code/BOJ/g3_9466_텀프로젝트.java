package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/9466
 * @date 2024.04.10
 * @notes - 1트(50m) : 79%에서 시간초과 <br>
 * - 2트(55m) : 성공, visited 배열 통해서 이미 방문한 노드 재방문하지 않도록 처리. <br/>
 * - 작은 테스트케이스에서는 큰 차이 없어보여도 히든에서 시간초과 날 수 있으니 생각나는 모든 경우는 최대한 제거하도록 할 것..
 */

public class g3_9466_텀프로젝트 {
    public static int N;
    public static int[] wants;
    public static boolean[] canMakeTeam;
    public static boolean[] visited;
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
            visited = new boolean[N + 1];

            // 팀하고 싶은 학생 정보 입력
            st = new StringTokenizer(br.readLine());
            for (int n = 1; n <= N; n++) {
//                Random rd = new Random();
//                wants[n] = rd.nextInt(N) + 1;
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
        // 이미 방문한 루트라면 사이클 만들 수 없는 경우뿐
        if (visited[student])
            return -1;

        history.add(student);
        visited[student] = true;
        int next = wants[student];

//        System.out.println();
//        System.out.println("== " + student + " & next : " + next);
//        System.out.println(history);
//        System.out.println(Arrays.toString(canMakeTeam));

        // 팀이 지금 결성된다면 (next = 팀의 시작점)
        if (history.contains(next)) {
            canMakeTeam[student] = true;
            if (student == next) // 스스로 팀 결성하고 끝난 경우
                return -1;
            return next; // 팀 결성 계속해서 처리해야 하는 경우
        }

        // 이미 팀 결성한 학생을 원하는 경우라면 팀 결성 불가
        if (canMakeTeam[next]) {
            return -1;
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

