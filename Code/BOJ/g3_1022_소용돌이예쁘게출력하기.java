package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1022
 * @date 2024.04.07 - 08
 * @notes - <br>
 */

public class g3_1022_소용돌이예쁘게출력하기 {
    public static int r1, r2, c1, c2;

    public static int[][] numbers; // 소용돌이배열
    public static int maxValue = 0;
    public static int[] dx = new int[]{0, -1, 0, 1};
    public static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        numbers = new int[r2 - r1 + 1][c2 - c1 + 1];

        // 소용돌이 배열 완성하기
        setNumbers();

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        int maxLength = String.valueOf(maxValue).length();
        for (int r = 0; r < r2 - r1 + 1; r++) {
            for (int c = 0; c < c2 - c1 + 1; c++) {
                String numberS = String.valueOf(numbers[r][c]);
                int blankCnt = maxLength - numberS.length();
                for (int cnt = 0; cnt < blankCnt; cnt++) {
                    sb.append(" ");
                }
                sb.append(numberS).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void setNumbers() {
        int number = 1;
        int gap = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        int times = 2;

        while (x <= 5000 && x >= -5000 && y <= 5000 && y >= -5000) {
            // 갭만큼 반복하며 숫자 채우기
            for (int g = 0; g < gap; g++) {
                if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
                    numbers[x - r1][y - c1] = number;
                    maxValue = Math.max(maxValue, number);
                }

                x += dx[d];
                y += dy[d];
                number++;

//                if (number < 13)
//                    System.out.printf("(%d, %d) = %d%n", x, y, number);
            }

            // 갭 다 채웠다면 방향 전환
            d = d == 3 ? 0 : d + 1;
            times--;

            // 2번 반복했다면 갭 늘리기
            if (times == 0) {
                gap++;
                times = 2;
            }
        }
    }
}

