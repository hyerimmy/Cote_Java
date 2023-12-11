package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1932
 * @date 2023.12.11.
 * @notes - 집합을 합쳐나가는 Union find 로 풀어보자. <br>
 * - union find의 진짜 중요한 포인트!!! 같은 집합인지 확인하려면  <br>
 * - prent[a] == parent[b] (x) <br>
 * - find(a) == find(b) (o) <br>
 */

public class g4_1043_거짓말 {
    public static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 대표값 배열 크기 지정 및 초기화
        parents = new int[N + 1];
        for (int n = 1; n <= N; n++) {
            parents[n] = n;
        }

        // 진실을 아는 사람 연결하기
        st = new StringTokenizer(br.readLine());
        int knowPersonCount = Integer.parseInt(st.nextToken());
        int knowPrimary = -1;
        if (knowPersonCount > 0) {
            knowPrimary = Integer.parseInt(st.nextToken());
            for (int i = 0; i < knowPersonCount - 1; i++) {
                parents[Integer.parseInt(st.nextToken())] = parents[knowPrimary];
            }
        }
//        System.out.println(Arrays.toString(parents));

        // 파티원 입력받아 union find 연산 수행
        List<List<Integer>> partyMembers = new ArrayList<>();
        for (int m = 0; m < M; m++) {
            partyMembers.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int partyPersonCount = Integer.parseInt(st.nextToken());
            int partyPrimary = -1;
            if (partyPersonCount > 0) {
                partyPrimary = Integer.parseInt(st.nextToken());
                partyMembers.get(m).add(partyPrimary);
                for (int i = 0; i < partyPersonCount - 1; i++) {
                    int partyMember = Integer.parseInt(st.nextToken());
                    partyMembers.get(m).add(partyMember);
                    union(partyMember, partyPrimary);
                }
            }
        }
//        System.out.println(Arrays.toString(parents));

        // 파티 수 출력
        int result = 0;
        if (knowPersonCount == 0)
            result = M;
        else {
            // 대표값 정돈하기
            int primaryParent = find(knowPrimary);
            // 파티 전체 탐색하며 거짓말 파티 수 계산
            for (List<Integer> members : partyMembers) {
                result++;
                for(int member : members){
                    if(find(member) == primaryParent){
                        result--;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b)
            parents[a] = b;
    }

    private static int find(int a) {
        if (parents[a] == a)
            return a;

        return parents[a] = find(parents[a]);
    }
}