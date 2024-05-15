package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/5014
 * @date 2024.05.15
 * @notes - 아직 실력 죽지 않아쒀~~ <br>
 */

public class s1_5014_스타트링크 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int MIN_FLOOR = 1;
        int MAX_FLOOR = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX_FLOOR + 1];

        int START_FLOOR = Integer.parseInt(st.nextToken());
        int GOAL_FLOOR = Integer.parseInt(st.nextToken());

        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int minCount = Integer.MAX_VALUE;

        Queue<Move> Q = new LinkedList<>();
        Q.add(new Move(START_FLOOR, 0));
        visited[START_FLOOR] = true;

        while (!Q.isEmpty()) {
            Move current = Q.poll();

            // 목표한 층이라면 결과값 갱신
            if (current.floor == GOAL_FLOOR) {
                minCount = Math.min(minCount, current.count);
                continue;
            }

            // 위로 이동
            if (current.floor + U <= MAX_FLOOR && !visited[current.floor + U]) {
                Q.add(new Move(current.floor + U, current.count + 1));
                visited[current.floor + U] = true;
            }

            // 아래로 이동
            if (current.floor - D >= MIN_FLOOR && !visited[current.floor - D]) {
                Q.add(new Move(current.floor - D, current.count + 1));
                visited[current.floor - D] = true;
            }
        }

        if (minCount != Integer.MAX_VALUE) {
            System.out.println(minCount);
        } else {
            System.out.println("use the stairs");
        }
    }

    private static class Move {
        int floor;
        int count;

        public Move(int floor, int count) {
            this.floor = floor;
            this.count = count;
        }
    }
}

