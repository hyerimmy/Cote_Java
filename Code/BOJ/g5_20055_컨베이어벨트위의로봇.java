package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/20055
 * @date 2024.02.06.
 * @notes - 내리는 위치가!!!!! 2N이 아니라 N이다.. 바보야..
 */

public class g5_20055_컨베이어벨트위의로봇 {
    public static int N, K;
    public static int beltSize;
    public static int[] power;
    public static boolean[] isFull;
    public static int startIdx = 0; // 컨베이어 벨트의 시작 (올리는 곳) 인덱스
    public static int dieCount = 0;
    public static int level; // 진행중인 단계

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        beltSize = 2 * N;
        power = new int[beltSize];
        isFull = new boolean[beltSize];

        // 내구도 입력받기
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < beltSize; n++) {
            power[n] = Integer.parseInt(st.nextToken());
        }

        while (dieCount < K) {
            level++; // 단계 카운팅

            // 1. 벨트 회전
            startIdx = getPrevIdx(startIdx);
            removeRobot(); // 만약 내리는 칸에 로봇 있다면 내린다.

            // 2. 벨트 위 로봇 이동
            for (int idx = getEndIdx(); idx != startIdx; idx = getPrevIdx(idx)) { // (마지막 -> 처음 방향)
                // 해당 벨트에 로봇이 없다면 건너뛴다
                if (!isFull[idx])
                    continue;

                int nextIdx = getNextIdx(idx);

                // 로봇 한 칸 이동한다
                if (power[nextIdx] > 0 && !isFull[nextIdx]) {
                    power[nextIdx]--;
                    isFull[idx] = false;
                    isFull[nextIdx] = true;

                    if (power[nextIdx] == 0) dieCount++;
                }

                // 만약 내리는 칸에 로봇 있다면 내린다.
                removeRobot();
            }


            // 3. 로봇 올리기
            if (power[startIdx] > 0) {
                power[startIdx]--;
                isFull[startIdx] = true;

                if (power[startIdx] == 0) dieCount++;
            }

//            System.out.println("==" + level);
//            System.out.println(Arrays.toString(power) + " - " + startIdx + "\n" + Arrays.toString(isFull));
        }

        System.out.println(level);
    }

    private static void removeRobot() {
        int removeIdx = startIdx + N - 1;
        if (removeIdx >= beltSize)
            removeIdx -= 2 * N;

        if (isFull[removeIdx]) {
            isFull[removeIdx] = false;
        }
    }

    private static int getNextIdx(int idx) {
        idx++;
        if (idx == beltSize) return 0;
        return idx;
    }

    private static int getPrevIdx(int idx) {
        idx--;
        if (idx == -1) return beltSize - 1;
        return idx;
    }

    private static int getEndIdx() {
        return getPrevIdx(startIdx);
    }
}