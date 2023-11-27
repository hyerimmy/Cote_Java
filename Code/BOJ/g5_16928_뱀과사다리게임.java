package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.26
 * @notes - 에센셜3++<br>
 * - 문제를 잘못 읽음. 0부터 시작하는 것이 아니라, 1부터 시작함.<br>
 * - 문제 또 잘못 읽음. 사다리와 뱀은 선택해서 타는 것이 아니라 해당 칸에 도착하면 반드시 이동을 해야 함.<br>
 */

public class g5_16928_뱀과사다리게임 {
    public static int[] event = new int[101]; // 뱀, 사다리 정보 배열
    public static int[] minCountA = new int[101];

    public static Queue<Integer> Q = new LinkedList<>();
    public static int answer = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사다리 개수
        int M = Integer.parseInt(st.nextToken()); // 뱀 개수


        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            event[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Q.add(1);
        while (!Q.isEmpty()) {
            int position = Q.poll();

            // 뱀이나 사다리를 통해 이동하는 경우
            if (event[position] != 0) {
                addMove(event[position], minCountA[position]);
            } else {
                // 주사위로 이동하는 경우
                for (int dice = 1; dice <= 6; dice++) {
                    addMove(position + dice, minCountA[position] + 1);
                }
            }

        }

        if (answer == 100)
            answer = -1;
        System.out.println(answer);

    }

    public static void addMove(int newPosition, int newCount) {
        if (newPosition == 100)
            answer = Math.min(answer, newCount);
        else if (newPosition < 100 && (minCountA[newPosition] > newCount || minCountA[newPosition] == 0)) {
            Q.add(newPosition);
            minCountA[newPosition] = newCount;
        }
    }
}
