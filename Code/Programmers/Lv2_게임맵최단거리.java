package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @title Lv2 게임맵최단거리
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * @date 2023.09.03
 * @notes
 * - BFS 활용 <br>
 * - 이 문제는 최단 경로를 찾는 문제로 BFS와 DFS 중 BFS가 더 유리하다.
 * 그 이유는 DFS는 모든 경로를 탐색한 후 거리를 비교해야하는 반면 BFS는 탐색 도중 타겟이 발견되면 바로 종료할 수 있기 때문이다. <br>
 * - N이랑 M 거꾸로 써서 시간초과!! 주의하자!! <br>
 * - visited 함수를 for 구문 안에서 쓰니까 시간 효율 통과함. 왜? <br>
 * */

class Lv2_게임맵최단거리 {
    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }

    static int[][] A;
    static int N, M;
    static boolean[][] visited;
    static Queue<int[]> queue;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    public static int solution(int[][] maps) {
        A = maps;
        N = A[0].length;
        M = A.length;

        visited = new boolean[N][M];
        queue = new LinkedList<>();
        BFS(0, 0);

        if (A[N - 1][M - 1] < 2) {
            return -1;
        }
        return A[N - 1][M - 1];
    }

    private static void BFS(int x, int y) {
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int k=0;k<4;k++){
                int newX = now[0]+dx[k];
                int newY = now[1]+dy[k];
                if (newX>=0 && newY>=0 && newX< N && newY< M){
                    if(A[newX][newY]!=0 && !visited[newX][newY]){
                        A[newX][newY]=A[now[0]][now[1]]+1;
                        queue.add(new int[] {newX,newY});
                        visited[newX][newY] = true;
                        if (newX==N-1 && newY==M-1){
                            break;
                        }
                    }
                }
            }
        }

    }
}


