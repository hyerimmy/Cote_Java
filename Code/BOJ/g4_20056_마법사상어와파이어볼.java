package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes -  <br>
 */

public class g4_20056_마법사상어와파이어볼 {
    public static int N, K;
    public static FireBall[][] map;

    public static int[] dRow = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dCol = new int[]{0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new FireBall[N][N];
        Queue<FireBall> Q = new LinkedList<>();

        // 파이어볼 입력받기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            Q.add(new FireBall(row, col, weight, speed, direction));
        }

        // K번 반복
        for (int time = 1; time <= K; time++) {
//            System.out.println(time);
            // 파이어볼 이동해서 map에 배치
            while (!Q.isEmpty()) {
                FireBall fireBall = Q.poll();
                int[] newP = getNewPosition(fireBall.row, fireBall.col, fireBall.direction, fireBall.speed);
//                System.out.println(Arrays.toString(newP));

                if (map[newP[0]][newP[1]] == null) {
                    map[newP[0]][newP[1]] = new FireBall(newP[0], newP[1], fireBall.weightSum, fireBall.speed, fireBall.direction);
                } else {
                    map[newP[0]][newP[1]].addBall(fireBall.weightSum, fireBall.speed, fireBall.direction);
                }
            }

            // 나누기
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    // 파이어볼이 없다면 건너뛰기
                    if (map[row][col] == null)
                        continue;

                    // 파이어볼 있다면 나누어 배치
                    FireBall fireBall = map[row][col];

                    // map 초기화
                    map[row][col] = null;

                    // 파이어볼이 2개 이상 있지 않다면 그대로 넣기
                    if (fireBall.ballCount < 2) {
                        Q.add(new FireBall(row, col, fireBall.weightSum, fireBall.speedSum, fireBall.direction));
                        continue;
                    }

                    // 나눌 파이어볼 무게, 속력 계산
                    int newWeight = fireBall.weightSum / 5;
                    int newSpeed = fireBall.speedSum / fireBall.ballCount;

                    // 무게가 0이라면 건너뛰기
                    if (newWeight == 0)
                        continue;

                    // 나눌 방향 계산
                    int[] directions;
                    if (fireBall.directionTotal >= 0)
                        directions = new int[]{0, 2, 4, 6};
                    else
                        directions = new int[]{1, 3, 5, 7};

                    // 나누기
                    for (int direction : directions)
                        Q.add(new FireBall(row, col, newWeight, newSpeed, direction));
                }
            }
        }

        // 남아있는 파이어볼 질량
        int result = 0;
        while (!Q.isEmpty()) {
            FireBall fireBall = Q.poll();
            result += fireBall.weightSum;
        }

        // 결과 출력
        System.out.println(result);
    }

    private static int[] getNewPosition(int row, int col, int direction, int speed) {
//        System.out.println(row + ", " + col + " & d = " + direction + " & s = " + speed);
        row += (dRow[direction] * speed);
        col += (dCol[direction] * speed);

        while (row >= N) row -= N;
        while (row <= -1) row += N;
        while (col >= N) col -= N;
        while (col <= -1) col += N;

//        System.out.println("=>" + row + ", " + col);

        return new int[]{row, col};
    }

    private static class FireBall {
        int row, col;
        int weightSum; // 무게 합
        int speed; // 속력
        int speedSum; // 속력 합
        int direction; // 방향
        int directionTotal; // -1 제각각, 0 짝수, 1 홀수
        int ballCount = 0; // 합쳐진 파이어볼 개수

        public FireBall(int row, int col, int weight, int speed, int direction) {
            this.row = row;
            this.col = col;
            this.weightSum = weight;
            this.speed = speed;
            this.speedSum = speed;
            this.direction = direction;
            this.directionTotal = direction % 2;
            this.ballCount++;
        }

        public void addBall(int weight, int speed, int direction) {
            this.weightSum += weight;
            this.speedSum += speed;
            if (this.directionTotal != direction % 2)
                this.directionTotal = -1;
            this.ballCount++;
        }
    }
}