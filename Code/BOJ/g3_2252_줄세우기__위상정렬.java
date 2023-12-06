package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.06
 * @notes - 에센셜4<br>
 * - 유니온파인드 예제<br>
 */

public class g3_2252_줄세우기__위상정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 키 비교 수

        // 진입 차수 배열
        int[] indegree = new int[N + 1];

        // 인접 리스트로 그래프 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 연결
        for(int m=0; m<M; m++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph.get(S).add(E);
            indegree[E]++;
        }

        // 위상정렬 실행
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            sb.append(now).append(" ");

            for(int next : graph.get(now)){
                indegree[next]--;
                if(indegree[next] == 0)
                    queue.add(next);
            }
        }

        System.out.println(sb);
    }
}

