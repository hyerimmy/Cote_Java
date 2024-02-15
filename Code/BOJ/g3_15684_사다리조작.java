package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.15.
 * @notes - 백트래킹으로 풀어보자. (알고리즘 힌트 안 봄) -> 맞네!
 */

public class g3_15684_사다리조작 {
    public static int W, H;
    public static boolean[][] existRightBridge; // 오른쪽 다리 여부
    public static int bridgeCount = 0; // 다리 설치 개수
    public static int minBridgeCount = 4; // 최소 다리 설치 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 세로선 개수 (가로 길이)
        int M = Integer.parseInt(st.nextToken()); // 현재 설치된 사다리 개수
        H = Integer.parseInt(st.nextToken()); // 가로선 개수 (세로 길이)

        existRightBridge = new boolean[H][W + 1];

        // 사다리 초기값 입력
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            existRightBridge[a - 1][b] = true;
        }

        // 이미 정답이라면 반환
        if (isCorrect()) {
            minBridgeCount = 0;
        } else {
            setBridge(0, 1);
        }

        // 결과 출력
        if (minBridgeCount == 4)
            minBridgeCount = -1;
        System.out.println(minBridgeCount);
    }

    private static void setBridge(int startH, int startW) {
        // 다리 3개 초과로 놓을 수 없으므로 종료
        if (bridgeCount == 3)
            return;

        // 반복문 돌며 사다리 추가, 백트래킹 탐색
        for (int h = startH; h < H; h++) {
            if (h != startH) startW = 1;
            for (int w = startW; w < W; w++) {
                if (!existRightBridge[h][w - 1] && !existRightBridge[h][w] && !existRightBridge[h][w + 1]) {
//                    System.out.print("(" + h + ", " + w + ")");
                    existRightBridge[h][w] = true;
                    bridgeCount++;
                    if (isCorrect())
                        minBridgeCount = Math.min(minBridgeCount, bridgeCount);

                    setBridge(h, w);

                    existRightBridge[h][w] = false;
                    bridgeCount--;
                }
            }
        }
    }

    private static boolean isCorrect() {
        // 결과값 초기화
        int[] resultA = new int[W + 1];
        for (int w = 1; w <= W; w++) {
            resultA[w] = w;
        }

        // 다리가 있다면 결과 교환
        for (int h = 0; h < H; h++) {
            for (int w = 1; w <= W; w++) {
                if (existRightBridge[h][w - 1]) {
                    int temp = resultA[w];
                    resultA[w] = resultA[w - 1];
                    resultA[w - 1] = temp;
                }
            }
        }

        // 결과 집계
        boolean result = true;
        for (int w = 1; w <= W; w++) {
            if (resultA[w] != w) {
                result = false;
                break;
            }
        }

//        System.out.println("[" + bridgeCount + "] " + Arrays.toString(resultA) + " -> " + result);
        return result;
    }
}