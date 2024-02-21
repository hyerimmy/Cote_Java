package BOJ;

import javax.swing.text.Position;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.21
 * @notes - 오타때문에 틀렸음. 문제 조건 잘 옮겼는지 확인 (100 대신 10 써서 틀림..) <br>
 */

public class g5_21608_상어초등학교 {
    public static int[] dR = new int[]{0, 0, 1, -1};
    public static int[] dC = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        HashMap<Integer, List<Integer>> studentLikeMap = new HashMap<>();

        for (int n = 0; n < N * N; n++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            List<Integer> likeStudents = new ArrayList<Integer>();
            likeStudents.add(Integer.parseInt(st.nextToken()));
            likeStudents.add(Integer.parseInt(st.nextToken()));
            likeStudents.add(Integer.parseInt(st.nextToken()));
            likeStudents.add(Integer.parseInt(st.nextToken()));
            studentLikeMap.put(student, likeStudents);

            List<Position> positionList = new ArrayList<>();

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    // 이미 정해진 자리라면 건너뛰기
                    if (map[row][col] != 0)
                        continue;

                    // 인접 칸 확인 - 좋아하는 학생수, 빈칸 수
                    int likeCount = 0;
                    int blackCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int newR = row + dR[d];
                        int newC = col + dC[d];

                        // 범위 벗어난다면 건너뛰기
                        if (newR < 0 || newR >= N || newC < 0 || newC >= N)
                            continue;

                        // 빈칸 수, 좋아하는 학생 수 카운팅
                        if (map[newR][newC] == 0) {
                            blackCount++;
                        } else if (likeStudents.contains(map[newR][newC])) {
                            likeCount++;
                        }
                    }

                    // 칸 리스트에 넣기
                    positionList.add(new Position(row, col, likeCount, blackCount));
                }
            }

            Collections.sort(positionList);
            Position resultP = positionList.get(0);
            map[resultP.row][resultP.col] = student;
        }

        // 만족도 집계
        int result = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                int student = map[row][col];

                int likeCount = 0;
                for (int d = 0; d < 4; d++) {
                    int newR = row + dR[d];
                    int newC = col + dC[d];

                    // 범위 벗어난다면 건너뛰기
                    if (newR < 0 || newR >= N || newC < 0 || newC >= N)
                        continue;

                    // 좋아하는 학생 수 카운팅
                    if (studentLikeMap.get(student).contains(map[newR][newC])) {
                        likeCount++;
                    }
                }

                if (likeCount == 1)
                    result += 1;
                else if (likeCount == 2)
                    result += 10;
                else if (likeCount == 3)
                    result += 100;
                else if (likeCount == 4)
                    result += 1000;
            }
        }

        // 결과 출력
        System.out.println(result);

//        for (int row = 0; row < N; row++) {
//            System.out.println(Arrays.toString(map[row]));
//        }
    }

    private static class Position implements Comparable<Position> {
        int row, col, likeCount, blankCount;

        public Position(int row, int col, int likeCount, int blankCount) {
            this.row = row;
            this.col = col;
            this.likeCount = likeCount;
            this.blankCount = blankCount;
        }

        @Override
        public int compareTo(Position p) {
            if (this.likeCount != p.likeCount)
                return p.likeCount - this.likeCount;
            if (this.blankCount != p.blankCount)
                return p.blankCount - this.blankCount;
            if (this.row != p.row)
                return this.row - p.row;
            return this.col - p.col;
        }
    }
}