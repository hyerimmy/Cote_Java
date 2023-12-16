package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.29
 * @notes - 브루트포스트
 * - 메모리 초과 : BFS->DFS 변경해보자. : 해결<br>
 * - 시간 초과 : DFS 호출 시 이전에 확인했던 값은 제외하고 재귀하도록 startIdx 추가 : 7%, 시간초과<br>
 * - BFS를 제대로 이해하지 못했다.<br>
 * - 푸는 방법에는 2가지 : (1)백트래킹, (2)동적계획법<br>
 * - -> (1) 백트래킹 : 물건을 선택하거나 선택하지 않거나 싹 돌아보기
 * - -> (2) 동적계획법 DP : 각 단계에서 구한 해를 다음 문제에서 재사용
 * - 동적계획법 사용해서 풀었다. 틀렸다.. -> index의 굴레.. 정신 제대로 차려보자!! 성공.
 */

public class g5_12865_평범한배낭 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //물품수
        int K = Integer.parseInt(st.nextToken()); //최대무게

        Item[] itemA = new Item[N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            itemA[i] = new Item(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }

        int[][] DP = new int[N+1][K+1];
        for (int k = 1; k <= K; k++) {
            for (int i = 1; i <= N; i++) {
                // 물건을 넣는 경우
                if (itemA[i].w <= k)
                    DP[i][k] = itemA[i].v + DP[i-1][k-itemA[i].w];
                // 물건을 넣지 않는 경우
                DP[i][k] = Math.max(DP[i][k], DP[i-1][k]);
            }
        }
        System.out.print(DP[N][K]);
    }

    public static class Item {
        public int w;//무게
        public int v;//가치

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
