package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.26
 * @notes - 그냥 빡구현 + 백트래킹<br>
 * - 여러 경우의 수 갈래 중에서 1~9가 아예 들어갈 수 없는 칸이 있다면 return 구문으로 종료를 해줘야!!!!!!100번째 줄 return 없어서 왕고생..
 */
public class g4_2239_스도쿠 {
    public static int[][] map = new int[9][9];

    public static boolean[][] rowN = new boolean[9][10];
    public static boolean[][] colN = new boolean[9][10];
    public static boolean[][] boxN = new boolean[9][10];

    public static int completeNcount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스도쿠 초기화
        for (int r = 0; r < 9; r++) {
            String rData = br.readLine();
            for (int c = 0; c < 9; c++) {
                int number = rData.charAt(c) - '0';

                if (number == 0) {
                    continue;
                }

                int boxIdx = 3 * (r / 3) + (c / 3);
                rowN[r][number] = true;
                colN[c][number] = true;
                boxN[boxIdx][number] = true;
                map[r][c] = number;
                completeNcount++;
            }
        }

        // 스도쿠 채우기
        setNumber(1);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void setNumber(int depth) {
        if (completeNcount == 81) {
            return;
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // 이미 채워진 칸이라면 건너뛰기
                if (map[r][c] != 0)
                    continue;

                // 숫자 1~9 중 들어갈 수 있는 숫자 선택해 BT 진행
                for (int number = 1; number <= 9; number++) {
                    int boxIdx = 3 * (r / 3) + (c / 3);

                    if (!rowN[r][number] && !colN[c][number] && !boxN[boxIdx][number]) {
//                        if (map[2][0] == 6)
//                            System.out.println(depth + " (" + r + ", " + c + ") = " + number + " / " + completeNcount);
                        rowN[r][number] = true;
                        colN[c][number] = true;
                        boxN[boxIdx][number] = true;
                        map[r][c] = number;
                        completeNcount++;

                        setNumber(depth + 1);

                        // 완성되었다면 종료
                        if (completeNcount == 81)
                            return;

                        // 아니라면 가지치기
                        rowN[r][number] = false;
                        colN[c][number] = false;
                        boxN[boxIdx][number] = false;
                        map[r][c] = 0;
                        completeNcount--;
                    }
                }

                return;
            }
        }
    }
}
