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
 * - -> (2) 동적계획법 : 각 단계에서 구한 해를 다음 문제에서 재사용
 */

public class failed_g5_12865_평범한배낭 {
    public static int N; //물품수
    public static int K; //최대무게
    public static int[][] items; //물품 무게, 가치

    public static int answer = 0;

    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N];

        items = new int[N][2];
        for (int[] item : items) {
            st = new StringTokenizer(br.readLine());
            item[0] = Integer.parseInt(st.nextToken()); //무게
            item[1] = Integer.parseInt(st.nextToken()); //가치
        }

        DFS(0,0,0);
        System.out.print(answer);
    }

    public static void DFS(int depth, int weight, int value) {
        if(depth==N){
            answer = Math.max(answer, value);
            return;
        }
        if(weight+items[depth][0] <= K){
            DFS(depth+1, weight+items[depth][0], value+items[depth][1]);
        }
        if(weight <= K){
            DFS(depth+1, weight, value);
        }
    }
}
