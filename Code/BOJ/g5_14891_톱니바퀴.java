package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.05.
 * @notes
 */


public class g5_14891_톱니바퀴 {
    public static int[] leftIdx = new int[]{6, 6, 6, 6};
    public static int[] rightIdx = new int[]{2, 2, 2, 2};
    public static int[] topIdx = new int[]{0, 0, 0, 0};
    public static int[][] wheelData = new int[4][8];
    public static boolean[] rotated = new boolean[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톰니바퀴에 대한 정보 입력받기
        for (int wheel = 0; wheel < 4; wheel++) {
            String inputData = br.readLine();
            for (int w = 0; w < 8; w++)
                wheelData[wheel][w] = inputData.charAt(w) - '0';
        }

        // 회전 횟수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        // 바퀴 회전시키기
        for (int k = 0; k < K; k++) {
            rotated = new boolean[4];
            st = new StringTokenizer(br.readLine());
            rotateWheel(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
        }

        // 결과 출력하기
        int result = 0;
        result += wheelData[0][topIdx[0]];
        result += wheelData[1][topIdx[1]] * 2;
        result += wheelData[2][topIdx[2]] * 4;
        result += wheelData[3][topIdx[3]] * 8;
        System.out.println(result);
    }

    private static void rotateWheel(int wheelIdx, int direction) {
        if (rotated[wheelIdx])
            return;

        rotated[wheelIdx] = true;

        // 왼쪽에 톱니바퀴가 있고 서로 반대극이라면
        if (wheelIdx >= 1 && getLeftWheelNumber(wheelIdx) != getRightWheelNumber(wheelIdx - 1)) {
            rotateWheel(wheelIdx - 1, direction * -1);
        }

        // 오른쪽에 톱니바퀴가 있고 서로 반대극이라면
        if (wheelIdx <= 2 && getRightWheelNumber(wheelIdx) != getLeftWheelNumber(wheelIdx + 1)) {
            rotateWheel(wheelIdx + 1, direction * -1);
        }

        // 현재 톱니바퀴 움직이기
        if (direction == -1) {
            leftIdx[wheelIdx] = add(leftIdx[wheelIdx]);
            rightIdx[wheelIdx] = add(rightIdx[wheelIdx]);
            topIdx[wheelIdx] = add(topIdx[wheelIdx]);
        } else if (direction == 1) {
            leftIdx[wheelIdx] = minus(leftIdx[wheelIdx]);
            rightIdx[wheelIdx] = minus(rightIdx[wheelIdx]);
            topIdx[wheelIdx] = minus(topIdx[wheelIdx]);
        }
    }

    private static int getLeftWheelNumber(int wheelIdx) {
        return wheelData[wheelIdx][leftIdx[wheelIdx]];
    }

    private static int getRightWheelNumber(int wheelIdx) {
        return wheelData[wheelIdx][rightIdx[wheelIdx]];
    }

    private static int add(int wheelIdx) {
        if (wheelIdx + 1 == 8)
            return 0;
        return wheelIdx + 1;
    }

    private static int minus(int wheelIdx) {
        if (wheelIdx - 1 == -1)
            return 7;
        return wheelIdx - 1;
    }
}