package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.14.
 * @notes - 단순 구현 문제 <br>
 * - 멍청아 continue 말고 break 썼어야지 ^^
 */

public class g4_17140_이차원배열과연산 {
    public static int MAX_SIZE = 100;
    public static int[][] A = new int[MAX_SIZE][MAX_SIZE];
    public static int rMax = 3, cMax = 3;
    public static int R, C, K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());

        // 초기값 입력받기
        for (int r = 0; r < rMax; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < cMax; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 연산 반복 수행
        int time;
        for (time = 0; time <= 101; time++) {
//            System.out.println(">>>> " + time);
//            for (int r = 0; r < MAX_SIZE; r++) {
//                for (int c = 0; c < MAX_SIZE; c++) {
//                    System.out.print(A[r][c] == 0 ? " . " : " " + A[r][c] + " ");
//                }
//                System.out.println();
//            }

            // 100초가 지나도 A[r][c] = k가 되지 않으면 -1을 출력
            if (time > 100) {
                time = -1;
                break;
            }

            // A[r][c]에 들어있는 값이 k가 되면 종료
            if (A[R][C] == K) {
                break;
            }

            // 연산 수행
            if (rMax >= cMax) {
//                System.out.println("r : " + rMax + " / c :" + cMax + " -> R연산");
                int newCMax = 0;
                for (int r = 0; r < rMax; r++) {
                    int size = calculateR(r);
                    newCMax = Math.max(newCMax, size);
                }
                cMax = newCMax;
            } else {
//                System.out.println("r : " + rMax + " / c :" + cMax + " -> C연산");
                int newRMax = 0;
                for (int c = 0; c < cMax; c++) {
                    int size = calculateC(c);
                    newRMax = Math.max(newRMax, size);
                }
                rMax = newRMax;
            }
        }

        // 결과 출력
        System.out.println(time);
    }

    // R연산
    private static int calculateR(int r) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        // 카운팅
        for (int c = 0; c < cMax; c++) {
            // 0은 연산에서 무시
            if (A[r][c] == 0)
                continue;

            // 카운팅
            counter.put(A[r][c], counter.getOrDefault(A[r][c], 0) + 1);
        }

        // 정렬
        PriorityQueue<Count> PQ = new PriorityQueue<>();
        for (int key : counter.keySet()) {
            PQ.add(new Count(key, counter.get(key)));
        }

        // 반환할 크기 저장
        int size = PQ.size() * 2;
        if (size > MAX_SIZE)
            size = MAX_SIZE;

        // 배열에 입력
        for (int c = 0; c < MAX_SIZE; c += 2) {
            if (!PQ.isEmpty()) {
                Count C = PQ.poll();
                A[r][c] = C.key;
                A[r][c + 1] = C.value;
            } else {
                A[r][c] = 0;
                A[r][c + 1] = 0;
            }
        }

        return size;
    }

    // C연산
    private static int calculateC(int c) {
        HashMap<Integer, Integer> counter = new HashMap<>();

        // 카운팅
        for (int r = 0; r < rMax; r++) {
            // 0은 연산에서 무시
            if (A[r][c] == 0)
                continue;

            // 카운팅
            counter.put(A[r][c], counter.getOrDefault(A[r][c], 0) + 1);
        }

        // 정렬
        PriorityQueue<Count> PQ = new PriorityQueue<>();
        for (int key : counter.keySet()) {
            PQ.add(new Count(key, counter.get(key)));
        }

        // 반환할 크기 저장
        int size = PQ.size() * 2;
        if (size > MAX_SIZE)
            size = MAX_SIZE;

        // 배열에 입력
        for (int r = 0; r < MAX_SIZE; r += 2) {
            if (!PQ.isEmpty()) {
                Count C = PQ.poll();
                A[r][c] = C.key;
                A[r + 1][c] = C.value;
            } else {
                A[r][c] = 0;
                A[r + 1][c] = 0;
            }
        }

        return size;
    }

    private static class Count implements Comparable<Count> {
        int key;
        int value;

        public Count(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Count c) {
            if (this.value != c.value)
                return this.value - c.value;
            return this.key - c.key;
        }
    }
}