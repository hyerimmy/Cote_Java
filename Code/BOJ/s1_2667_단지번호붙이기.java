
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes - 에센셜3++ <br>
 */

public class s1_2667_단지번호붙이기 {
    public static int N;
    public static boolean[][] home;

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        home = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String rowData = br.readLine();
            for (int j = 0; j < N; j++) {
                if (rowData.charAt(j) == '1')
                    home[i][j] = true;
            }
        }

        List<Integer> answerL = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (home[i][j])
                    answerL.add(BFS(i, j));
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answerL.size()).append("\n");

        Collections.sort(answerL);
        for (int answer : answerL) {
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static int BFS(int i, int j) {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{i, j});

        int answer = 0;

        while (!Q.isEmpty()) {
            int[] H = Q.poll();

            if(home[H[0]][H[1]]){
                answer++;
                home[H[0]][H[1]] = false;

                for (int t = 0; t < 4; t++) {
                    int newI = H[0] + dx[t];
                    int newJ = H[1] + dy[t];
                    if (newI >= 0 && newI < N && newJ >= 0 && newJ < N) {
                        Q.add(new int[]{newI, newJ});
                    }
                }
            }
        }
        return answer;
    }
}