package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.01.03.
 * @notes - 삼성 SW 역량테스트 문제집 <br>
 */

public class g4_3190_뱀 {
    public static int N; // 보드 크기
    public static int[][] board; // 보드 (사과 1, 뱀 2)
    public static HashMap<Integer, Character> directionMap = new HashMap<>(); // 방향 정보

    public static int time = 0; // 게임 시간
    public static Queue<int[]> snakeBody = new LinkedList<>(); // 뱀이 위치한 칸
    public static int[] snakeHead = new int[]{1, 1};
    public static int dIndex = 0; // 이동 방향 인덱스

    public static int[] dRow = new int[]{0, 1, 0, -1}; // 행 이동
    public static int[] dColumn = new int[]{1, 0, -1, 0}; // 열 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N + 1][N + 1];
        snakeBody.add(snakeHead);

        // 사과 입력받기
        st = new StringTokenizer(br.readLine());
        int appleN = Integer.parseInt(st.nextToken());
        for (int a = 0; a < appleN; a++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        // 방향 정보 입력받기
        st = new StringTokenizer(br.readLine());
        int directionN = Integer.parseInt(st.nextToken());
        for (int d = 0; d < directionN; d++) {
            st = new StringTokenizer(br.readLine());
            directionMap.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        while (move()) {
            time++;
//            System.out.println(time);
        }

        System.out.println(time + 1);
    }

    private static boolean move() {
        // 방향 갱신
        if (directionMap.containsKey(time)) {
            if (directionMap.get(time) == 'D') { // 오른쪽 회전
                dIndex++;
                if (dIndex == 4) dIndex = 0;
            } else if (directionMap.get(time) == 'L') { // 왼쪽 회전
                dIndex--;
                if (dIndex == -1) dIndex = 3;
            }
        }

        // 새로 이동한 좌표 계산
        int[] S = new int[]{snakeHead[0] + dRow[dIndex], snakeHead[1] + dColumn[dIndex]};
//        System.out.println(time+1 + " "+Arrays.toString(S));

        // 범위를 벗어난다면 종료
        if (S[0] < 1 || S[0] > N || S[1] < 1 || S[1] > N)
            return false;

        // 뱀 꼬리랑 닿는다면 종료
        if (board[S[0]][S[1]] == 2)
            return false;

        // 만약 사과가 없다면 뱀 꼬리 자르기
        if (board[S[0]][S[1]] != 1) {
            int[] snakeTail = snakeBody.poll();
            board[snakeTail[0]][snakeTail[1]] = 0;
        }

        // 뱀 몸 좌표 갱신
        board[S[0]][S[1]] = 2;
        snakeBody.add(S);
        snakeHead = S;

        return true;
    }
}