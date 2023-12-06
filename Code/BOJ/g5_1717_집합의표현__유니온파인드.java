package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.06
 * @notes - 유니온파인드 예제<br>
 */

public class g5_1717_집합의표현__유니온파인드 {
    public static int[] parent; // 대표노드 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 집합 개수
        int M = Integer.parseInt(st.nextToken()); // 연산 개수


        // 대표 노드 초기화
        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        // 질의 계산
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (type == 0) { // union
                union(a, b);

            } else { // 두 원소 같은지 확인
                if (checkSame(a, b))
                    sb.append("YES").append("\n");
                else
                    sb.append("NO").append("\n");
            }
        }

//        System.out.println(Arrays.toString(parent));

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        // 대표 노드 찾아서 대표값끼리 승부본다!
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a; // 두 집합 연결
        }
    }

    private static int find(int a) {
        if (a == parent[a]) return a;
        else {
            return parent[a] = find(parent[a]); // parent[a]에 대입 -> 시간단축! (중요)
        }
    }

    private static boolean checkSame(int a, int b) {
        return find(a) == find(b);
    }

}

