package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.09/
 * @notes - <br>
 */

public class failed_g3_14890_경사로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        int result = 0;

        // 지도 입력받기
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 줄 체크하기
        for (int row = 0; row < N; row++) {
            boolean canPass = true;
            int length = 1; // 연속된 평지 길이

            for (int col = 1; col < N; col++) {
                // 이전과 높이가 같다면
                if (map[row][col] == map[row][col - 1]) {
                    length++; // 평지 길이 추가
                    continue;
                }

                // 높아지는 경사로 놓을 상황이라면 (높이가 1 높으면서 평지 길이가 경사로 길이 이상)
                if (map[row][col] == map[row][col - 1] + 1 && length >= L) {
                    length = 0;
                    continue;
                }

                // 낮아지는 경사로 놓을 상황이라면 (높이가 1 낮으면서 다음에 올 평지 길이가 경사로 길이 이상)
                if (map[row][col] == map[row][col - 1] - 1 && col + L - 1 < N) {
                    for (int c = 1; c < L; c++) {
                        if (map[row][col + c] != map[row][col]) {
                            canPass = false;
                            break;
                        }
                    }

                    if (!canPass) {
                        break;
                    }

                    col = col + L;
                    length = 1;
                    continue;
                }

                // 경사로를 놓을 수 없는 상황이라면
                canPass = false;
                break;
            }

            if (canPass)
                result++;
            System.out.println("row " + row + " -> " + canPass);
        }

        // 각 열 체크하기
        for (int col = 0; col < N; col++) {
            boolean canPass = true;
            int length = 1; // 연속된 평지 길이

            for (int row = 1; row < N; row++) {
                // 이전과 높이가 같다면
                if (map[row][col] == map[row - 1][col]) {
                    length++; // 평지 길이 추가
                    continue;
                }

                // 높아지는 경사로 놓을 상황이라면 (높이가 1 높으면서 평지 길이가 경사로 길이 이상)
                if (map[row][col] == map[row - 1][col] + 1 && length >= L) {
                    length = 0;
                    continue;
                }

                // 낮아지는 경사로 놓을 상황이라면 (높이가 1 낮으면서 다음에 올 평지 길이가 경사로 길이 이상)
                if (map[row][col] == map[row - 1][col] - 1 && row + L - 1 < N) {
                    for (int r = 1; r < L; r++) {
                        if (map[row + r][col] != map[row][col]) {
                            canPass = false;
                            break;
                        }
                    }

                    if (!canPass) {
                        break;
                    }

                    row = row + L;
                    length = 1;
                    continue;
                }

                // 경사로를 놓을 수 없는 상황이라면
                canPass = false;
                break;
            }

            if (canPass)
                result++;
            System.out.println("col " + col + " -> " + canPass);
        }

        // 결과출력
        System.out.println(result);
    }
}