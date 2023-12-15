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
 * @date 2023.12.14.
 * @notes - 백트래킹 문제<br>
 * - 어렵돠.. 백트래킹에 아직 더 익숙해져야 할듯<br>
 * - 시간초과.. -> 체스판을 싹 다 탐색하는게 아니라, 컬럼 별로 한개씩 말이 갈 수 있는 점을 활용해 컬럼별 탐색을 한다!!!!!!!!!아오머리야<br>
 */
public class g4_9663_NQueen {
    public static int N;
    public static int[] queenRowIdx;
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        queenRowIdx = new int[N + 1];

        setQueen(1);

        System.out.println(result);
    }

    public static void setQueen(int column) {
        if (column > N) {
            result++;
            return;
        }

        for (int row = 1; row <= N; row++) {
            if (possible(column, row)) {
                queenRowIdx[column] = row;
                setQueen(column + 1);
                queenRowIdx[column] = 0;
            }
        }
    }

    private static boolean possible(int column, int row) {
        for (int queenColumn = 1; queenColumn <= N; queenColumn++) {
            int queenRow = queenRowIdx[queenColumn];

            // 아직 없는 행이라면 제외
            if(queenRow == 0)
                continue;

            // 같은 행이라면
            if(row == queenRow)
                return false;

            // 같은 대각선상에 있다면
            if(Math.abs(queenRow - row) == Math.abs(queenColumn - column))
                return false;
        }

        return true;
    }
}
