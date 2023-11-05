package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05
 * @notes
 */

public class s5_1018_체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] B = new char[N][M];
        for (int n = 0; n < N; n++) {
            String boardRow = br.readLine();
            for (int m = 0; m < M; m++) {
                B[n][m] = boardRow.charAt(m);
            }
        }

        int answer = 65;
//        boolean startOnWhite = true;

        ArrayList<Boolean> startOnWhitePool = new ArrayList<>();
        startOnWhitePool.add(true);
        startOnWhitePool.add(false);

        for(boolean startOnWhite : startOnWhitePool) {
            boolean[][] needPaint = new boolean[N][M];
            for (int n = 0; n < N; n++) {
                boolean white = startOnWhite;
                if(n%2 != 0)
                    white = !startOnWhite;

                for (int m = 0; m < M; m++) {
                    if (!(white && B[n][m] == 'W') && !(!white && B[n][m] == 'B'))
                        needPaint[n][m] = true;
                    white = !white;
                }
            }

            for(int startN = 0; startN <= N-8; startN++){
                for(int startM = 0; startM <= M-8; startM++){
                    answer = Math.min(answer, getPaintingCount(needPaint, startN, startM));
                }
            }
        }

        System.out.println(answer);
    }

    public static int getPaintingCount(boolean[][] needPaint, int startN, int startM){
        int count = 0;
        for (int n = startN; n < startN+8; n++) {
            for (int m = startM; m < startM+8; m++) {
                if(needPaint[n][m]) count++;
            }
        }
        return count;
    }
}