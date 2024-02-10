package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.09/
 * @notes - 빡구현.. 조건 잘 고려해서 케이스 세분화해서 꼼꼼히 나누는게 정말 중요!!!<br>
 */

public class g3_14890_경사로 {
    public static int L;

    public static int height;
    public static int count;
    public static boolean needLoad = false; // 뒤에 경사로가 필요한 경우
    public static boolean canPass = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

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
            height = map[row][0];
            count = 1;
            needLoad = false; // 뒤에 경사로가 필요한가
            canPass = true;

            for (int col = 1; col < N; col++) {
                canPass = checkCanPass(map[row][col]);
                if (!canPass) break;
//                System.out.print("(" + row + ", " + col + ")");
            }

            if (needLoad) canPass = false; // 경사로를 미처 다 놓지 못했다면 이동불가 처리
            if (canPass) result++;
//            System.out.println();
//            System.out.println("[row " + row + "] -> " + canPass);
        }

        // 각 열 체크하기
        for (int col = 0; col < N; col++) {
            height = map[0][col];
            count = 1;
            needLoad = false; // 뒤에 경사로가 필요한가
            canPass = true;

            for (int row = 1; row < N; row++) {
                canPass = checkCanPass(map[row][col]);
                if (!canPass) break;
            }

            if (needLoad) canPass = false; // 경사로를 미처 다 놓지 못했다면 이동불가 처리
            if (canPass) result++;
//            System.out.println("[col " + col + "] -> " + canPass);
        }

        // 결과출력
        System.out.println(result);
    }

    private static boolean checkCanPass(int current) {
        if (current == height) { // 이전과 똑같은 높이의 칸이라면
            count++;

            if (needLoad && count >= L) { // 경사로가 필요했는데 해결할 수 있다면
                needLoad = false;
                count = 0;
            }
        } else { // 이전과 다른 높이의 칸이라면
            if (needLoad) { // 경사로가 필요했는데 해결을 못했다면
                canPass = false;
            }

            if (current - height == 1) { // 이전보다 1칸 높은 칸이라면
                if (count < L) { // 앞에 경사로를 놓을 수 없다면
                    canPass = false;
                } else { // 앞에 경사로를 놓을 수 있다면
                    height = current;
                    count = 1;
                }
            } else if (current - height == -1) { // 이전보다 1칸 낮은 칸이라면
                height = current;
                needLoad = true;
                count = 1;
            } else { // 2칸 이상 차이가 난다면
                canPass = false;
            }
        }

        if (needLoad && count >= L) { // 경사로가 필요했는데 해결할 수 있다면
            needLoad = false;
            count = 0;
        }

        return canPass;
    }
}