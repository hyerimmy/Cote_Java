package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1932
 * @date 2023.12.11.
 * @notes - 빡구현 <br>
 */

public class g3_16236_아기상어 {
    public static int N; // 공간 크기
    public static int[][] map; // 공간 정보
    public static int[] sharkPosition; // 아기상어 위치
    public static int sharkSize = 2; // 아기상어 크기
    public static int sharkSizeGage = 0; // 아기상어 크기 게이지
    public static int resultTime = 0; // 최종 시간

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        // 상어, 물고기 정보 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    sharkPosition = new int[]{i, j};
                }
            }
        }

        // BFS 탐색
        boolean findFish = true;
        while (findFish) {
//            System.out.println("--------------");
            findFish = findAndEatFish();
        }

        // 결과 출력
        System.out.println(resultTime);
    }

    private static boolean findAndEatFish() {
        boolean findFish = false;
        Space resultSpace = new Space(new int[]{0, 0}, 0);

        // 먹을 수 있는 물고기 탐색 (BFS)
        Queue<Space> Q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        Q.add(new Space(sharkPosition, 0));
        visited[sharkPosition[0]][sharkPosition[1]] = true; // 방문 표시
        while (!Q.isEmpty()) {
            Space space = Q.poll();

//            // 물고기 찾았다면 반복 종료
//            if (findFish && resultSpace.time < space.time)
//                break;

            for (int d = 0; d < 4; d++) {
                int[] position = new int[]{space.position[0] + dx[d], space.position[1] + dy[d]};

                if (position[0] < 0 || position[0] >= N || position[1] < 0 || position[1] >= N)
                    continue;

                if (visited[position[0]][position[1]])
                    continue;

                if (map[position[0]][position[1]] != 0 && map[position[0]][position[1]] < sharkSize) { // 먹을 수 있다면
//                    System.out.println(Arrays.toString(position)+"찾았다!"+space.time);
                    if (!findFish) { // 처음 찾은 물고기라면
                        findFish = true;
                        resultSpace = new Space(position, space.time + 1);
//                        System.out.println("최초등록 - "+Arrays.toString(position));
                    } else { // 이미 찾은 물고기가 있다면
                        if(resultSpace.time < space.time + 1)
                            continue;
                        if ((resultSpace.position[0] > position[0])
                                || (resultSpace.position[0] == position[0] && resultSpace.position[1] > position[1])) {
                            // 더 위에 있거나 같은 높이이지만 더 왼쪽에 있다면 갱신
                            resultSpace = new Space(position, space.time + 1);
//                            System.out.println("갱신 - "+Arrays.toString(position));
                        }
                    }

                } else if (map[position[0]][position[1]] == 0 || map[position[0]][position[1]] == sharkSize) { // 지나갈 수만 있다면
                    if (findFish && resultSpace.time < space.time + 1)
                        continue;
                    Q.add(new Space(position, space.time + 1));
//                    System.out.println(Arrays.toString(position)+"넣는다!");
                }

                visited[position[0]][position[1]] = true; // 방문 표시
            }

        }

        // 물고기 먹기
        if (findFish) {
            map[resultSpace.position[0]][resultSpace.position[1]] = 0; // 빈칸으로 바꾸기
            sharkPosition = resultSpace.position; // 상어 위치 옮기기
            if (++sharkSizeGage == sharkSize) { // 상어 크기 상승
                sharkSize++;
                sharkSizeGage = 0;
            }
            resultTime += resultSpace.time; // 시간 증가
//            System.out.println("*" + Arrays.toString(resultSpace.position) + " / 시간 = " + resultTime + " / 게이지 = " + sharkSizeGage + " / 크기 = " + sharkSize);
        }

        return findFish;
    }

    private static class Space {
        int[] position;
        int time;

        public Space(int[] position, int time) {
            this.position = position;
            this.time = time;
        }
    }
}